package com.wengs.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wengs.web.model.dao.PostDao;
import com.wengs.web.model.entity.Post;

@Controller
@RequestMapping(value="hello")
public class HelloController {
	@Autowired
	private PostDao postDao;

	@RequestMapping(value="hi")
	public String hello(@RequestParam("user") String user, Model model) {
		Post post = new Post();
		post.setContext("test1");
		post.setTitle("t");
		post.setModifyTs(new Date());
		getPostDao().create(post);
		model.addAttribute("user", user);
		return "hello";
	}

	@RequestMapping(value = "json",method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody Map<String, String> helloJson() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		return map;
	}

	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
}
