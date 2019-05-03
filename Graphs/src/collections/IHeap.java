package collections;

public interface IHeap<A> {
	
	public int parent(int pos);
	public int leftChild(int pos);
	public int rightChild(int pos);
	public boolean isLeaf(int pos);
	public void swap(int fpos, int spos);
	public void maxHeapify(int index);
	public void insertMax(A element, int priority);
	public void insertMin(A element, int priority);
	public void maxHeap();
	public void minHeapify(int index);
	public A removeMax();
	public A removeMin();
	public A max();
	public int size();
	public void print();
	
	public void minHeap();

}
