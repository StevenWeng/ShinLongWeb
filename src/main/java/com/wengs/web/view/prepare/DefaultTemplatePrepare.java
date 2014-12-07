package com.wengs.web.view.prepare;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wengs.web.model.entity.Coupon;
import com.wengs.web.model.entity.Post;
import com.wengs.web.model.service.CouponService;
import com.wengs.web.model.service.PostService;

public class DefaultTemplatePrepare implements ViewPreparer {
	@Autowired
	private PostService postService;
	@Autowired
	private CouponService couponService;

	@Override
	public void execute(Request context, AttributeContext attributeContext) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		String pageTitle = (String) request.getAttribute("title");
		if(pageTitle != null){
			attributeContext.putAttribute("title", new Attribute(pageTitle));
		}
		
		// TODO put data in model
		List<Coupon> coupons = getCouponService().listActiveCoupon();
		List<Post> postsInLeft = getPostService().listDescOrderPostsByPage(1, 4, true);
		request.setAttribute("coupons", coupons);
		request.setAttribute("postsInLeft", postsInLeft);
		
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public CouponService getCouponService() {
		return couponService;
	}

	public void setCouponService(CouponService couponService) {
		this.couponService = couponService;
	}

}
