package collections;

public class Heap<A>  implements IHeap<A>{
	
	public static final int FRONT = 1;
	
	private NodeList<A>[] Heap;
	private int sizeM;
	private int maxSize;
	
	public Heap(int maxSize) {
		
		this.maxSize = maxSize;
		this.sizeM = 0;
		Heap = new NodeList[maxSize+1];
		
		Heap[0] = new NodeList<A>(null,Integer.MAX_VALUE );
	}

	@Override
	public int parent(int pos) {
		
		return pos/2;
	}

	@Override
	public int leftChild(int pos) {
		
		return (2*pos);
	}

	@Override
	public int rightChild(int pos) {
		
		return (2*pos) + 1;
	}

	@Override
	public boolean isLeaf(int pos) {

		if(pos >=(sizeM/2) && pos <= sizeM) {
			return true;
		}
		return false;
	}

	@Override
	public void swap(int fpos, int spos) {
		
		NodeList<A> temp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = temp;
		
	}
	


	@Override
	public void minHeapify(int index) {

		
		
		while(hasLeftChild(index)) {
			
			int largest = leftChild(index);
			if(hasRightChild(index) && Heap[leftChild(index)].getPriority() < Heap[rightChild(index)].getPriority()) {
				largest = rightChild(index);
			}
			if(Heap[index].getPriority() < Heap[largest].getPriority()) {
				
				swap(index,largest);
				minHeapify(largest);
			}
			else break;
			
		}
	}
	
	private boolean hasLeftChild(int i){
		return leftChild(i) <= sizeM;
	}
	
	private boolean hasRightChild(int i)
	{
		return rightChild(i) <= sizeM;
	}

	@Override
	public void maxHeapify(int index) {
	
		while(hasLeftChild(index)) {
			
			int smallest = leftChild(index);
			if(hasRightChild(index) && Heap[leftChild(index)].getPriority() > Heap[rightChild(index)].getPriority()) {
				smallest = rightChild(index);
			}
			if(Heap[index].getPriority() > Heap[smallest].getPriority()) {
				
				swap(index,smallest);
				maxHeapify(smallest);
			}
			else break;
			
		}
		
	}

	@Override
	public void insertMax(A element, int priority) {
		NodeList<A> add = new NodeList<A>(priority, element);
		setSizeM(sizeM+1);
		Heap[sizeM] = add;
		maxHeap();
		
	}

	@Override
	public void maxHeap() {
		
		int index = sizeM;
		
		while(parent(index) != 0 && (Heap[parent(index)].getPriority() < Heap[index].getPriority() )) {
			
			swap(index, parent(index));
			index = parent(index);
		}		
		
	}

	@Override
	public A removeMax() {
		
		NodeList<A> remove = Heap[FRONT];
		Heap[FRONT] = Heap[sizeM];
		Heap[sizeM] = null;
		setSizeM(sizeM-1);
		minHeapify(FRONT);
		
		
		return remove.getInfo();
	}

	@Override
	public A max() {
		
		return Heap[FRONT].getInfo();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return sizeM;
	}
	
	public void print() {
		
		for(int i=1; i<sizeM+1; i++) {
			
			System.out.println(Heap[i].getInfo().toString());
						
		}
		
	}

	/**
	 * @return the sizeM
	 */
	public int getSizeM() {
		return sizeM;
	}

	/**
	 * @param sizeM the sizeM to set
	 */
	public void setSizeM(int sizeM) {
		this.sizeM = sizeM;
	}

	@Override
	public void minHeap() {

		int index = sizeM;
		
		while(parent(index) != 0 && (Heap[parent(index)].getPriority() > Heap[index].getPriority() )) {
			
			swap(index, parent(index));
			index = parent(index);
		}
		
	}

	@Override
	public void insertMin(A element, int priority) {
		
		NodeList<A> add = new NodeList<A>(priority, element);
		setSizeM(sizeM+1);
		Heap[sizeM] = add;
		minHeap();
		
	}

	@Override
	public A removeMin() {
		
		NodeList<A> remove = Heap[FRONT];
		Heap[FRONT] = Heap[sizeM];
		Heap[sizeM] = null;
		setSizeM(sizeM-1);
		maxHeapify(FRONT);
		
		
		return remove.getInfo();
		
	}
	
	

	
	
	

}
