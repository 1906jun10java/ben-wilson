package com.revature.utility;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Department;

public interface DepartmentDAO {
	
	public abstract ArrayList<Department> readAllDepartments()
		throws SQLException;
}