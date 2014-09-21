package com.wengs.web.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "edm")
public class Edm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	@Column(nullable = false)
	private String imagePath;
	private String thumbImagePath;
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getThumbImagePath() {
		return thumbImagePath;
	}

	public void setThumbImagePath(String thumbImagePath) {
		this.thumbImagePath = thumbImagePath;
	}

	public Date getPublishTs() {
		return publishTs;
	}

	public void setPublishTs(Date publishTs) {
		this.publishTs = publishTs;
	}

	public Date getModifyTs() {
		return modifyTs;
	}

	public void setModifyTs(Date modifyTs) {
		this.modifyTs = modifyTs;
	}

}
