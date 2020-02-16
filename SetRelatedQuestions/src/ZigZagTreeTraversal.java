import java.util.LinkedList;

public class ZigZagTreeTraversal {

	public static void main(String[] args) {
		TNode n1 = new TNode(1);
		TNode n2 = new TNode(2);
		TNode n3 = new TNode(3);
		TNode n4 = new TNode(4);
		TNode n5 = new TNode(5);
		TNode n6 = new TNode(6);
		TNode n7 = new TNode(7);
		TNode n8 = new TNode(8);
		TNode n9 = new TNode(9);
		
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n6;
		n4.right = n7;
		n5.left = n8;
		n5.right = n9;
		
		ZigZagTreeTraversal self = new ZigZagTreeTraversal();
		self.zigzagPrint(n1);
	}
	
	public void zigzagPrint(TNode root)
	{	
		System.out.println(" " + root.val);
		LinkedList<TNode> ll = new LinkedList<TNode>();
		ll.add(root);
		int level = 1;
		boolean leftToRight=false;
		while(!ll.isEmpty())
		{
			int nodeCnt = ll.size();
			
			if(nodeCnt == 0)
				return ;
			System.out.print("Node Cnt:" + nodeCnt + "   ,");
			while(nodeCnt > 0)
			{
				TNode t = ll.poll();
				if(t!=null)
				{
					TNode l = t.left;
					TNode r = t.right;
					if(leftToRight)
					{
						System.out.print(" Left to right true.");
						if(l!=null)
						{	
							System.out.print("  " + l.val);
							ll.add(l);
						}
						if(r!=null)
						{
							System.out.print("  " + r.val);
							ll.add(r);
						}
						
					}
					else
					{
						System.out.print(" Right to left true.");
						if(r!=null)
						{
							System.out.print("  " + r.val);
							ll.add(r);
						}
						if(l!=null)
						{	
							System.out.print("  " + l.val);
							ll.add(l);
						}
						
						
					}
					
				}
				
				nodeCnt -=1;
			}
			leftToRight = leftToRight?false:true;
			System.out.println("Level end reached");
		}
	}
}
