package com.spring.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.Employee;
import com.spring.service.IEmployeeServiceMgmt;

import jakarta.servlet.http.HttpSession;


@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeServiceMgmt service;
	
	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/emp_report")
	public String showReport(Map<String, Object> map) {
		Iterable<Employee> empLists = service.getAllEmployee();
		map.put("empList", empLists);
		return "emp_report";
	}
	
	
	@GetMapping("/add_emp")
	public String showAddEmployee(@ModelAttribute("emp") Employee emp) {
		return "add_emp";
	}
	
	//occurs double posting problem
	/*
	@PostMapping("/add_emp")
	public String addEmployee(Map<String, Object> map,@ModelAttribute("emp") Employee emp) {
		String result = service.addEmployee(emp);
		Iterable<Employee> empList = service.getAllEmployee();
		map.put("empList", empList);
		map.put("result", result);
		return "emp_report";
	}
	*/
	
	/*
	@PostMapping("/add_emp")
	public String addEmployee(RedirectAttributes attr,@ModelAttribute("emp") Employee emp) {
		String result = service.addEmployee(emp);
		attr.addFlashAttribute("result", result);
		return "redirect:emp_report";
	}
	*/
	
	//Adding attribute to session scope
	@PostMapping("/add_emp")
	public String addEmployee(HttpSession session,@ModelAttribute("emp") Employee emp) {
		String result = service.addEmployee(emp);
		session.setAttribute("result", result);
		return "redirect:emp_report";
	}
	
	
	
	@GetMapping("/edit_emp")
	public String updateEmp(@RequestParam("eno") int eno,@ModelAttribute("emp") Employee emp) {
		Employee employee = service.getEmployeeByEmpno(eno);
		BeanUtils.copyProperties(employee, emp);
		return "modify_emp";
	}
	
	@PostMapping("/edit_emp")
	public String modifyEmp(Map<String, Object> map,@ModelAttribute("emp") Employee emp) {
		String result = service.updateEmployee(emp);
		Iterable<Employee> empList = service.getAllEmployee();
		map.put("empList", empList);
		map.put("result", result);
		return "emp_report";
	}
	
	@GetMapping("delete_emp")
	public String deleteEmployeeById(Map<String, Object> map,@RequestParam("eno") int eno) {
		String result = service.deleteByEmpNo(eno);
		Iterable<Employee> empList = service.getAllEmployee();
		map.put("result", result);
		map.put("empList", empList);
		return "emp_report";
	}
	
	
	
	
}
