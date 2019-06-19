import java.util.Scanner;
import java.util.*;


public class CalculatorUser {
	public static void main(String[] args) {
		  double num1 = 0;
		double num2 = 0;
		Calculator calculator = new Calculator();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the first number");
		if(sc.hasNextInt()) {
			
			num1 = sc.nextInt();}else if(sc.hasNextDouble()) {
				num1 = sc.nextDouble();
			}else {
			while(sc.hasNextInt()==false&&sc.hasNextDouble()==false) {
				System.out.println("Please enter a valid integer or floating point value.");
				sc.next();
			}
			num1 = sc.nextDouble();
			
		}
		System.out.println("Please enter the second number");
if(sc.hasNextInt()) {
			
			num2 = sc.nextInt();}else if(sc.hasNextDouble()) {
				num2 = sc.nextDouble();
			}else {
			while(sc.hasNextInt()==false&&sc.hasNextDouble()==false) {
				System.out.println("Please enter a valid integer or floating point value.");
				sc.next();
			}
			num2 = sc.nextDouble();
		}
		
		System.out.println(String.valueOf(num1) + "times " + num2 + " equals " + calculator.multiply(num1, num2));
		System.out.println(String.valueOf(num1) + "divided by " + num2 + " equals " +calculator.divide(num1, num2));
		System.out.println(String.valueOf(num1) + "minus " + num2 + " equals " + calculator.subtract(num1, num2));
		System.out.println(String.valueOf(num1) + "plus " + num2 + " equals " +calculator.add(num1, num2));
		
		
		
		}
	
				
}
