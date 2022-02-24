package com.example.kafka.springbootkafkaconsumer.entity;

public class User {
	private String name;
	private String dept;
	private Double salary;
	
	public User() {
	}

	public User(String name, String dept, Double salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.salary = salary;
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
		return String.format("User [name=%s, dept=%s, salary=%s]", name, dept, salary);
	}
}
