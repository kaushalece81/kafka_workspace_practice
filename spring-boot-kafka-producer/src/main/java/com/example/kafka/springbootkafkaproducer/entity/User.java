package com.example.kafka.springbootkafkaproducer.entity;

public class User {
	private Integer id;
	private String name;
	private String dept;
	private Double salary;
	
	
	public User() {
	}

	public User(Integer id, String name, String dept, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, dept=%s, salary=%s]", id, name, dept, salary);
	}
}
