package com.cisco.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "qualification")
public class Qualification {

	public Qualification() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "qualification_id")
	//@OneToMany
	private long qualificationId;
	
	@ManyToOne(optional = false)
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "description")
	private String description;
	
	@Column(name = "start_date")
	private Date startDate; 
	
	@Column(name = "end_date")
	private Date endDate; 
	
	@Column(name = "university")
	private String university;
	
	@Column(name = "percentage")
	private Double percentage;
	
	public long getId(){
		return id;
	}	
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getQualificationId(){
		return qualificationId;
	}
	
	public void setQualificationId(long qualificationId){
		this.qualificationId = qualificationId;
	}

	public QualificationMaster getDescription() {
//		QualificationMaster qualification = QualificationMaster.MCA;
		return null;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
}












