package com.wengs.web.model.service;

import static com.google.common.base.Preconditions.*;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wengs.web.model.dao.CouponDao;
import com.wengs.web.model.entity.Coupon;
import com.wengs.web.model.entity.Edm;
import com.wengs.web.util.ImageUtil;

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

	public void createOrUpdateCoupon(Coupon coupon) {
		checkNotNull(coupon, "coupon is null");
		if (coupon.getId() != null) {
			Coupon orgCoupon = getCouponById(coupon.getId());
			deleteResourceFiles(orgCoupon);
		}
		coupon.setModifyTs(new Date());
		getCouponDao().createOrUpdate(coupon);
	}

	public void deleteCouponById(Long id) {
		checkArgument(id >= 0, "id has to grader then 0");
		Coupon deleteCoupon = getCouponDao().getById(id);
		deleteResourceFiles(deleteCoupon);
		getCouponDao().delete(deleteCoupon);
	}

	private void deleteResourceFiles(Coupon coupon) {
		ImageUtil.deleteImage(new File(getBaseDir(), coupon.getImagePath()));
		ImageUtil
				.deleteImage(new File(getBaseDir(), coupon.getThumbImagePath()));
		ImageUtil.deleteImage(new File(getBaseDir(), coupon.getPdfPath()));
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
