package com.PI.CleanHome.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "socket")
public class Socket implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int user_id;
	@Column(nullable = false)
	private String socket_id;
	@Column(nullable = false)
	private String user_type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getUserId() {
		return user_id;
	}
	public void setUserId(int userId) {
		this.user_id = userId;
	}
	public String getSocketId() {
		return socket_id;
	}
	public void setSocketId(String socketId) {
		this.socket_id = socketId;
	}
	public String getUserType() {
		return user_type;
	}
	public void setUserType(String userType) {
		this.user_type = userType;
	}
	
	
	
	

}
