package com.wengs.web.controller;

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

import com.google.common.base.Optional;
import com.wengs.web.model.entity.Post;
import com.wengs.web.model.service.PostService;

import static com.google.common.base.Preconditions.*;

@Controller
@RequestMapping(value = "/management/post")
@SessionAttributes(value = { "pageNo", "pageSize" })
public class PostManagenemtController {
	@Autowired
	private PostService postService;

	@RequestMapping(value = "list")
	public String listPostsByPage(
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			Model model) {
		int totalPages = getPostService().getMaxPageNumber(pageSize);
		List<Post> posts = getPostService().listDescOrderPostsByPage(pageNo,
				pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("posts", posts);
		return "postManagementList";
	}

	@RequestMapping(value = "edit/{id}")
	public String editPost(@PathVariable Long id, Model model) {
		Post post = getPostService().getPostById(id);
		model.addAttribute("post", post);
		return "postManagementEditor";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createPost() {
		return "postManagementEditor";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createPost(
			@RequestParam("title") String title,
			@RequestParam("context") String context,
			@RequestParam("publishTs") @DateTimeFormat(pattern = "yyyy-MM-dd") Date publishTs) {
		Post post = new Post();
		post.setTitle(title);
		post.setContext(context);
		post.setPublishTs(publishTs);
		getPostService().createPost(post);
		return "postManagementList";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updatePost(
			@RequestParam("id") Long id,
			@RequestParam("title") String title,
			@RequestParam("context") String context,
			@RequestParam("publishTs") @DateTimeFormat(pattern = "yyyy-MM-dd") Date publishTs) {
		Post post = new Post();
		post.setId(id);
		post.setTitle(title);
		post.setContext(context);
		post.setPublishTs(publishTs);
		getPostService().updatePost(post);
		return "postManagementList";
	}

	@RequestMapping(value = "delete")
	public String deletePost(@RequestParam("id") Long id, HttpSession session) {
		getPostService().deletePostById(id);
		Integer pageNo = Optional.fromNullable(
				(Integer) session.getAttribute("pageNo")).or(1);
		Integer pageSize = Optional.fromNullable(
				(Integer) session.getAttribute("pageSize")).or(10);
		return "redirect:/management/post/list?pageNo=" + pageNo + "&pageSize="
				+ pageSize;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}
}
