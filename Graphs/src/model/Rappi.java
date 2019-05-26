package model;

import avl.*;
import bst.DennNode;
import trees.RedBlackBST;


public class Rappi {
	

	private RedBlackBST<Dealer> dealer;
	private DennAVLTree<String, Dealer> dealeravl;
	
	public Rappi() {
	
	}
	
	public void agregarUsuario(String id, String name, String password) {
		
//		dealer.insert(new Dealer(id, name, password));
		dealeravl.addNode(id, new Dealer(id, name, password));
		
	}
	
	public DennNode<String, Dealer> buscarUsuario(String id) {
		
		DennNode<String, Dealer> d = dealeravl.searchNode(id);
		return d;
		
	}
	
//	public DennAVLTree<Comparable, Commune> getCommunes() {
//		return communes;
//	}
//
//	public void setCommunes(DennAVLTree<Comparable, Commune> communes) {
//		this.communes = communes;
//	}
//
//	public DennAVLTree<String, Dealer> getDealer() {
//		return dealer;
//	}
//
//	public void setDealer(DennAVLTree<String, Dealer> dealer) {
//		this.dealer = dealer;
//	}
//
//	public void addCommune(String name, int sizeN) {
//		
//		Commune add = new Commune(name,sizeN); 
//		
//		communes.addNode(Integer.parseInt(name), add);
//		
//	}
//	
//	public void addDealer(String name, String id, String password) {
//		
//		Dealer add = new Dealer(id, name, password);
//		dealer.addNode(id, add);
//		
//	}
//	
//	public DennNode searchDealer(String id) {
//		
//		DennNode search =  dealer.searchNode(id);
//		
//		return search;
//	}
//	
	public static void main(String[] args) {
		Rappi r = new Rappi();
		
		r.agregarUsuario("camilo", "123", "123456");
		r.agregarUsuario("carolina", "143", "1234556");
		r.agregarUsuario("cris", "125", "12346");
		
		System.out.println(r.dealeravl.getRoot().getValue().getName());
		System.out.println(r.dealeravl.getRoot().getLeft().getValue().getName());
		
		System.out.println(r.buscarUsuario("123").getValue().getName());
		
	}
	

}
