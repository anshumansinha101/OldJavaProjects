// Java program to implement Max Heap 
public class MaxHeap { 
	private int[] Heap; 
	private int size; 
	private int maxsize; 

	// Constructor to initialize an 
	// empty max heap with given maximum 
	// capacity. 
	public MaxHeap(int maxsize) 
	{ 
		this.maxsize = maxsize; 
		this.size = 0; 
		Heap = new int[this.maxsize + 1]; 
		Heap[0] = Integer.MAX_VALUE; 
	} 

	// Returns position of parent 
	private int parent(int pos) 
	{ 
		return pos / 2; 
	} 

	// Below two functions return left and 
	// right children. 
	private int leftChild(int pos) 
	{ 
		return (2 * pos); 
	} 
	private int rightChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	} 

	// Returns true of given node is leaf 
	private boolean isLeaf(int pos) 
	{ 
		/* 
		 * Logic if pos of this node in array is greater than half of size and pos < size
		 * than it is leaf node else it is internal node. 
		 */
		if (pos >= (size / 2) && pos <= size) { 
			return true; 
		} 
		return false; 
	} 

	private void swap(int fpos, int spos) 
	{ 
		/** 
		 * General array element swapping code. 
		 */
		int tmp; 
		tmp = Heap[fpos]; 
		Heap[fpos] = Heap[spos]; 
		Heap[spos] = tmp; 
	} 

	// A recursive function to max heapify the given 
	// subtree. This function assumes that the left and 
	// right subtrees are already heapified, we only need 
	// to fix the root. 
	private void maxHeapify(int pos) 
	{ 
		/*
		 * Bottom up approach. 
		 * If the heapify is on leaf node then nothing do. 
		 */
		if (isLeaf(pos)) 
			return; 

		/**
		 * Since this is max heapify the root node is maximum.
		 * In this see if the child node is less than current node. 
		 * if not than it is following the heap property. 
		 */
		if (Heap[pos] < Heap[leftChild(pos)] || 
			Heap[pos] < Heap[rightChild(pos)]) { 

			/*
			 * If the code is here this indicates that any of the child node is greater than current node. 
			 * See which child node is greater. Make that as the root node or current node. 
			 * call this function again with the node which is swapped. 
			 */
			if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
				swap(pos, leftChild(pos)); 
				maxHeapify(leftChild(pos)); 
			} 
			else { 
				swap(pos, rightChild(pos)); 
				maxHeapify(rightChild(pos)); 
			} 
		} 
	} 

	// Inserts a new element to max heap array. The size is predefined. 
	/**
	 * Add an element in the 
	 * @param element
	 */
	public void insert(int element) 
	{ 
		Heap[++size] = element; 

		// Traverse up and fix violated property 
		int current = size; 
		/** 
		 * Move the node to right location. 
		 */
		while (Heap[current] > Heap[parent(current)]) { 
			swap(current, parent(current)); 
			current = parent(current); 
		} 
	} 

	public void print() 
	{ 
		for (int i = 1; i <= size / 2; i++) { 
			System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
					Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
			System.out.println(); 
		} 
	} 

	// Remove an element from max heap 
	public int extractMax() 
	{ 
		int popped = Heap[1]; 
		Heap[1] = Heap[size--]; 
		maxHeapify(1); 
		return popped; 
	} 

	public static void main(String[] arg) 
	{ 
		System.out.println("The Max Heap is "); 
		MaxHeap maxHeap = new MaxHeap(15); 
		maxHeap.insert(5); 
		maxHeap.insert(3); 
		maxHeap.insert(17); 
		maxHeap.insert(10); 
		maxHeap.insert(84); 
		maxHeap.insert(19); 
		maxHeap.insert(6); 
		maxHeap.insert(22); 
		maxHeap.insert(9); 

		maxHeap.print(); 
		System.out.println("The max val is " + maxHeap.extractMax()); 
	} 
} 
