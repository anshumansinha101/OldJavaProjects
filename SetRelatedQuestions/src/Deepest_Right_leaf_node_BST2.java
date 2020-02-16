import java.util.LinkedList;

// Java program to find depth of deepest odd level N1 

// A binary tree N1 
/**Also solving these
 *  https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 * https://www.geeksforgeeks.org/height-binary-tree-considering-even-level-leaves/
 * https://www.geeksforgeeks.org/find-deepest-node-binary-tree/
 * @author anshuman
 *
 */


class Deepest_Right_leaf_node_BST2 {
	N1 root;
	LinkedList<N1> ll = new LinkedList<>();
	Node leadNode;

	public void findDeepestOddLevelLeafNode() {
		ll.add(root);
		int levelCnt = 1;
		boolean hasLeafNode;
		int lastOddLevelFoundLeadNode = 0;
		while (!ll.isEmpty()) {

			int sizeOfQueue = ll.size();
			
			while (sizeOfQueue > 0) {
				N1 temp = ll.poll();
				N1 l = temp.left;
				N1 r = temp.right;
				if (l != null) {

					ll.add(l);
				}
				if (r != null)
					ll.add(r);
				sizeOfQueue -= 1;
				if (levelCnt % 2 != 0) {
					System.out.println("This is odd level");
					if (l !=null && l.left == null && l.right == null) {
						System.out.println("Found a leaf node");
						// this is a leaf node.
						lastOddLevelFoundLeadNode = levelCnt;
					} else if (r!=null && r.left == null && r.right == null) {
						System.out.println("Found a leaf node");
						// this is a leaf node.
						lastOddLevelFoundLeadNode = levelCnt;
					}

				}
			}
			levelCnt = levelCnt + 1;
			System.out.println("Level Changing to " + levelCnt);
		}
		System.out.println("lastOddLevelFoundLeadNode: "  + lastOddLevelFoundLeadNode);	

	}

	public static void main(String args[]) {
		int k = 45;
		Deepest_Right_leaf_node_BST2 tree = new Deepest_Right_leaf_node_BST2();
		tree.root = new N1(1);
		tree.root.left = new N1(2);
		tree.root.right = new N1(3);
		tree.root.left.left = new N1(4);
		tree.root.right.left = new N1(5);
		tree.root.right.right = new N1(6);
		tree.root.right.left.right = new N1(7);
		tree.root.right.right.right = new N1(8);
		tree.root.right.left.right.left = new N1(9);
		tree.root.right.right.right.right = new N1(10);
		tree.root.right.right.right.right.left = new N1(11);
		tree.findDeepestOddLevelLeafNode();
		// System.out.println(tree.depthOfOddLeaf(tree.root) +
		// " is the required depth");
	}
}

// This code has been contributed by Mayank Jaiswal 
