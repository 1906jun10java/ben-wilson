package com.revature.beans;

public class Employee {
	private int empID;
	private String empFirstName; 
	private String empLastName;
	private int deptID;
	private int salary;
	private String empEmail;
	public Employee(int empID, String empFirstName, String empLastName, int deptID, int salary, String empEmail) {
		super();
		this.empID = empID;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.deptID = deptID;
		this.salary = salary;
		this.empEmail = empEmail;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", deptID=" + deptID + ", salary=" + salary + ", empEmail=" + empEmail + "]";
	}
		
}
