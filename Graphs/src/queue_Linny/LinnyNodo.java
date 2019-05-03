package queue_Linny;

public class LinnyNodo<T> {
	
	
	private LinnyNodo<T> next;
	private LinnyNodo<T> previous;
	private T info;
	
	
 	public LinnyNodo(T info) {
 		this.info = info;
 	}
 	
 	public LinnyNodo(T info, LinnyNodo<T> next) {
 		this.info = info;
 		this.next = next;
 	}
 	
 	public LinnyNodo<T> getNext() {
 		return next;
 	}
 	
 	public void setNext(LinnyNodo<T> next) {
 		this.next = next;
 	}
 	
 	public LinnyNodo<T> getPrevious() {
 		return previous;
 	}
 	
 	public void setPrevious(LinnyNodo<T> previous) {
 		this.previous = previous;
 	}
 	
	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
 	
}
