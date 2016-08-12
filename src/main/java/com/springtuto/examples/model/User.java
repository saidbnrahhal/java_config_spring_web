package com.springtuto.examples.model;

public class User {
	
	private String username;
	private String password;
	private boolean enabled ;
	
	public User() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsrname(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
