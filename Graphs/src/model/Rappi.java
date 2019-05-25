package model;

import avl.*;
import bst.DennNode;
import trees.RedBlackBST;

public class Rappi {
	
	//private RedBlackBST<Commune> communes;
	private DennAVLTree<String, Dealer> dealer;
	
	public Rappi() {
	
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
//	public static void main(String[] args) {
//		Rappi r = new Rappi();
//		
//		r.addDealer("camilo", "123", "123456");
//		r.addDealer("carolina", "143", "1234556");
//		r.addDealer("cris", "125", "12346");
//		
//		System.out.println(r.dealer.getRoot().getValue().getName());
//		System.out.println(r.dealer.getRoot().getLeft().getValue().getName());
//		
//		System.out.println(r.searchDealer("123").getValue());
//		
//	}
//	
	

}
