package com.efacility.dao;

import com.efacility.model.Employee;

public interface UserDao {

	Employee findByUserName(String name);
	
}
