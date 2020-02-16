import java.util.LinkedList;

/** 
 * this can be solved using recursion as well. 
 * @author anshuman
 *
 */

public class LevelOrderTreeTraversal {
	
	public void levelOrderTraversal(TNode root)
	{
		LinkedList<TNode> ll = new LinkedList();
		if(root == null)
			return; 
		
		ll.add(root);
		
		while(!ll.isEmpty())
		{
			TNode t = ll.pop();
			System.out.println(" " + t.val);
			if(t.left!=null)
				ll.add(t.left);
			if(t.right!=null)
				ll.add(t.right);
				
			
		}
		
	}
	public static void main(String[] args) {
		TNode n1 = new TNode(22);
		TNode n2 = new TNode(23);
		TNode n3 = new TNode(55);
		TNode n4 = new TNode(66);
		TNode n5 = new TNode(6);
		TNode n6 = new TNode(7);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.left = n6;
		LevelOrderTreeTraversal self = new LevelOrderTreeTraversal();
		self.levelOrderTraversal(n1);
		
	}
	 
}
class TNode
{
	public TNode(int val)
	{
		this.val = val;
	}
	TNode left;
	TNode right;
	int val;
	
}
