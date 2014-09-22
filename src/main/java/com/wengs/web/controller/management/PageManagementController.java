package com.wengs.web.controller.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wengs.web.model.entity.Page;
import com.wengs.web.model.service.PageService;

@Controller
@RequestMapping(value = "/management/page")
public class PageManagementController {
	@Autowired
	private PageService pageService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(){
		return "pageManagement";
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getPage(@PathVariable String name, Model model) {
		Page page = getPageService().getPageByName(name);
		if(page != null){
			model.addAttribute("name", page.getName());
			model.addAttribute("content", page.getContent());
			model.addAttribute("title", page.getTitle());
		}
		return "pageManagement";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String updatePageByAjax(@RequestParam("name") String name,@RequestParam("content") String content){
		try {
			Page page = getPageService().getPageByName(name);
			page.setContent(content);
			getPageService().updatePage(page);
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR:"+e.getMessage();
		}
	}

	public PageService getPageService() {
		return pageService;
	}

	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}
}
