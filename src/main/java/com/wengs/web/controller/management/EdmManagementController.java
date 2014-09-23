package com.wengs.web.controller.management;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Optional;
import com.wengs.web.model.entity.Edm;
import com.wengs.web.model.service.EdmService;

@Controller
@RequestMapping(value = "/management/edm")
@SessionAttributes(value = { "pageNo", "pageSize" })
public class EdmManagementController {
	@Autowired
	private EdmService edmService;
	@Autowired
	private String baseDir;

	@RequestMapping(value = "list")
	public String listDescEdmByPage(
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			Model model) {
		int totalPages = getEdmService().getMaxPageNumber(pageSize);
		List<Edm> edms = getEdmService().listEdmByPage(pageNo, pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("edms", edms);
		return "edmManagementList";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createEdm() {
		return "edmManagementCreator";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createEdm(
			@RequestParam("title") String title,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("publishTs") @DateTimeFormat(pattern = "yyyy-MM-dd") Date publishTs,
			Model model, HttpSession session) {
		if (imageFile.isEmpty()) {
			model.addAttribute("errorMessage", "Files are empty.");
			return "edmManagementCreator";
		}
		String imagePath = "images/" + imageFile.getOriginalFilename();

		String thumbImagePath = "images/thumb-"
				+ imageFile.getOriginalFilename();
		Edm edm = new Edm();
		edm.setTitle(title);
		edm.setImagePath(imagePath);
		edm.setThumbImagePath(thumbImagePath);
		edm.setPublishTs(publishTs);
		try {
			getEdmService().saveResourceFiles(edm, imageFile);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",
					"Files save error :" + e.getMessage());
			return "edmManagementCreator";
		}
		getEdmService().createEdm(edm);
		Integer pageNo = Optional.fromNullable(
				(Integer) session.getAttribute("pageNo")).or(1);
		Integer pageSize = Optional.fromNullable(
				(Integer) session.getAttribute("pageSize")).or(10);
		return "redirect:/management/edm/list?pageNo=" + pageNo + "&pageSize="
				+ pageSize;
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editEdm(@PathVariable Long id, Model model) {
		Edm edm = getEdmService().getEdmById(id);
		model.addAttribute("edm", edm);
		return "edmManagementEditor";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateEdm(
			@RequestParam("id") Long id,
			@RequestParam("title") String title,
			@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("publishTs") @DateTimeFormat(pattern = "yyyy-MM-dd") Date publishTs,
			Model model, HttpSession session) {
		Edm edm = getEdmService().getEdmById(id);
		edm.setTitle(title);
		edm.setPublishTs(publishTs);
		if (!imageFile.isEmpty()) {
			edm.setImagePath("images/" + imageFile.getOriginalFilename());
			edm.setThumbImagePath("images/thumb-"
					+ imageFile.getOriginalFilename());
		}
		// save files
		try {
			getEdmService().saveResourceFiles(edm, imageFile);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage",
					"Files save error :" + e.getMessage());
			if (id != null) {
				model.addAttribute("edm", getEdmService().getEdmById(id));
			}
			return "edmManagementEditor";
		}
		getEdmService().updateEdm(edm);

		Integer pageNo = Optional.fromNullable(
				(Integer) session.getAttribute("pageNo")).or(1);
		Integer pageSize = Optional.fromNullable(
				(Integer) session.getAttribute("pageSize")).or(10);
		return "redirect:/management/edm/list?pageNo=" + pageNo + "&pageSize="
				+ pageSize;
	}

	@RequestMapping(value = "delete")
	public String deleteEdm(@RequestParam("id") Long id, HttpSession session) {
		getEdmService().deleteEdmById(id);
		Integer pageNo = Optional.fromNullable(
				(Integer) session.getAttribute("pageNo")).or(1);
		Integer pageSize = Optional.fromNullable(
				(Integer) session.getAttribute("pageSize")).or(10);
		return "redirect:/management/edm/list?pageNo=" + pageNo + "&pageSize="
				+ pageSize;
	}

	public EdmService getEdmService() {
		return edmService;
	}

	public void setEdmService(EdmService edmService) {
		this.edmService = edmService;
	}

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

}
