package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import avl.*;
import bst.DennNode;
import graph.Graph;
import graph.GraphM;
import trees.RedBlackBST;

public class Rappi {

	private DennAVLTree<String, Dealer> dealeravl;
	private DennAVLTree<String, Commune> commune;
	private GraphM<Neighborhood> neighB;

	public Rappi() {

		dealeravl = new DennAVLTree<>();
		commune = new DennAVLTree<>();
		neighB = new GraphM<>(55);

	}

	public DennAVLTree<String, Dealer> getDealeravl() {
		return dealeravl;
	}

	public void setDealeravl(DennAVLTree<String, Dealer> dealeravl) {
		this.dealeravl = dealeravl;
	}

	public DennAVLTree<String, Commune> getCommune() {
		return commune;
	}

	public void setCommune(DennAVLTree<String, Commune> commune) {
		this.commune = commune;
	}

	public GraphM<Neighborhood> getNeighB() {
		return neighB;
	}

	public void setNeighB(GraphM<Neighborhood> neighB) {
		this.neighB = neighB;
	}

	// methods add Commune and Dealer
	public void addDealer(String id, String name, String password) {
		dealeravl.addNode(id, new Dealer(id, name, password));
		// System.out.println(dealeravl.getRoot().getValue().getName());

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

	// agregar barrios
	public void addNeighborhod() {

		// Barrios de la comuna 22
		Commune c22 = searchCommune("22");
		
		for (int i = 0; i < c22.getNeigh().length; i++) {	
			neighB.addNodeM(c22.getNeigh()[i]);	
		}
		
		// Barrios de la comuna 5
		Commune c5 = searchCommune("5");
		for (int i = 0; i < c5.getNeigh().length; i++) {
			neighB.addNodeM(c5.getNeigh()[i]);	
		}
		
		// Barrios de la comuna 4
		Commune c4 = searchCommune("4");
		for (int i = 0; i < c4.getNeigh().length; i++) {
			neighB.addNodeM(c4.getNeigh()[i]);	
		}
		
		// Barrios de la comuna 3
		Commune c3 = searchCommune("3");
		for (int i = 0; i < c3.getNeigh().length; i++) {
			neighB.addNodeM(c3.getNeigh()[i]);	
		}
		
		// Barrios de la comuna 17
		Commune c17 = searchCommune("17");
		for (int i = 0; i < c17.getNeigh().length; i++) {
			neighB.addNodeM(c17.getNeigh()[i]);	
		}
		
		// Barrios de la comuna 8
		Commune c8 = searchCommune("8");
		for (int i = 0; i < c8.getNeigh().length; i++) {
			neighB.addNodeM(c8.getNeigh()[i]);	
		}
		
		// Barrios de la comuna 2
		Commune c2 = searchCommune("2");
		for (int i = 0; i < c2.getNeigh().length; i++) {
			neighB.addNodeM(c2.getNeigh()[i]);	
		}
		
		// Barrios de la comuna 19
		Commune c19 = searchCommune("19");
		for (int i = 0; i < c19.getNeigh().length; i++) {
			neighB.addNodeM(c19.getNeigh()[i]);	
		}
		
		// Barrios de la comuna 7
		Commune c7 = searchCommune("7");
		for (int i = 0; i < c7.getNeigh().length; i++) {
			neighB.addNodeM(c7.getNeigh()[i]);	
		}
		
		// Barrios de la comuna 9
		Commune c9 = searchCommune("9");
		for (int i = 0; i < c9.getNeigh().length; i++) {
			neighB.addNodeM(c9.getNeigh()[i]);	
		}
		
		// Barrios de la comuna 10
		Commune c10 = searchCommune("10");
		for (int i = 0; i < c10.getNeigh().length; i++) {
			neighB.addNodeM(c10.getNeigh()[i]);	
		}
		
		// Barrios de la comuna 11
		Commune c11 = searchCommune("11");
		for (int i = 0; i < c11.getNeigh().length; i++) {
			neighB.addNodeM(c11.getNeigh()[i]);	
		}
	}
	
	
	//agregar aristas 
	public void addEdges() {
		
		//Comuna 22 ciudad jardin - finca 
		neighB.addEdge(searchCommune("22").search("Ciudad Jardín"), searchCommune("22").search("La finca"), 2.1);
		//Ciudad Jardin - club campestre
		neighB.addEdge(searchCommune("22").search("Ciudad Jardín"), searchCommune("22").search("Club Campestre"), 1.4);
		// finca - pance
		neighB.addEdge(searchCommune("22").search("La finca"), searchCommune("22").search("Pance"), 16.6);
		//club campestre - cañasgordas
		neighB.addEdge(searchCommune("22").search("Club Campestre"), searchCommune("22").search("Cañasgordas"), 3.7);
		//pance - cañasgordas 
		neighB.addEdge(searchCommune("22").search("Pance"), searchCommune("22").search("Cañasgordas"), 3.7);
		
		
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

	public String codeN(String code) {

		String r = " ";
		Commune n = null;
		Neighborhood s = null;

		if (code.length() == 3) {
			r = code.substring(0, 2);
			n = searchCommune(r);
			s = n.searchCode(code);
			r = s.getName();

		} else if (code.length() == 2) {
			r = "" + code.charAt(0);
			n = searchCommune(r);
			s = n.searchCode(code);
			r = s.getName();
		}

		return r;

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
					code = communeN + "" + j;
					//System.out.println(code);
					added.addNeighB(neighBorhood[j], code, 0, 0);
					searchCommune(added.getName()).setNeigh(added.getNeigh());
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
		
//		System.out.println(r.commune.getRoot().getValue().getNeigh()[1].getName());
//		System.out.println(r.commune.searchNode("22").getValue().getNeigh()[1].getName());
		
		r.addNeighborhod();
		System.out.println(r.neighB.getNodes().size());
		for (int i = 0; i < r.neighB.getNodes().size(); i++) {
			System.out.println(r.neighB.getNodes().get(i).getElem().getName());
		}
		
		System.out.println(r.codeN("32"));
		
//		System.out.println(r.searchDealer("145").getName());
//		System.out.println(r.searchDealer("146").getName());
//		System.out.println(r.dealeravl.getRoot().getRight().getValue().getName());

	}

}
