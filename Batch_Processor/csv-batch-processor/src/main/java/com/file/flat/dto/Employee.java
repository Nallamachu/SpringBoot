package com.file.flat.dto;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 5248477748393859021L;

	private int id;
	private String name;
	private String company;
	private String branch;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Employee(int id, String name, String company, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.branch = branch;
	}

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", company=" + company + ", branch=" + branch + "]";
	}

}
