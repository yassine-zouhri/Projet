package com.example.entities;

public class UserRole {
	Long user_id;
	Long role_id;
	public UserRole(Long user_id, Long role_id) {
		super();
		this.user_id = user_id;
		this.role_id = role_id;
	}
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	
	
}
