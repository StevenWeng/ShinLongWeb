package com.wengs.web.model.dao;


import org.springframework.stereotype.Service;

import com.wengs.web.model.dao.impl.HibernateCommonDaoImpl;
import com.wengs.web.model.entity.Post;

@Service
public class PostDao extends HibernateCommonDaoImpl<Post>{
}
