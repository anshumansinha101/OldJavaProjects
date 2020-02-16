

//A Java program to print all subsets of a set 
import java.io.IOException; 
import java.util.HashSet;
import java.util.Set;

class PrintAllSubsetofSet 
{ 
	private static int sum = 500;
	// Print all subsets of given set[] 
	static void printSubsets(int set[]) 
	{ 
		// n = 3 in this case
		int n = set.length; 

		// Run a loop for printing all 2^n 
		// subsets one by one
		// 1 = bit wise 0000 00001
		// n =1 => 0000 0010
		// n =2 => 0000 0100
		// n =3 => 0000 1000 =  1 * 2 pow 3  = 8 
		// This loop will run for 8 times 
		// in other word 1<<n is way to calculate the number of power set for n elements.
		for (int i = 0; i < (1<<n); i++) 
		{ 
			//System.out.print("{ "); 
			int temp = 0;
			Set s = new HashSet();
			// Print current subset 
			for (int j = 0; j < n; j++) 
			{
				// (1<<j) is a number with jth bit 1 
				// so when we 'and' them with the 
				// subset number we get which numbers 
				// are present in the subset and which 
				// are not 
			/*	System.out.print("	i:" + Integer.toBinaryString(i) +  ",j:" + 
						Integer.toBinaryString(j));
				int j1 = 1 << j;*/
				/*System.out.print(",1<<j:" + Integer.toBinaryString(j1) );
				System.out.print(",i&j1:" + Integer.toBinaryString(i&j1) );
				*/
				if ((i & (1 << j)) > 0) 
				{
					//System.out.print("   --> "+set[j] + " "); 
					s.add(new Integer(set[j]));
					temp = temp + set[j];
				}
				if(temp == sum)
				{
					System.out.println(s.toString());
				}
				System.out.println();
			}	
			//System.out.println("}"); 
		} 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		int set[] = {200, 300, 500}; 
		printSubsets(set); 
	} 
} 
