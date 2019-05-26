package model;

import avl.*;
import bst.DennNode;
import trees.RedBlackBST;

public class Rappi {

	private DennAVLTree<String, Dealer> dealeravl;
	private DennAVLTree<String, Commune> commune;

	public Rappi() {

		dealeravl = new DennAVLTree<>();
		commune = new DennAVLTree<>();

	}

	// methods add Commune and Dealer
	public void addDealer(String id, String name, String password) {
		dealeravl.addNode(id, new Dealer(id, name, password));
		System.out.println(dealeravl.getRoot().getValue().getName());

	}

	public void addCommune(String name, int size) {
		commune.addNode(name, new Commune(name, size));

	}

	// Methods of search Dealer and Commune
	public Dealer searchDealer(String id) {

		Dealer search = dealeravl.searchNode(id).getValue();
		return search;
	}

	public Commune searchCommune(String name) {

		Commune search = commune.searchNode(name).getValue();
		return search;
	}

	// Methods set Dealer
	public void setIdDealer(String id, String idNew) {

		Dealer search = dealeravl.searchNode(id).getValue();
		search.setId(idNew);

	}

	public void setPassword(String id, String password) {

		Dealer search = dealeravl.searchNode(id).getValue();
		search.setPassword(password);

	}

	public void setNameDealer(String id, String name) {

		Dealer search = dealeravl.searchNode(id).getValue();
		search.setName(name);

	}

	// Methods confirm user
	public boolean signIn(String id, String password) {

		Dealer signId = searchDealer(id);

		if (signId == null) {
			return false;
		} else {

			if (signId.isPassword(password) == true) {
				return true;
			} else {
				return false;
			}
		}

	}

	public static void main(String[] args) {
		Rappi r = new Rappi();

		r.addDealer("145", "Camila", "1275684");
		r.addDealer("146", "Camilo", "127567");
		r.addDealer("155", "Crolin", "1275654");
		r.addDealer("165", "Lina", "1276654");
		r.addDealer("144", "yrna", "127654");

		System.out.println(r.searchDealer("145").getId());
		System.out.println(r.searchDealer("146").getId());
		System.out.println(r.searchDealer("155").getId());
		System.out.println(r.searchDealer("165").getId());
		System.out.println(r.signIn("165", "1276654"));

	}

}
