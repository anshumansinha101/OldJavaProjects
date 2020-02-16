

//A Java program to print all subsets of a set 
import java.io.IOException; 

class CopyOfPrintAllSubsetofSet 
{ 
	// Print all subsets of given set[] 
	static void printSubsets(char set[]) 
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
			//System.out.println(Integer.toBinaryString(i));
			System.out.println();
			for(int j = 0; j < n;j++)
			{
				// j = 0, 1 , 2 
				// i = 0 - 7 
				
			}
			
		} 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 
		char set[] = {'a', 'b', 'c'}; 
		printSubsets(set); 
	} 
} 
