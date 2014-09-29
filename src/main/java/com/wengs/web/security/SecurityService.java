package com.wengs.web.security;

import static com.google.common.base.Preconditions.*;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wengs.web.model.dao.UserDao;
import com.wengs.web.model.entity.User;

public class SecurityService implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return getUserByUsername(username);
	}

	public List<User> listAllUsers() {
		return getUserDao().findAll();
	}

	public User getUserById(Long id) {
		checkArgument(id > 0, "id has to grader then 0");
		return getUserDao().getById(id);
	}

	public User getUserByUsername(String username) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("username", username));
		return getUserDao().findUniqeByCriteria(dc);
	}

	public boolean isOldPasswordMatch(Long id, String oldPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User user = getUserById(id);
		return passwordEncoder.matches(oldPassword, user.getPassword());
	}

	public void createUser(User user) {
		checkNotNull(user, "user is null");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		getUserDao().create(user);
	}

	public void deleteUserById(Long id) {
		checkArgument(id > 0, "id has to grader then 0");
		User deleteUser = getUserById(id);
		getUserDao().delete(deleteUser);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
