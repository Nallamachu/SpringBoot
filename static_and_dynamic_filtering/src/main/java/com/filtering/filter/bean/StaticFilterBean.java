package com.filtering.filter.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"password"})
public class StaticFilterBean {

	private Long id;
	private String name;
	private String password;
	private String location;

	public StaticFilterBean(Long id, String name, String password, String location) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
