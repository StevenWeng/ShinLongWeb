package com.wengs.web.model.service;

import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wengs.web.model.dao.PageDao;
import com.wengs.web.model.entity.Page;

@Service
public class PageService {
	@Autowired
	private PageDao pageDAO;

	public void updatePage(Page page) {
		page.setModifyTs(new Date());
		getPageDAO().update(page);
	}

	public Page getPageByName(String pageName) {
		DetachedCriteria dc = DetachedCriteria.forClass(Page.class);
		dc.add(Restrictions.eq("name", pageName));
		Page page = getPageDAO().findUniqeByCriteria(dc);
		return page;
	}

	public PageDao getPageDAO() {
		return pageDAO;
	}

	public void setPageDAO(PageDao pageDAO) {
		this.pageDAO = pageDAO;
	}

}
