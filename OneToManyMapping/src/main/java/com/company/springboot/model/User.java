package com.company.springboot.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "APP_USER", schema = "MANAGEMENT")
public class User implements Serializable {
	private static final long serialVersionUID = 8822406795142738548L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "AGE", nullable = false)
	private Integer age;

	@Column(name = "SALARY", nullable = false)
	private double salary;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private Set<Task> tasks;

	public User() {

	}

	public User(int id, String name, Integer age, double salary, Set<Task> tasks) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.tasks = tasks;
	}

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", tasks=" + tasks + "]";
	}

}
