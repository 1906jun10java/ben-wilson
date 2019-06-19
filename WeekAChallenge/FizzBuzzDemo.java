
import java.util.Scanner;

public class FizzBuzzDemo {

	public static void main(String[] args) throws InputMistypingException {
		FizzBuzz fizzBuzz = new FizzBuzz();

		int m = 1;
		int n = 100;
		int range = n;

		String[] terms = new String[range];
		terms[0] = "fizz";
		terms[1] = "buzz";
		int[] numbers = new int[range];
		numbers[0] = 3;
		numbers[1] = 5;
		System.out.println("\t~~~~~~~~PART 1 - FIZZBUZZ BASIC~~~~~~~~~");
		fizzBuzz.fizzBuzzBasic();

		System.out.println("\n\t~~~~~~~~PART 2 - FIZZBUZZ ADVANCED~~~~~~~~~");

		System.out.println("\n\n\t**************PART 2.A *************\n\t(values pre-defined in source code)\n\n\t");

		fizzBuzz.fizzBuzzAdvanced(m, n, numbers, terms);
		System.out.println("\n\n\t**************PART 2.B *************\n\t(values from command line)\n\n\t");

		Scanner sc = new Scanner(System.in);

		System.out.println("\tPlease type the first number in your desired range");
		m = sc.nextInt();
		System.out.println("\tPlease type the last number in your desired range");
		n = sc.nextInt();
		System.out.println("\tPlease type the number of elements in the numbers array");
		int n1 = sc.nextInt(); // number of numbers

		numbers = new int[n1];

		for (int i = 0; i < n1; i++) {
			System.out.println("What is element #" + String.valueOf(i) + " in the numbers array?");
			numbers[i] = sc.nextInt();
		}
		System.out.println("\nPlease type the number of terms");
		int n2 = sc.nextInt(); // number of terms

		terms = new String[n2];
		System.out.println("What is the next term?");
		for (int j = 0; j < n2; j++) {
			terms[j] = sc.next();
			
		}

		fizzBuzz.fizzBuzzAdvanced(m, n, numbers, terms);

		sc.close();
	}
}
