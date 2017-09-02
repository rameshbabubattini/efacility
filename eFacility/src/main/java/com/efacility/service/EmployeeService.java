package com.efacility.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacility.dao.EmployeeDao;
import com.efacility.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public void add(Employee e) {
		employeeDao.add(e);
	}
	
	public List<Employee> list() {
		return	employeeDao.list();
	}

}
