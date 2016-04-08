package com.cisco.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cisco.models.User;
import com.cisco.security.LoggedInChecker;

@Repository
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDAOImpl.class);

	private final LoggedInChecker loggedInChecker;
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Autowired
	UserDAOImpl(LoggedInChecker loggedInChecker) {
        this.loggedInChecker = loggedInChecker;
    }

	@Override
	@Transactional
	public long addUser(User p) {
		// Add system current date as User Created Date
		long id = 0;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			id = (long) session.save(p);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("User saved successfully, User Details=" + p);
		return id;
	}

	@Override
	public void updateUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("User updated successfully, User Details=" + p);
	}

	@Override
	@Transactional
	public List<User> listUser() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> UserList = session.createQuery("SELECT * User U").list();
		for (User p : UserList) {
			logger.info("User List::" + p);
		}
		return UserList;
	}

	@Override
	@Transactional
	public List<User> getUserById(String email) {
		Query q = null;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String hql = "FROM User WHERE email = :email";

			if (email != null) {
				q = session.createQuery(hql).setString("email", email);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		ArrayList<User> al = new ArrayList<User>();
		al.addAll(q.list());
		return al;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("User deleted successfully, User details=" + p);
	}

	@Override
	public User getUserByUsername(String username) {
		// Just a mock interface support only one single root
		// Here you can add DAO to load user from the database
		if (username.equals("root")) {
			User user = new User();
			user.setFirstName("root");
			user.setPassword(new ShaPasswordEncoder().encodePassword(
					"password", null));

			return user;
		} else {
			return null;
		}
	}

	@Override
	public List<String> getPermissions(String username) {
		return new ArrayList<>();
	}

	@Override
	public User getCurrentUser() {
		return loggedInChecker.getLoggedInUser();
	}

	@Override
	public Boolean isCurrentUserLoggedIn() {
		return loggedInChecker.getLoggedInUser() != null;
	}
}
