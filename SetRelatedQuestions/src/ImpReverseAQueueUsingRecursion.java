import java.util.Deque;
import java.util.LinkedList;
/**
 * This is a code to reverse a queue. 
 * When first k element has to be reversed then keep a counter to track that. 
 * @author anshuman
 *
 */
public class ImpReverseAQueueUsingRecursion {
	
	LinkedList<Integer> ll  = new LinkedList();
	int cnt = 0;
	int k = 3;
	private LinkedList<Integer> reverseMe()
	{
		
		if(cnt > k)
		{
			return ll;
		}
		if(ll.isEmpty())
			return ll;
		
		int d = ll.poll();
		cnt+=1;
		ll = reverseMe();
		
		ll.add(d);
		return ll;
	}
	
	
	
	
	public static void main(String[] args) {
		ImpReverseAQueueUsingRecursion self = new ImpReverseAQueueUsingRecursion();
		self.ll.add(1);
		self.ll.add(2);
		self.ll.add(3);
		self.ll.add(4);
		self.ll.add(5);
		System.out.println(self.ll);
		self.reverseMe();
		
		System.out.println(self.ll);
		
	}

}
