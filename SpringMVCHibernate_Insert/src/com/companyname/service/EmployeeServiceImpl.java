package com.companyname.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.dao.EmployeeDao;
import com.companyname.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	@Override
	public void registration(Employee e) {
		
		employeeDao.registration(e);
	}

}
