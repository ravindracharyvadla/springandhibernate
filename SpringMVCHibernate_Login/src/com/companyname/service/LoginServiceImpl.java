package com.companyname.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyname.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao loginDao;
	
	@Override
	public boolean findUser(String emailId, String password) {
		
		return loginDao.findUser(emailId,password);
	}

}
