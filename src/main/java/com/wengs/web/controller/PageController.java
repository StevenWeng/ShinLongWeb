package com.wengs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wengs.web.model.entity.Page;
import com.wengs.web.model.service.PageService;

@Controller
@RequestMapping(value = { "/", "home" })
public class PageController {
	@Autowired
	private PageService pageService;
	
	@RequestMapping(value = { "/", "introduction" }, method = RequestMethod.GET)
	public String introduction(Model model) {
		Page introductionPage = getPageService().getPageByName("introduction");
		model.addAttribute("content", introductionPage.getContent());
		model.addAttribute("title", introductionPage.getTitle());
		return "page";
	}

	public PageService getPageService() {
		return pageService;
	}

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}
}
