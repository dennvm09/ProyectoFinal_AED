package stack_Linny;

public interface ILinny<T> {
	
	
	public void linnyPush(T n);
	public T linnyPeek();
	public T linnyPop();
	public boolean isEmpty();
	public int linnySize();

}
