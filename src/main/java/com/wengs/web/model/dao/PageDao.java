package com.wengs.web.model.dao;

import org.springframework.stereotype.Service;

import com.wengs.web.model.dao.impl.HibernateCommonDaoImpl;
import com.wengs.web.model.entity.Page;

@Service
public class PageDao extends HibernateCommonDaoImpl<Page> {

}
