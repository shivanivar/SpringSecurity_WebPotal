package com.cisco.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qualification_master")
public class QualificationMaster {
	
	public QualificationMaster() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "qualification_name")
	private String qualificationName;
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public String getQualificationName(){
		return qualificationName;
	}
	
	public void setQualificationName(String qualificationName){
		this.qualificationName = qualificationName;
	}
}

