package com.wengs.web.model.service;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.DocumentException;
import com.wengs.web.model.dao.CouponDao;
import com.wengs.web.model.entity.Coupon;
import com.wengs.web.util.ImageUtil;
import com.wengs.web.util.PdfUtil;

@Service
public class CouponService {
	@Autowired
	private CouponDao couponDao;
	@Autowired
	private String baseDir;

	public List<Coupon> listAllCoupon() {
		return getCouponDao().findAll();
	}

	public List<Coupon> listActiveCoupon() {
		DetachedCriteria dc = DetachedCriteria.forClass(Coupon.class);
		dc.add(Restrictions.le("startDate", new Date())).add(
				Restrictions.ge("endDate", new Date()));
		return getCouponDao().findByCriteria(dc);
	}

	public Coupon getCouponById(Long id) {
		checkArgument(id > 0, "id has to grader then 0");
		return getCouponDao().getById(id);
	}

	public void createCoupon(Coupon coupon) {
		checkNotNull(coupon, "coupon is null");
		coupon.setModifyTs(new Date());
		getCouponDao().create(coupon);
	}

	public void updateCoupon(Coupon coupon) {
		checkNotNull(coupon, "coupon is null");
		Coupon orgCoupon = getCouponById(coupon.getId());
		compareAndDeleteResourceFiles(orgCoupon, coupon);
		coupon.setModifyTs(new Date());
		getCouponDao().update(coupon);
	}

	public void deleteCouponById(Long id) {
		checkArgument(id >= 0, "id has to grader then 0");
		Coupon deleteCoupon = getCouponDao().getById(id);
		deleteResourceFiles(deleteCoupon);
		getCouponDao().delete(deleteCoupon);
	}

	public void saveResourceFiles(Coupon coupon, MultipartFile imageFile,
			MultipartFile thumbImageFile) throws IOException, DocumentException {
		if (!imageFile.isEmpty()) {
			ImageUtil.saveImage(ImageIO.read(imageFile.getInputStream()),
					new File(getBaseDir(), coupon.getImagePath()));
			PdfUtil.saveToPdf(ImageIO.read(imageFile.getInputStream()),
					new File(getBaseDir(), coupon.getPdfPath()));
		}
		if (!thumbImageFile.isEmpty()) {
			ImageUtil.saveImage(ImageIO.read(thumbImageFile.getInputStream()),
					new File(getBaseDir(), coupon.getThumbImagePath()));
		}
	}

	private void deleteResourceFiles(Coupon coupon) {
		ImageUtil.deleteImage(new File(getBaseDir(), coupon.getImagePath()));
		ImageUtil
				.deleteImage(new File(getBaseDir(), coupon.getThumbImagePath()));
		ImageUtil.deleteImage(new File(getBaseDir(), coupon.getPdfPath()));
	}

	private void compareAndDeleteResourceFiles(Coupon oldCoupon,
			Coupon newCoupon) {
		if (!oldCoupon.getImagePath().equals(newCoupon.getImagePath())) {
			ImageUtil.deleteImage(new File(getBaseDir(), oldCoupon
					.getImagePath()));
		}
		if (!oldCoupon.getThumbImagePath().equals(newCoupon.getThumbImagePath())) {
			ImageUtil.deleteImage(new File(getBaseDir(), oldCoupon
					.getThumbImagePath()));
		}
		if (!oldCoupon.getPdfPath().equals(newCoupon.getPdfPath())) {
			ImageUtil
					.deleteImage(new File(getBaseDir(), oldCoupon.getPdfPath()));
		}
	}

	public CouponDao getCouponDao() {
		return couponDao;
	}

	public void setCouponDao(CouponDao couponDao) {
		this.couponDao = couponDao;
	}

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

}
