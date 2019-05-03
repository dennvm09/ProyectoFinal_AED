package queue_Linny;

public interface IQueue<T> {
	
	public T linnyPeek();
	public T linnyPoll();
	public boolean isEmpty();
	public int linnySize();
	void linnyOffer(T n);
	

}
