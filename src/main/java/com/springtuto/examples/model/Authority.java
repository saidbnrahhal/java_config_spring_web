package com.springtuto.examples.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="authorities")
public class Authority {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;
	private String username;
	private String authority;
	
	public Authority() {}
	
	public String getAuthority() {
		return authority;
	}
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
