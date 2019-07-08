package com.revature.utility;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Employee;

public interface EmployeeDAO {

	public abstract ArrayList<Employee> readAllEmployees()
		throws SQLException;
	
	public abstract ArrayList<Employee> createEmployee(String empFirstName, String empLastName, int deptID, int salary, String empEmail)
		throws SQLException;
	
	public abstract void calcAVGSal()
		throws SQLException;
}