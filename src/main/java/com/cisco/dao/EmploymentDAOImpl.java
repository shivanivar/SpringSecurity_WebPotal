package com.cisco.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cisco.models.EmployementDetails;
@Repository
@EnableTransactionManagement
public class EmploymentDAOImpl implements EmploymentDAO{

	private static final Logger logger = LoggerFactory.getLogger(QualificationDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	@Override
	public long addEmployment(EmployementDetails p) {
		long id = 0;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			id =  (long) session.save(p);
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		logger.info("Employment saved successfully, Employment Details="+p);
		return id;
	}

	@Override
	public void updateEmployment(EmployementDetails p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmployementDetails> listEmployment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployementDetails getEmploymentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEmployementDetails(int id) {
		// TODO Auto-generated method stub
		
	}

}
