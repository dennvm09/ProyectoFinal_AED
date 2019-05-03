package model;
import java.util.LinkedList;


public class ListWeight<E> {

	private LinkedList<E> list;
	private double total;
	
	public ListWeight(LinkedList<E> list, double total) {
		this.list = list;
		this.total = total;
	}

	public LinkedList<E> getList() {
		return list;
	}

	public void setList(LinkedList<E> list) {
		this.list = list;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public String toString() {
		return String.valueOf(total);
	}
	
	
}
