package com.spring.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "emp")
@Data
public class Employee {
	
	@Id
	@SequenceGenerator(name = "g1",sequenceName = "Emp_no_seq",initialValue = 8100, allocationSize = 1)
	@GeneratedValue(generator = "g1",strategy = GenerationType.SEQUENCE)
	private Integer empno;
	
	private String ename;
	private String job;
	private Double sal;
	private Integer deptno;

}
