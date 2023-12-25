package com.spring.service;

import com.spring.entity.Employee;

public interface IEmployeeServiceMgmt {
	public Iterable<Employee> getAllEmployee();
	
	public String addEmployee(Employee emp);
	
	public Employee getEmployeeByEmpno(int no);
	
	public String updateEmployee(Employee emp);
	
	public String deleteByEmpNo(int no);
}
