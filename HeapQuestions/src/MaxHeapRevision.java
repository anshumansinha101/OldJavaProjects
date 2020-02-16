
public class MaxHeapRevision {

	private int[] heap ;
	private int size;
	private int max_size;

	/**
	 * Insert into heap
	 * 
	 * @param i
	 */
	private int parent(int i) {

		return i / 2;
	}

	private int left(int i) {
		return 2 * i;
	}

	private int right(int i) {
		return 2 * i + 1;
	}

	public boolean isLeaf(int i) {
		if (i >= (size / 2) && i <= size) {
			return false;
		}
		return true;
	}

	public void insert(int val) {
		/**
		 * Insert at the end of array. Than check if this value is greater than parent
		 * in that case swap.
		 */
		heap[size] = val;
		int current = size;
		size += 1;
		while (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}

	}

	private void swap(int i, int j) {
		int t1 = heap[i];
		int t2 = heap[j];
		heap[i] = t2;
		heap[j] = t1;
	}

	//Is ko yaad karo.
	private void heapify(int i) {
		if (isLeaf(i))
			return;

		if (heap[left(i)] > heap[i] || heap[right(i)] > heap[i]) {
			// koi to child bada hai. Ya dono.. agar dono than jo jyada bada hai usse swap
			// karo.

			if (heap[left(i)] > heap[right(i)]) {
				swap(left(i), i);
				heapify(left(i));
			} else {
				swap(right(i), i);
				heapify(right(i));
			}
		}
	}

	public int extractMax() {
		int popped = heap[1];
		heap[1] = heap[size--];
		heapify(1);
		return popped;

	}

	public int getMax() {
		return heap[0];
	}
	public MaxHeapRevision(int size)
	{
		this.max_size = size; 
		this.size = 0; 
		heap = new int[this.max_size + 1]; 
		heap[0] = Integer.MAX_VALUE; 
	}
	
	public void print() 
	{ 
		for (int i = 1; i <= size / 2; i++) { 
			System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + 
					heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]); 
			System.out.println(); 
		} 
	} 
	public static void main(String[] arg) 
	{ 
		System.out.println("The Max Heap is "); 
		MaxHeapRevision maxHeap = new MaxHeapRevision(15); 
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
