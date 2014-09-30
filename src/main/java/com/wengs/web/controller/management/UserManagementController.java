package com.wengs.web.controller.management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wengs.web.model.entity.User;
import com.wengs.web.security.SecurityService;

@Controller
@RequestMapping(value = "/management/user")
public class UserManagementController {
	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "list")
	public String listAllUsers(Model model) {
		List<User> users = getSecurityService().listAllUsers();
		model.addAttribute("users", users);
		return "userManagementList";
	}

	@RequestMapping(value = "changePwd/{id}" ,method = RequestMethod.GET)
	public String changePassword(@PathVariable Long id, Model model) {
		User user = getSecurityService().getUserById(id);
		model.addAttribute("user", user);
		return "userManagementChangePwd";
	}

	@RequestMapping(value = "changePwd", method = RequestMethod.POST)
	public String changePassword(@RequestParam("id") Long id,
			@RequestParam("oldPassword") String oldPassword,
			@RequestParam("password") String password, Model model) {
		if (getSecurityService().isOldPasswordMatch(id, oldPassword)) {
			User user = getSecurityService().getUserById(id);
			user.setPassword(password);
			getSecurityService().updateUser(user);
			return "redirect:/management/user/list";
		} else {
			User user = getSecurityService().getUserById(id);
			model.addAttribute("user", user);
			model.addAttribute("errorMsg", "密碼不正確，請重新輸入");
			return "userManagementChangePwd";
		}
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createUser() {
		return "userManagementCreator";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String createUser(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole("USER");
		getSecurityService().createUser(user);
		return "redirect:/management/user/list";
	}

	@RequestMapping(value = "delete")
	public String deleteUser(@RequestParam("id") Long id) {
		getSecurityService().deleteUserById(id);
		return "redirect:/management/user/list";
	}

	@RequestMapping(value = "isExist/{username}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	Map<String, String> isUsernameExist(@PathVariable String username) {
		HashMap<String, String> map = new HashMap<String, String>();
		User user = getSecurityService().getUserByUsername(username);
		if (user != null) {
			map.put("result", "exist");
		} else {
			map.put("result", "ok");
		}
		return map;
	}

	public SecurityService getSecurityService() {
		return securityService;
	}

	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}
}
