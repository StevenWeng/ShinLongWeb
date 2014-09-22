package com.wengs.web.model.service;

import static com.google.common.base.Preconditions.*;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wengs.web.model.dao.EdmDao;
import com.wengs.web.model.entity.Coupon;
import com.wengs.web.model.entity.Edm;
import com.wengs.web.model.entity.Post;
import com.wengs.web.util.ImageUtil;

@Service
public class EdmService {
	@Autowired
	private String baseDir;
	@Autowired
	private EdmDao edmDao;

	@SuppressWarnings("unchecked")
	public List<Edm> listEdmByPage(int pageNumber, int pageSize) {
		checkArgument(pageSize > 0, "pageSize has to grader then 0.");
		checkArgument(pageNumber > 0, "pageNumber has to grader then 0.");

		int first = (pageNumber - 1) * pageSize;
		Session session = getEdmDao().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Edm.class);
		criteria.setFirstResult(first).setMaxResults(pageSize);
		criteria.addOrder(Order.desc("publishTs"));
		criteria.addOrder(Order.desc("id"));
		List<Edm> edms = criteria.list();
		session.close();
		return edms;
	}

	public int getMaxPageNumber(int pageSize) {
		checkArgument(pageSize > 0, "pageSize has to grader then 0.");
		List<Edm> list = getEdmDao().findAll();
		int maxSize = list.size();
		return maxSize % pageSize != 0 ? (maxSize / pageSize) + 1 : maxSize
				/ pageSize;
	}

	public Edm getEdmById(Long id) {
		checkArgument(id > 0, "id has to grader then 0");
		return getEdmDao().getById(id);
	}

	public void createOrUpdateEdm(Edm edm) {
		checkNotNull(edm, "edm is null");
		if (edm.getId() != null) {
			Edm orgEdm = getEdmById(edm.getId());
			deleteResourceFiles(orgEdm);
		}
		edm.setModifyTs(new Date());
		getEdmDao().createOrUpdate(edm);
	}
	
	public void deleteEdmById(Long id){
		checkArgument(id > 0, "id has to grader then 0");
		Edm deleteEdm = getEdmById(id);
		deleteResourceFiles(deleteEdm);
		getEdmDao().delete(deleteEdm);
	}

	private void deleteResourceFiles(Edm edm) {
		ImageUtil.deleteImage(new File(getBaseDir(), edm.getImagePath()));
		ImageUtil.deleteImage(new File(getBaseDir(), edm.getThumbImagePath()));
	}

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
