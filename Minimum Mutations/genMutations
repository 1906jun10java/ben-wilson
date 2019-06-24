import java.util.*; 
import java.util.Arrays;
import java.util.stream.IntStream;



public class genMutations {
	
public static void main(String[] args) {

	String start = "AACCGGTT";
	
	String end = "AAACGGTA";
			
	String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
	
	System.out.println("If there is no mutation, we output -1. If they are the same, we output 0. The number is: " + genMutation(start, end));
	
	long basePairDiff = IntStream.iterate(0, x-> x+1)
			.limit(start.length()).filter(i -> start.charAt(i) != end.charAt(i)).count();
	
	System.out.println("There are " + basePairDiff + " base pair differences between the gene sequences.");
		
}
	
static int genMutation(String start, String end) {

	if(start.equals(end)) 
		return 0;
	else
		return -1;

}

}
