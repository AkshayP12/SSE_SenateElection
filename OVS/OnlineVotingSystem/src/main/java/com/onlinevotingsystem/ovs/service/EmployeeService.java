package com.onlinevotingsystem.ovs.service;

import java.util.List;

import com.onlinevotingsystem.ovs.model.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	
}
