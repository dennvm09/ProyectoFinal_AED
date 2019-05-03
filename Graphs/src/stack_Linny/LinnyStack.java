package stack_Linny;

public class LinnyStack<T> implements ILinny<T> {

	private LinnyNodo<T> nodoFirst;
	private LinnyNodo<T> nodoLast;
	private int size;

	public LinnyStack() {
		size = 0;
	}

	@Override
	public void linnyPush(T n) {
		// TODO Auto-generated method stub
		LinnyNodo<T> newNodo = new LinnyNodo<T>(n);
		if (nodoFirst == null) {
			nodoFirst = newNodo;
			nodoLast = newNodo;
			newNodo.setNext(newNodo);
			newNodo.setPrevious(newNodo);
			size++;
		} else {
			
			nodoLast.setNext(newNodo);
			newNodo.setPrevious(nodoLast);
			newNodo.setNext(null);
			nodoLast = newNodo;
			size++;
			
		}
	}

	@Override
	public T linnyPeek() {
		// TODO Auto-generated method stub
		T object = null;
		if(nodoFirst.getNext() == null) {
			object = nodoFirst.getInfo();
		}
		else {
			object = nodoLast.getInfo();
		}
		
		return object;
	}

	@Override
	public T linnyPop() {
		// TODO Auto-generated method stub
		T object = null;
		if(nodoFirst.getNext() == null) {
			object = nodoFirst.getInfo();
			nodoFirst = null;
			size--;
		}
		else {
			object = nodoLast.getInfo();
			nodoLast.getPrevious().setNext(null);
			nodoLast = nodoLast.getPrevious();
			size--;
		}
		
		return object;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return nodoFirst == null;
	}

	@Override
	public int linnySize() {
		// TODO Auto-generated method stub
		return size;
	}

	public static void main(String[] args) {
		LinnyStack<Integer> n = new LinnyStack<>(); 
		
		n.linnyPush(9);
		n.linnyPush(10);
		n.linnyPush(23);
		System.out.println(n.linnySize());
		System.out.println(n.linnyPop());
		System.out.println(n.linnyPeek());
		System.out.println(n.linnyPop());
		System.out.println(n.linnyPop());
		System.out.println(n.isEmpty());
		
		
	}
	
}
