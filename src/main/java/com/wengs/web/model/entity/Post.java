package com.wengs.web.model.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(length = 8096)
	private String context;
	@Column(nullable = false)
	private Date publishTs;
	private Date modifyTs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getModifyTs() {
		return modifyTs;
	}

	public void setModifyTs(Date modifyTs) {
		this.modifyTs = modifyTs;
	}

	public Date getPublishTs() {
		return publishTs;
	}

	public void setPublishTs(Date publishTs) {
		this.publishTs = publishTs;
	}

}
