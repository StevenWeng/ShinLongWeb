package com.wengs.web.model.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wengs.web.model.dao.PostDao;
import com.wengs.web.model.entity.Post;

import static com.google.common.base.Preconditions.*;

@Service
public class PostService {
	@Autowired
	private PostDao postDao;

	public List<Post> listAllPosts() {
		return getPostDao().findAll();
	}

	@SuppressWarnings("unchecked")
	public List<Post> listDescOrderPostsByPage(int pageNumber, int pageSize) {
		checkArgument(pageSize > 0, "pageSize has to grader then 0.");
		checkArgument(pageNumber > 0, "pageNumber has to grader then 0.");

		int first = (pageNumber - 1) * pageSize;
		Session session = getPostDao().getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Post.class);
		criteria.setFirstResult(first).setMaxResults(pageSize);
		criteria.addOrder(Order.desc("id"));
		return criteria.list();
	}

	public int getMaxPageNumber(int pageSize) {
		checkArgument(pageSize > 0, "pageSize has to grader then 0.");
		List<Post> list = getPostDao().findAll();
		int maxSize = list.size();
		return maxSize % pageSize != 0 ? (maxSize / pageSize) + 1 : maxSize
				/ pageSize;
	}

	public void createPost(Post post) {
		checkNotNull(post, "post is null");
		post.setModifyTs(new Date());
		getPostDao().create(post);
	}

	public void updatePost(Post post) {
		checkNotNull(post, "post is null");
		post.setModifyTs(new Date());
		getPostDao().update(post);
	}

	public void deletePostById(Long id) {
		checkArgument(id >= 0, "id has to grader then 0");
		Post delPost = new Post();
		delPost.setId(id);
		delPost.setTitle("");
		delPost.setPublishTs(new Date());
		getPostDao().delete(delPost);
	}

	public Post getPostById(Long id) {
		checkArgument(id >= 0, "id has to grader then 0");
		return getPostDao().getById(id);
	}

	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
}
