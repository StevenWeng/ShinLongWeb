package com.wengs.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wengs.web.model.entity.Post;
import com.wengs.web.model.service.PostService;

@Controller
@RequestMapping(value = "/post")
public class PostController {
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
		return "postList";
	}
	
	@RequestMapping(value = "detail/{id}")
	public String getPostDetail(@PathVariable Long id,Model model){
		Post post = getPostService().getPostById(id);
		model.addAttribute("post", post);
		return "postDetail";
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}
}
