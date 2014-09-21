package com.wengs.web.model.service;

import static com.google.common.base.Preconditions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wengs.web.model.dao.EdmDao;

@Service
public class EdmService {
	@Autowired
	private String baseDir;
	@Autowired
	private EdmDao edmDao;
	
	

	public EdmDao getEdmDao() {
		return edmDao;
	}

	public void setEdmDao(EdmDao edmDao) {
		this.edmDao = edmDao;
	}

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}
}
