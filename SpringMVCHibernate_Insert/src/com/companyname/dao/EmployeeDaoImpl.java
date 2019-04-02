package com.companyname.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.companyname.entity.Employee;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
    private SessionFactory sessionFactory;
	@Override
	public void registration(Employee e) {

		sessionFactory.getCurrentSession().save(e);
		
	}

}
