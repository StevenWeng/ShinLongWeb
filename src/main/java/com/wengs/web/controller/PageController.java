package com.wengs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wengs.web.model.entity.Page;
import com.wengs.web.model.service.PageService;

@Controller
@RequestMapping(value = { "/", "home" })
public class PageController {
	@Autowired
	private PageService pageService;

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getPageByName(@PathVariable String name, Model model) {
		Page page = getPageService().getPageByName(name);
		model.addAttribute("content", page.getContent());
		model.addAttribute("title", page.getTitle());
		return "page";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getDefaultPage(Model model){
		Page page = getPageService().getPageByName("introduction");
		model.addAttribute("content", page.getContent());
		model.addAttribute("title", page.getTitle());
		return "page";
	}

	public PageService getPageService() {
		return pageService;
	}

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}
}
