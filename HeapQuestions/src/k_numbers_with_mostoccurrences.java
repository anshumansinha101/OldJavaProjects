import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
 * 
 * Similar problem 
 * https://www.geeksforgeeks.org/kth-largest-element-in-a-stream/
 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
 * https://www.geeksforgeeks.org/nearly-sorted-algorithm/
 * https://www.geeksforgeeks.org/tournament-tree-and-binary-heap/ : This is interesting. Finding second best player. 
 * @author anshuman
 *
 */
public class k_numbers_with_mostoccurrences {
	
	class MyComparator implements Comparator<Key>
	{

		@Override
		public int compare(Key o1, Key o2) {
			if(o1.freq > o2.freq)
			{
				return -1;
			}
			else
				return 1;
		}
		
	}
	public void kMostOccrences(int[] arr, int k)
	{
		int[] count = new int[100]; 
		int n = arr.length;
		for (int i = 0; i < n; i++) 
		{
			System.out.println("i" + i);
			
				count[arr[i]]+=1; 
		}
		PriorityQueue<Key> pq = new PriorityQueue(k, new MyComparator());
		for (int i = 0; i < 100; i++) {
			if(count[i]>0)
				pq.add(new Key(i, count[i]));
			
		}
		for(int i = 0 ; i < k; i++)
		{
			Key k1 = pq.poll();
			System.out.println("K" + i + ": " + k1 );
		}
	}
	
	class Key
	{
		public Key(int val,int freq)
		{
			this.val = val;
			this.freq = freq;
		}
		int val;
		int freq;
		public String toString()
		{
			return "val:" + val + ", freq:" + freq;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
		k_numbers_with_mostoccurrences self = new k_numbers_with_mostoccurrences();
		self.kMostOccrences(arr, 5);
	}
}
