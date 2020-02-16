// Java program to rearrange characters in a string 
// so that no two adjacent characters are same. 
import java.io.*; 
import java.util.*; 

class KeyComparator implements Comparator<Key> { 

	// Overriding compare()method of Comparator 
	public int compare(Key k1, Key k2) 
	{ 
		System.out.println("New key added is " + k1 + ",compared with existing one:" + k2);
		// it works sorting from less to more. If New one is more than old it should return + is negative.
		return -(k1.freq - k2.freq);
		/*
		 * if (k1.freq < k2.freq) { System.out.
		 * println("Returning 1. Frequency of new one is less than existing one.");
		 * return 1;
		 * 
		 * } else if (k1.freq > k2.freq) { System.out.
		 * println("Returning -1. Frequency of new one is more than existing one.");
		 * return -1; } return 0;
		 */
	} 
} 

class Key { 
	int freq; // store frequency of character 
	char ch; 
	Key(int val, char c) 
	{ 
		freq = val; 
		ch = c; 
	} 
	
	public String toString()
	{
		return this.ch + " " + this.freq;
	}
} 

class Rearrange_characters_in_a_string_such_that_no_two_adjacent_same { 
	static int MAX_CHAR = 26; 

	// Function to rearrange character of a string 
	// so that no char repeat twice 
	static void rearrangeString(String str) 
	{ 
			int n = str.length(); 

			// Store frequencies of all characters in string 
			int[] count = new int[MAX_CHAR]; 
			
			for (int i = 0; i < n; i++) 
				count[str.charAt(i) - 'a']++; 

			// Insert all characters with their frequencies 
			// into a priority_queue 
			PriorityQueue<Key> pq = new PriorityQueue<>(new
														KeyComparator()); 
			for (char c = 'a'; c <= 'z'; c++) { 
				int val = c - 'a'; 
				if (count[val] > 0) 
				{
					Key k = new Key(count[val], c);
					System.out.println("Adding new key" + k);
					pq.add(k); 
					System.out.println("pq:" + pq);
			
				} 
			}
			//System.out.println("pq:" + pq);
			System.out.println(pq.peek());
				
			// 'str' that will store resultant value 
			str = "" ; 

			// work as the previous visited element 
			// initial previous element be. ( '#' and 
			// it's frequency '-1' ) 
			Key prev = new Key(-1, '#'); 

			// traverse queue 
			System.out.println("PQ size:" + pq.size());
			while (pq.size() != 0) { 
					System.out.println("Inside while loop.");
					// pop top element from queue and add it 
					// to string. 
					Key k = pq.peek(); 
					str = str + k.ch; 

					System.out.println("str:" + str);
					System.out.println("Polling");
					pq.poll();
					// If frequency of previous character is less 
					// than zero that means it is useless, we 
					// need not to push it 
					if (prev.freq > 0) 
						pq.add(prev); 

					// make current character as the previous 'char' 
					// decrease frequency by 'one' 
					(k.freq)--; 
					prev = k; 
					System.out.println(pq);
			} 

			// If length of the resultant string and original 
			// string is not same then string is not valid 
			if (n != str.length()) 
				System.out.println(" Not valid String "); 
			else
				System.out.println(str); 
	} 

	// Driver program to test above function 
	public static void main(String args[]) 
	{ 
			String str = "aaabc" ; 
			rearrangeString(str); 
	} 
} 

// This code is contributed by rachana soma 
