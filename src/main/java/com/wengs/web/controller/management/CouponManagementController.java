package com.wengs.web.controller.management;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.pdf.codec.Base64;
import com.wengs.web.model.entity.Coupon;
import com.wengs.web.model.service.CouponService;

@Controller
@RequestMapping(value = "/management/coupon")
public class CouponManagementController {
	@Autowired
	private CouponService couponService;

	@RequestMapping(value = "list")
	public String listAllCoupon(Model model) {
		List<Coupon> coupons = getCouponService().listAllCoupon();
		model.addAttribute("coupons", coupons);
		return "couponManagementList";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createCoupon() {
		return "couponManagementCreator";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createCoupon(
			@RequestParam("title") String title,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("thumbImageFile") MultipartFile thumbImageFile,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
			Model model) {
		if (imageFile.isEmpty() || thumbImageFile.isEmpty()) {
			model.addAttribute("errorMessage", "Files are empty.");
			return "couponManagementCreator";
		}

		String imagePath = "images/" + imageFile.getOriginalFilename();

		String thumbImagePath = "images/"
				+ thumbImageFile.getOriginalFilename();
		String pdfPath = "pdf/"
				+ Base64.encodeObject(imageFile.getOriginalFilename()) + ".pdf";
		// create
		Coupon coupon = new Coupon();
		coupon.setTitle(title);
		coupon.setImagePath(imagePath);
		coupon.setThumbImagePath(thumbImagePath);
		coupon.setPdfPath(pdfPath);
		coupon.setStartDate(startDate);
		coupon.setEndDate(endDate);
		try {
			getCouponService().saveResourceFiles(coupon, imageFile,
					thumbImageFile);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",
					"Files save error :" + e.getMessage());
			return "couponManagementCreator";
		}
		getCouponService().createCoupon(coupon);
		return "redirect:/management/coupon/list";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editCoupon(@PathVariable Long id, Model model) {
		Coupon coupon = getCouponService().getCouponById(id);
		model.addAttribute("coupon", coupon);
		return "couponManagementEditor";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateCoupon(
			@RequestParam("id") Long id,
			@RequestParam("title") String title,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("thumbImageFile") MultipartFile thumbImageFile,
			@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
			Model model) {
		Coupon coupon = getCouponService().getCouponById(id);
		coupon.setTitle(title);
		if (!imageFile.isEmpty()) {
			coupon.setImagePath("images/" + imageFile.getOriginalFilename());
			coupon.setPdfPath("pdf/"
					+ Base64.encodeObject(imageFile.getOriginalFilename())
					+ ".pdf");
		}
		if (!thumbImageFile.isEmpty()) {
			coupon.setThumbImagePath("images/"
					+ thumbImageFile.getOriginalFilename());
		}
		coupon.setStartDate(startDate);
		coupon.setEndDate(endDate);
		// save files
		try {
			getCouponService().saveResourceFiles(coupon, imageFile,
					thumbImageFile);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",
					"Files save error :" + e.getMessage());
			model.addAttribute("coupon", coupon);
			return "couponManagementEditor";
		}
		getCouponService().updateCoupon(coupon);
		return "redirect:/management/coupon/list";
	}

	@RequestMapping(value = "delete")
	public String deleteCoupon(@RequestParam("id") Long id) {
		getCouponService().deleteCouponById(id);
		return "redirect:/management/coupon/list";
	}

	public CouponService getCouponService() {
		return couponService;
	}

	public void setCouponService(CouponService couponService) {
		this.couponService = couponService;
	}

}
