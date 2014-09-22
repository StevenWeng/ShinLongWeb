package com.wengs.web.controller.management;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.DocumentException;
import com.wengs.web.model.entity.Coupon;
import com.wengs.web.model.service.CouponService;
import com.wengs.web.util.ImageUtil;
import com.wengs.web.util.PdfUtil;

@Controller
@RequestMapping(value = "/management/coupon")
public class CouponManagementController {
	@Autowired
	private CouponService couponService;
	@Autowired
	private String baseDir;

	@RequestMapping(value = "list")
	public String listAllCoupon(Model model) {
		List<Coupon> coupons = getCouponService().listAllCoupon();
		model.addAttribute("coupons", coupons);
		return "couponManagementList";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createCoupon() {
		return "couponManagementEditor";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editCoupon(@PathVariable Long id, Model model) {
		Coupon coupon = getCouponService().getCouponById(id);
		model.addAttribute("coupon", coupon);
		return "couponManagementEditor";
	}

	@RequestMapping(value = "createOrUpdate", method = RequestMethod.POST)
	public String createOrUpdateCoupon(
			@RequestParam("id") Long id,
			@RequestParam("title") String title,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("thumbImageFile") MultipartFile thumbImageFile,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
			Model model) {
		if (imageFile.isEmpty() || thumbImageFile.isEmpty()) {
			model.addAttribute("errorMessage", "Files are empty.");
			if (id != null) {
				model.addAttribute("coupon",
						getCouponService().getCouponById(id));
			}
			return "couponManagementEditor";
		}
		// save files
		Date nowDate = new Date();
		String imagePath = "images/coupon-image"
				+ nowDate.getTime()
				+ "."
				+ ImageUtil.getFormat(imageFile.getOriginalFilename())
						.toLowerCase();
		String thumbImagePath = "images/coupon-thumb-image"
				+ nowDate.getTime()
				+ "."
				+ ImageUtil.getFormat(thumbImageFile.getOriginalFilename())
						.toLowerCase();
		String pdfPath = "pdf/coupon-" + nowDate.getTime() + ".pdf";
		try {
			ImageUtil.saveImage(ImageIO.read(imageFile.getInputStream()),
					new File(getBaseDir(), imagePath));
			ImageUtil.saveImage(ImageIO.read(thumbImageFile.getInputStream()),
					new File(getBaseDir(), thumbImagePath));
			PdfUtil.saveToPdf(ImageIO.read(imageFile.getInputStream()),
					new File(getBaseDir(), pdfPath));
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",
					"Files save error :" + e.getMessage());
			if (id != null) {
				model.addAttribute("coupon",
						getCouponService().getCouponById(id));
			}
			return "couponManagementEditor";
		}
		// create or update
		Coupon coupon = new Coupon();
		coupon.setId(id);
		coupon.setTitle(title);
		coupon.setImagePath(imagePath);
		coupon.setThumbImagePath(thumbImagePath);
		coupon.setPdfPath(pdfPath);
		coupon.setStartDate(startDate);
		coupon.setEndDate(endDate);
		getCouponService().createOrUpdateCoupon(coupon);
		return "redirect:/management/coupon/list";
	}

	public CouponService getCouponService() {
		return couponService;
	}

	public void setCouponService(CouponService couponService) {
		this.couponService = couponService;
	}

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}
}
