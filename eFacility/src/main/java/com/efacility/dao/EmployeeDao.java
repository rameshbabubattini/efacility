package com.efacility.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.efacility.model.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void add(Employee e) {
		sessionFactory.getCurrentSession().save(e);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Employee> list() {
		return (List<Employee>) sessionFactory.getCurrentSession().createQuery("from Employee").getResultList();
	}
}
