package com.crud.example.Dao;

import java.util.List;

import com.crud.example.Model.Employee;

public interface EmployeeDAO {
	    public void saveEmployee(Employee employee);
	    public Employee getEmployeeById(int id);
	    public void updateEmployee(Employee employee);
	    public void deleteEmployee(int id);
	    public List<Employee> getAllEmployees();
}
