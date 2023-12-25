package com.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Employee;
import com.spring.repository.IEmployeeRepo;

@Service("employeeService")
public class EmployeeServiceMgmtImpl implements IEmployeeServiceMgmt {

	@Autowired
	private IEmployeeRepo empRepo;
	
	@Override
	public Iterable<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public String addEmployee(Employee emp) {
		return "Employee saved with id : "+empRepo.save(emp).getEmpno();
	}

	@Override
	public String updateEmployee(Employee emp) {
		return "Employee with id "+empRepo.save(emp).getEmpno()+" is Upadated";
	}

	@Override
	public Employee getEmployeeByEmpno(int no) {
		Optional<Employee> optional = empRepo.findById(no);
		return optional.get();
	}

	@Override
	public String deleteByEmpNo(int no) {
		empRepo.deleteById(no);
		return "Employee with id: "+no+ "is deleted";
	}

	

}
