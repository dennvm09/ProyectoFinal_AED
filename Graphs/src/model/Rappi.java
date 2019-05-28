package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
		//System.out.println(dealeravl.getRoot().getValue().getName());

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

	public void txtCommuneNeighborhood() throws FileNotFoundException {

		File archive = null;
		FileReader fr = null;
		BufferedReader br = null;

		archive = new File("src/files/ZonasDeCobertura.txt");
		fr = new FileReader(archive);
		br = new BufferedReader(fr);

		try {
			int casos = Integer.parseInt(br.readLine());
			for (int i = 0; i < casos; i++) {

				String communeN = br.readLine();
				String neigh = br.readLine();
				String[] neighBorhood = neigh.split("	");
				
				int number = neighBorhood.length;
				Commune added = new Commune(communeN, number);
				addCommune(communeN, number);
				String code = "";

				for (int j = 0; j < neighBorhood.length; j++) {
					code = communeN+""+j;
					System.out.println(code);
					added.addNeighB(neighBorhood[j], code, 0, 0);
				}
			}

			br.close();
			fr.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		Rappi r = new Rappi();

		r.addDealer("145", "Camila", "1275684");
		r.addDealer("146", "Camilo", "127567");

		r.txtCommuneNeighborhood();
		
		System.out.println(r.commune.getRoot().getValue().getName());
		for (int i = 0; i < r.commune.getRoot().getValue().getNeigh().length; i++) {
			System.out.println(r.commune.getRoot().getLeft().getRight().getValue().getName());
		}
		
		
	

		System.out.println(r.searchDealer("145").getName());
		System.out.println(r.searchDealer("146").getName());
		System.out.println(r.dealeravl.getRoot().getRight().getValue().getName());
		


	}

}
