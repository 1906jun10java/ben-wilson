package com.revature.utility2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.utility.EmployeeDAO;
import factory.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO{

	public static ConnFactory cf = ConnFactory.getInstance();

	public ArrayList<Employee> readAllEmployees() throws SQLException {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		Statement stmt;
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
			Employee e = null;
			while(rs.next())
			{
				e = new Employee(rs.getInt(1),	
								rs.getString(2),
								rs.getString(3),	
								rs.getInt(4), 
								rs.getInt(5), 
								rs.getString(6)); 
								
				employeeList.add(e);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return employeeList;
		
	}

	public ArrayList<Employee> createEmployee(String empFirstName, String empLastName, int deptID, int salary,
			String empEmail) throws SQLException {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		try {
			String sql = "{ call INSERTEMPLOYEE(?, ?, ?, ?, ?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, empFirstName);
			call.setString(2,  empLastName);
			call.setInt(3, deptID);
			call.setDouble(4, salary);
			call.setString(5, empEmail);
			call.execute();
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong during employee creation.");
		}
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
		Employee e = null;
		while(rs.next())
		{
			e = new Employee(rs.getInt(1),	
							rs.getString(2), 
							rs.getString(3),	
							rs.getInt(4), 
							rs.getInt(5), 
							rs.getString(6));
							
			employeeList.add(e);
		}
		return employeeList;
	}

	public void calcAVGSal() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT D.DEPT_NAME, AVG(E.SALARY) FROM DEPT D RIGHT JOIN EMP E ON D.DEPT_ID = E.DEPT_ID GROUP BY D.DEPT_NAME ORDER BY AVG(E.SALARY) DESC";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		String str = "";
		while(rs.next())
		{
			System.out.println(rs.getString(1) + " " + rs.getDouble(2));
			
		}
	}
}