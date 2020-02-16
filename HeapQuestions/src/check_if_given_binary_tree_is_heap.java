import java.util.Deque;
import java.util.LinkedList;

public class check_if_given_binary_tree_is_heap {
	
	/**
	 * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/
	 */
	
	public boolean isHeap(Node n)
	{
		Deque<Node> q = new LinkedList<Node>();
		q.add(n);
		Node parent = n;
		while(!q.isEmpty())
		{
			int nodeCnt = q.size();
			while(nodeCnt >0)
			{
				
				Node temp = q.poll();
				if(temp==null)
				{
					System.out.println("Node cnt:"  + nodeCnt + ", parent:" + parent + ", q:" + q);
				}
				Node l = temp.left;
				Node r = temp.right;
				if(l!= null)
				{
					q.add(l);
					if(l.key > parent.key)
					{
						return false;
					}
					
				}
				if(r!= null)
				{
					q.add(r);
					if(r.key > parent.key)
					{
						return false;
					}
					
				}
				
				parent  = temp;
				nodeCnt-=1;
			}
				
			
		}	
		return true;	
	}
	
	
	public static void main(String[] args) {
		check_if_given_binary_tree_is_heap self = new check_if_given_binary_tree_is_heap();
		Node root = new Node(10); 
        root.left = new Node(9); 
        root.right = new Node(8); 
        root.left.left = new Node(7); 
        root.left.right = new Node(6); 
        root.right.left = new Node(5); 
        root.right.right = new Node(4); 
        root.left.left.left = new Node(3); 
        root.left.left.right = new Node(2); 
        root.left.right.left = new Node(1); 
  
        if(self.isHeap(root) == true) 
            System.out.println("Given binary tree is a Heap"); 
        else 
            System.out.println("Given binary tree is not a Heap");
	}
}
	class Node 
	{ 
	    int key; 
	    Node left, right; 
	  
	    Node(int k) 
	    { 
	        key = k; 
	        left = right = null; 
	    } 
	} 

