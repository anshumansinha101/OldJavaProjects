/* We can use Java inbuilt Deque as a double 
ended queue to store the cache keys, with 
the descending time of reference from front 
to back and a set container to check presence 
of a key. But remove a key from the Deque using 
remove(), it takes O(N) time. This can be 
optimized by storing a reference (iterator) to 
each key in a hash map. */
import java.util.Deque; 
import java.util.HashSet; 
import java.util.LinkedList; 
import java.util.Iterator; 
public class LRUCache { 
	// store keys of cache 
	static Deque<Integer> dq; 
	// store references of key in cache 
	static HashSet<Integer> map; 
	// maximum capacity of cache 
	static int csize; 

	LRUCache(int n) 
	{ 
		dq = new LinkedList<>(); 
		map = new HashSet<>(); 
		csize = n; 
	} 

	/* Refers key x with in the LRU cache */
	public void refer(int x) 
	{ 
		// when a key is accessed then the LRU sequence will change. 
		// if map does not have the key, meaning the refer one is not in the queue. then it should be added. 
		// then this key should be added in the cache . if the cache is full remove one last element. 
		if (!map.contains(x)) { 
			if (dq.size() == csize) { 
				int last = dq.removeLast(); 
				map.remove(last); 
			} 
		} 
		else { 
			/* The found page may not be always the last element, even if it's an 
			intermediate element that needs to be removed and added to the start 
			of the Queue */
			int index = 0, i = 0; 
			Iterator<Integer> itr = dq.iterator(); 
			while (itr.hasNext()) { 
				// found the element at index position .. remove and add at the first position in the cache. 
				if (itr.next() == x) { 
					index = i; 
					break; 
				} 
				i++; 
			} 
			dq.remove(index); 
		} 
		dq.push(x); 
		map.add(x); 
	} 

	// display contents of cache 
	public void display() 
	{ 
		Iterator<Integer> itr = dq.iterator(); 
		while (itr.hasNext()) { 
			System.out.print(itr.next() + " "); 
		} 
	} 

	public static void main(String[] args) 
	{ 
		LRUCache ca = new LRUCache(4); 
		ca.refer(1); 
		ca.refer(2); 
		ca.refer(3); 
		ca.refer(1); 
		ca.refer(4); 
		ca.refer(5); 
		ca.display(); 
	} 
} 
// This code is contributed by Gaurav Tiwari 
