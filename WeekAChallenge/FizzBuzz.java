
public class FizzBuzz {
	int[] numbers;
	String[] terms;
	int m;
	int n;
	
	public void fizzBuzzBasic(){
		
		System.out.print("{");
		for(int i = 1;i<=100;i++) {
			if(i%15 == 0) {
				System.out.print("FizzBuzz");
			}else if(i%3==0) {
				System.out.print("Fizz");
			}else if(i%5==0) {
				System.out.print("Buzz");
			}else {
				System.out.print(i);
			}
			
			if(i==100) {
				System.out.println("}");
			}else {
				System.out.print(", ");
			}
			
		}
	}
	
	public void fizzBuzzAdvanced(int m, int n, int[] numbers, String[]terms) {
	
			System.out.print("{");
			for(int j = m;j<=n;j++) {
				String answer = "";
				for(int v = 0;v<terms.length;v++) {
				
				if(numbers[v] == 0) {
					continue;
				}
				if(j%numbers[v]==0) {
					answer += terms[v];
				continue;
			}
			
								
			
				}
				if(answer.equals("")) {
					System.out.print(j);
				}else {
			System.out.print(answer);
				
				}
				if(j==n) {
					System.out.println("}");
				}else {
					System.out.print(", ");
				}
				
		}
	}
}
