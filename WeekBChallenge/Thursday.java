package weekBActivity2;

public class Thursday {
	
	public static void main(String[] args) {
		String str = "Stringing it together";
		String substr = "together";
		System.out.println(containsSubstring(str, substr));
		int numberofBlocks = 0;
		System.out.println(triCalculator(87));
	}
		public static boolean containsSubstring(String str, String substr){
			boolean containsSubstring = str.contains(substr);
			return containsSubstring; 
			
	    }
		
		public static int triCalculator(int numberOfRows) {
			int numberOfBlocks = numberOfRows * (numberOfRows + 1) / 2;
			return numberOfBlocks;
		}
		
}
