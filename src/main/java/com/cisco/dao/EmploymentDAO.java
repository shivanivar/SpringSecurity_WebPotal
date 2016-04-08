package com.cisco.dao;

import java.util.List;

import com.cisco.models.EmployementDetails;

public interface EmploymentDAO {

	public long addEmployment(EmployementDetails p);

	public void updateEmployment(EmployementDetails p);

	public List<EmployementDetails> listEmployment();

	public EmployementDetails getEmploymentById(int id);

	public void removeEmployementDetails(int id);

}
