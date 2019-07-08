package com.revature.utility2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.beans.Department;
import com.revature.utility.DepartmentDAO;

import factory.ConnFactory;

public class DepartmentDAOImpl implements DepartmentDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	public ArrayList<Department> readAllDepartments() throws SQLException {
		ArrayList<Department> departmentList = new ArrayList<Department>();
		Connection conn = cf.getConnection();
		Statement stmt;
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DEPT");
			Department d = null;
			while(rs.next())
			{
				d = new Department(rs.getInt(1),
								rs.getString(2));
								
				departmentList.add(d);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return departmentList;
	}
}