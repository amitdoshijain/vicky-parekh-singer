package com.winsage.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.winsage.model.BaseEntity;
import com.winsage.model.Products;
import com.winsage.model.User;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(BaseEntity entity) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public User getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		User employee = (User) session.load(User.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<User> employeeList = session.createCriteria(User.class)
				.list();
		tx.commit();
		session.close();
		return employeeList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(User.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
