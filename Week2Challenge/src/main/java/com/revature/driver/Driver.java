package com.revature.driver;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.utility2.DepartmentDAOImpl;
import com.revature.utility2.EmployeeDAOImpl;

public class Driver {
	static public Scanner sc = new Scanner(System.in);
	static public EmployeeDAOImpl edi = new EmployeeDAOImpl();
	static public DepartmentDAOImpl ddi = new DepartmentDAOImpl();
	
	public static void main(String[] args) {
		int inputSelection = 0;
		while(inputSelection < 1 || inputSelection > 3)
		{
			try
			{
				System.out.println("Welcome, what would you like to do?" + "\n" +
						"1. Create new Employee" + "\n" +
						"2. Display Average salary for each department" + "\n" +
						"3. Exit");
				inputSelection = sc.nextInt();
				if(inputSelection < 1 || inputSelection > 3)
				{
					throw new InputMismatchException();
				}
				else if(inputSelection == 3)
				{
					System.exit(-1);
				}
				switch(inputSelection)
				{
				case 1:
					inputSelection = 0;
					while(inputSelection < 1 || inputSelection > 3)
					{
						try
						{
							System.out.println("What is the employee's first name?");
							String newFirstName = sc.next();
								
							System.out.println("What is the employee's last name?");
							String newLastName = sc.next();
								
							System.out.println("What department are they in?" + "\n" +
									"1. Accounting" + "\n" +
									"2. Sales" + "\n" +
									"3. Imagineering");
							inputSelection = sc.nextInt();
							int newDeptID = inputSelection;
							if(inputSelection < 1 || inputSelection > 3)
							{
								throw new InputMismatchException();
							}
							System.out.println("What is the employee' salary?");
							int newSalary = sc.nextInt();
							System.out.println("What is the employee's email address?");
							String newEmpEmail = sc.next();
							edi.createEmployee(newFirstName, newLastName, newDeptID, newSalary, newEmpEmail);
						}
						catch(InputMismatchException inputMismatch)
						{
							System.out.println("ERROR");
							inputSelection = 0;
							continue;
						}
						catch(Exception e)
						{
							System.out.println("ERROR");
							inputSelection = 0;
							continue;
						}
					}
					inputSelection = 0;
					break;
				case 2:
					try {
						edi.calcAVGSal();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					inputSelection = 0;
					break;
				}
				
			}
			catch(InputMismatchException inputMismatch)
			{
				System.out.println("ERROR");
			}
		}
	}
}