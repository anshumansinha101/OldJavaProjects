import java.util.Iterator;
import java.util.Stack;

/*
 * Using stack this can be solved in linear term
 * 
 * Logic:
 * If in the stack there is pop value less than equal current value then pop. 
 * after the no of span for that i = i+1 is stack is empty else index of last value 
 * which is greater than the current value. 
 * 
 * Push i into stack 
 */

public class StockSpanUsingStack {

	
	public void calculateSpan(int[] price, int span[])
	{
		Stack s = new Stack();
		s.push(new Integer(0));
		span[0]=1;
		
		for (int i = 1; i < price.length; i++) {
			Integer t = (Integer)s.peek();
			if(!s.empty() && price[t.intValue()] <= price[i])
			{
				s.pop();
			}
			Integer t1 = null;
			if (!s.empty()) 
				 t1 = (Integer)s.peek();
			span[i] = (s.empty()) ? (i+1) : (i - t1.intValue());
			
			s.push(new Integer(i));
			
		}
	}
	
	private void printArray(int[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "   ");
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		StockSpanUsingStack self = new StockSpanUsingStack();
		//int price[] =  {100, 80, 60, 70, 60, 75, 85};
		int price[] = { 10, 4, 5, 90, 120, 80 };
		int span[] = new int[price.length];
		self.calculateSpan(price,span);
		self.printArray(span);
	}
	
}
