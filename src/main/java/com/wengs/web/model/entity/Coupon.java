package com.wengs.web.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	@Column(nullable = false)
	private String imagePath;
	private String thumbImagePath;
	private String pdfPath; 
	@Column(nullable = false)
	private Date startDate;
	@Column(nullable = false)
	private Date endDate;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getModifyTs() {
		return modifyTs;
	}

	public void setModifyTs(Date modifyTs) {
		this.modifyTs = modifyTs;
	}

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

}
