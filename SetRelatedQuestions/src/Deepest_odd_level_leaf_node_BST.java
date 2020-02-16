import java.util.LinkedList;

// Java program to find depth of deepest odd level N1 

// A binary tree N1 
/**Also solving these
 * Question  - https://www.geeksforgeeks.org/deepest-right-leaf-node-binary-tree-iterative-approach/
 * Similar - https://www.geeksforgeeks.org/deepest-left-leaf-node-binary-tree-iterative-approach/
 * https://www.geeksforgeeks.org/deepest-left-leaf-node-in-a-binary-tree/
 * https://www.geeksforgeeks.org/depth-deepest-odd-level-node-binary-tree/
 * https://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/
 * https://www.geeksforgeeks.org/get-level-node-binary-tree-iterative-approach/
 * https://www.geeksforgeeks.org/smallest-value-level-binary-tree/
 * https://www.geeksforgeeks.org/largest-value-level-binary-tree-set-2-iterative-approach/
 * https://www.geeksforgeeks.org/level-maximum-number-nodes/
 * https://www.geeksforgeeks.org/averages-levels-binary-tree/
 * https://www.geeksforgeeks.org/maximum-sum-tree-adjacent-levels-not-allowed/
 * https://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels/
 * https://www.geeksforgeeks.org/sum-leaf-nodes-minimum-level/
 * https://www.geeksforgeeks.org/check-if-a-binary-tree-is-sorted-level-wise-or-not/
 * https://www.geeksforgeeks.org/print-nodes-odd-levels-tree/
 * https://www.geeksforgeeks.org/find-first-non-matching-leaves-two-binary-trees/
 * 
 * 
 *  https://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 * https://www.geeksforgeeks.org/height-binary-tree-considering-even-level-leaves/
 * https://www.geeksforgeeks.org/find-deepest-node-binary-tree/
 * @author anshuman
 *
 */
class N1 {
	int data;
	N1 left, right;

	N1(int item) {
		data = item;
		left = right = null;
	}
}

class Deepest_odd_level_leaf_node_BST {
	N1 root;
	LinkedList<N1> ll = new LinkedList<>();
	Node leadNode;

	public void findDeepestOddLevelLeafNode() {
		ll.add(root);
		int levelCnt = 1;
		N1 rightesNode = root;
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
				{
					rightesNode = r;
					ll.add(r);
				}
				sizeOfQueue -= 1;
				
			}
			levelCnt = levelCnt + 1;
			System.out.println("Level Changing to " + levelCnt);
		}
		System.out.println("Righted Node is "  + rightesNode.data);
	}

	public static void main(String args[]) {
		int k = 45;
		Deepest_odd_level_leaf_node_BST tree = new Deepest_odd_level_leaf_node_BST();
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
