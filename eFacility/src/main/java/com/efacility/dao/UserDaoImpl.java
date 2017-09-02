package com.efacility.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.efacility.model.Employee;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public Employee findByUserName(String name) {
		List<Employee> employees;
		
		employees = sessionFactory.getCurrentSession()
				.createQuery("from Employee where id=?")
				.setParameter(0, name)
				.list();
		
		if(!employees.isEmpty()) {
			return employees.get(0);
		} else {
			return null;
		}
	}
	
}
