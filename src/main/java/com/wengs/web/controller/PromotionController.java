package com.wengs.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wengs.web.model.entity.Coupon;
import com.wengs.web.model.entity.Edm;
import com.wengs.web.model.service.CouponService;
import com.wengs.web.model.service.EdmService;

@Controller
@RequestMapping(value = "/promotion")
public class PromotionController {
	@Autowired
	private CouponService couponService;
	@Autowired
	private EdmService edmService;


	@RequestMapping(value = "/")
	public String index(Model model) {
		List<Coupon> coupons = getCouponService().listActiveCoupon();
		List<Edm> edms = getEdmService().listAllDescEdms();
		model.addAttribute("edms", edms);
		model.addAttribute("coupons", coupons);
		return "promotion";
	}

	public CouponService getCouponService() {
		return couponService;
	}

	public void setCouponService(CouponService couponService) {
		this.couponService = couponService;
	}

	public EdmService getEdmService() {
		return edmService;
	}

	public void setEdmService(EdmService edmService) {
		this.edmService = edmService;
	}

}
