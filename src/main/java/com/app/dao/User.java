package com.app.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="company")
	private String company;
	
	@Column(name="email")
	private String email;
	
	@Column(name="title")
	private String title;
	
	@Column(name="phNum")
	private String phNum;
	
	@Column(name="department")
	private String department;
	
	@Column(name="jobType")
	private String jobType;
	
	@Column(name="role")
	private String role;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Column(name="password")
	private String password;

	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String img;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
public User(int id, String firstName, String lastName, String company, String email, String title, String phNum,
		String department, String jobType,String img) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.company = company;
	this.email = email;
	this.title = title;
	this.phNum = phNum;
	this.department = department;
	this.jobType = jobType;
	this.img=img;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getPhNum() {
	return phNum;
}
public void setPhNum(String phNum) {
	this.phNum = phNum;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getJobType() {
	return jobType;
}
public void setJobType(String jobType) {
	this.jobType = jobType;
}
	
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}



public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}

@Override
public String toString() {
	return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company
			+ ", email=" + email + ", title=" + title + ", phNum=" + phNum + ", department=" + department + ", jobType="
			+ jobType + ", role=" + role + ", enabled=" + enabled + ", img=" + img + "]";
}



	
	
}
