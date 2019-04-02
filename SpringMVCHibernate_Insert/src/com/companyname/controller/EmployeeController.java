package com.companyname.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.companyname.entity.Employee;
import com.companyname.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String m1()
	{
		return "registrationInputPage";
	}
	

	/*	
	@RequestMapping(value="/registration",method=RequestMethod.POST)
	public String m2(@Validated Employee e,Model model)
	{
		model.addAttribute("employeeId", e.getEmployeeId());
		model.addAttribute("employeeName", e.getEmployeeName());
		model.addAttribute("emailId", e.getEmailId());
		model.addAttribute("contactNumber", e.getContactNumber());
		
		return "registrationOutputPage";
	}*/
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee")
	Employee employee, BindingResult result) {

		employeeService.registration(employee);
		
		return "registration-success";
	}
}
