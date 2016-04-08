package com.cisco.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany(mappedBy = "user")
	private Set<Qualification> qualification;
	
	@OneToMany(mappedBy = "user")
	private Set<EmployementDetails> employments;
	
	public Set<EmployementDetails> getEmployments() {
		return employments;
	}

	public void setEmployments(Set<EmployementDetails> employments) {
		this.employments = employments;
	}

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	public Set<Qualification> getQualification() {
		return qualification;
	}

	public void setQualification(Set<Qualification> qualification) {
		this.qualification = qualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "admin")
	private String admin;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "permanent_address")
	private String permanentAddress;

	@Column(name = "current_address")
	private String currentAddress;

	@Column(name = "gender")
	private String gender;

	@Column(name = "dob")
	private Date dob;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
