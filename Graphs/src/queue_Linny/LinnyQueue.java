package queue_Linny;

public class LinnyQueue<T> implements IQueue {

	private LinnyNodo<T> firstNode;
	private LinnyNodo<T> lastNode;
	private int counter;

	public LinnyQueue() {
		counter = 0;

	}

	@Override
	public void linnyOffer(Object n) {
		// TODO Auto-generated method stub
		LinnyNodo newLinny = new LinnyNodo(n);
		if (firstNode == null) {
			firstNode = newLinny;
			lastNode = newLinny;
			newLinny.setNext(newLinny);
			newLinny.setPrevious(newLinny);
			
		} else {
		
			lastNode.setNext(newLinny);
			newLinny.setPrevious(null);
			lastNode = newLinny;		
			

		}
	}

	@Override
	public T linnyPeek() {
		// TODO Auto-generated method stub
		T inf = null;
		if (firstNode != null) {
			inf = firstNode.getInfo();
		}

		return inf;
	}

	@Override
	public Object linnyPoll() {
		// TODO Auto-generated method stub
		T pollInfo = null;
		if (firstNode != null) {
			pollInfo = firstNode.getInfo();
			firstNode = firstNode.getNext();
			counter--;
		}

		return pollInfo;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return firstNode == null;
	}

	@Override
	public int linnySize() {
		// TODO Auto-generated method stub
		return counter;
	}
	
	public static void main(String[] args) {
		LinnyQueue s = new LinnyQueue<>();
		
		s.linnyOffer(3);
		s.linnyOffer(8);
		s.linnyOffer(29);
		s.linnyOffer(34);
		s.linnyOffer(2);
		
		System.out.println(s.linnyPoll());
		System.out.println(s.linnyPeek());
		System.out.println(s.linnyPoll());
		System.out.println(s.linnyPoll());
		System.out.println(s.linnyPoll());
		
		System.out.println(s.isEmpty());
	}

}
