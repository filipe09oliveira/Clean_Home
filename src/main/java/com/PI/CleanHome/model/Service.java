package com.PI.CleanHome.model;

import javax.persistence.Entity;

public class Service {
	private Long id;
	private float price;
	private String status;
	private String cleanerSocketId;
	
	public Service() {}

	public Service(Long id, float price, String status, String cleanerSocketId) {
		super();
		this.id = id;
		this.price = price;
		this.status = status;
		this.cleanerSocketId = cleanerSocketId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCleanerSocketId() {
		return cleanerSocketId;
	}

	public void setCleanerSocketId(String cleanerSocketId) {
		this.cleanerSocketId = cleanerSocketId;
	}
	
	
}
