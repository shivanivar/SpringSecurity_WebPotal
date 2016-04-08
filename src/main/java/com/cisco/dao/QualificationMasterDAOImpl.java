package com.cisco.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cisco.models.QualificationMaster;;

@Repository
@EnableTransactionManagement
public class QualificationMasterDAOImpl implements QualificationMasterDAO {

	private static final Logger logger = LoggerFactory.getLogger(QualificationMasterDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public long addQualificationMaster(QualificationMaster p) {
		long id = 0;
		try {
			System.out.println("1111");
			Session session = this.sessionFactory.getCurrentSession();
			id = (long) session.save(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("QulificationMaster added successfully, Qulification Details=" + p);
		return id;
	}

	@Override
	public void updateQualificationMaster(QualificationMaster p) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<QualificationMaster> listQualificationMaster() {
		List<QualificationMaster> list = null;
		try {
			System.out.println("1111");
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Weather"); //You will get Weayher object
			list = query.list(); //You are accessing  as list<WeatherModel>
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("QulificationMaster added successfully, Qulification Details=");
		return list;
	}

	@Override
	public QualificationMaster getQualificationMasterById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeQualificationMaster(int id) {
		// TODO Auto-generated method stub

	}

}
