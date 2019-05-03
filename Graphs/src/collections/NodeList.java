package collections;

public class NodeList<N> {
	
	private N info;
	private NodeList<N> next;
	private NodeList<N> prev;
	private int priority;
	private int key;
	
	public NodeList(N info) {
		
		this.info = info;
		
	}
	
	public NodeList(N info, int key) {
		
		this.info = info;
		this.key = key;
	}
	
	public NodeList( int priority, N info) {
		
		this.info = info;
		this.priority = priority;
		
	}
	
	
	public N getInfo() {
		return info;
	}

	public void setInfo(N info) {
		this.info = info;
	}

	public NodeList<N> getNext() {
		return next;
	}
	
	public void setNext(NodeList<N> next) {
		this.next = next;
	}

	public NodeList<N> getPrev() {
		return prev;
	}

	public void setPrev(NodeList<N> prev) {
		this.prev = prev;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}


	public int getKey() {
		return key;
	}


	public void setKey(int key) {
		this.key = key;
	}

}
