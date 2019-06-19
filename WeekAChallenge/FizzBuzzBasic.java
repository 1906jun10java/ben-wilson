public class FizzBuzzBasic {
	
	public static void main (String[] args) {
		int numbers = 100; 
		
		for(int x = 1; x <= 100; x++) {
		
		if(x % 15 == 0) { 
			System.out.println("FizzBuzz");}
		
		else if(x % 5 == 0) { 
			System.out.println("Buzz");}
		
		else if(x % 3 == 0) {
			System.out.println("Fizz");}
		
		else {
			System.out.println(x);}
		}
	}
}