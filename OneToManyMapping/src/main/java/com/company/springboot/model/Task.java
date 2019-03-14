package com.company.springboot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TASK", schema = "MANAGEMENT")
public class Task implements Serializable {
	private static final long serialVersionUID = 5548626511482486065L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DAYS_TO_COMPLETE")
	private Integer daysToComplete;
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	public Task() {

	}

	public Task(Integer id, String name, Integer daysToComplete, User user) {
		super();
		this.id = id;
		this.name = name;
		this.daysToComplete = daysToComplete;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDaysToComplete() {
		return daysToComplete;
	}

	public void setDaysToComplete(Integer daysToComplete) {
		this.daysToComplete = daysToComplete;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", daysToComplete=" + daysToComplete + ", user=" + user + "]";
	}

}
