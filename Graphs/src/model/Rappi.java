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
import graph.ListWeight;
import trees.RedBlackBST;

public class Rappi {

	private DennAVLTree<String, Dealer> dealeravl;
	private DennAVLTree<String, Commune> commune;
	private GraphM<Neighborhood> neighB;
	private Graph<Neighborhood> neighGrafo;

	public Rappi() {

		dealeravl = new DennAVLTree<>();
		commune = new DennAVLTree<>();
		neighB = new GraphM<>(54);
		neighGrafo = new Graph<>(54);

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

	public Graph<Neighborhood> getNeighGrafo() {
		return neighGrafo;
	}

	public void setNeighGrafo(Graph<Neighborhood> neighGrafo) {
		this.neighGrafo = neighGrafo;
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
//	public void addNeighborhodM() {
//
//		// Barrios de la comuna 22
//		Commune c22 = searchCommune("22");
//
//		for (int i = 0; i < c22.getNeigh().length; i++) {
//			neighB.addNodeM(c22.getNeigh()[i]);
//		}
//
//		// Barrios de la comuna 5
//		Commune c5 = searchCommune("5");
//		for (int i = 0; i < c5.getNeigh().length; i++) {
//			neighB.addNodeM(c5.getNeigh()[i]);
//		}
//
//		// Barrios de la comuna 4
//		Commune c4 = searchCommune("4");
//		for (int i = 0; i < c4.getNeigh().length; i++) {
//			neighB.addNodeM(c4.getNeigh()[i]);
//		}
//
//		// Barrios de la comuna 3
//		Commune c3 = searchCommune("3");
//		for (int i = 0; i < c3.getNeigh().length; i++) {
//			neighB.addNodeM(c3.getNeigh()[i]);
//		}
//
//		// Barrios de la comuna 17
//		Commune c17 = searchCommune("17");
//		for (int i = 0; i < c17.getNeigh().length; i++) {
//			neighB.addNodeM(c17.getNeigh()[i]);
//		}
//
//		// Barrios de la comuna 8
//		Commune c8 = searchCommune("8");
//		for (int i = 0; i < c8.getNeigh().length; i++) {
//			neighB.addNodeM(c8.getNeigh()[i]);
//		}
//
//		// Barrios de la comuna 2
//		Commune c2 = searchCommune("2");
//		for (int i = 0; i < c2.getNeigh().length; i++) {
//			neighB.addNodeM(c2.getNeigh()[i]);
//		}
//
//		// Barrios de la comuna 19
//		Commune c19 = searchCommune("19");
//		for (int i = 0; i < c19.getNeigh().length; i++) {
//			neighB.addNodeM(c19.getNeigh()[i]);
//		}
//
//		// Barrios de la comuna 7
//		Commune c7 = searchCommune("7");
//		for (int i = 0; i < c7.getNeigh().length; i++) {
//			neighB.addNodeM(c7.getNeigh()[i]);
//		}
//
//		// Barrios de la comuna 9
//		Commune c9 = searchCommune("9");
//		for (int i = 0; i < c9.getNeigh().length; i++) {
//			neighB.addNodeM(c9.getNeigh()[i]);
//		}
//
//		// Barrios de la comuna 10
//		Commune c10 = searchCommune("10");
//		for (int i = 0; i < c10.getNeigh().length; i++) {
//			neighB.addNodeM(c10.getNeigh()[i]);
//		}
//
//		// Barrios de la comuna 11
//		Commune c11 = searchCommune("11");
//		for (int i = 0; i < c11.getNeigh().length; i++) {
//			neighB.addNodeM(c11.getNeigh()[i]);
//		}
//	}

	public void addNeighborhod() throws Exception {

		// Barrios de la comuna 22
		Commune c22 = searchCommune("22");

		// System.out.println(c22.getNeigh().length);
		for (int i = 0; i < c22.getNeigh().length; i++) {
			neighGrafo.addNode(c22.getNeigh()[i]);
			System.out.println(c22.getNeigh()[i].getName());

		}

		// Barrios de la comuna 5
		Commune c5 = searchCommune("5");
		for (int i = 0; i < c5.getNeigh().length; i++) {
			neighGrafo.addNode(c5.getNeigh()[i]);
		}

		// Barrios de la comuna 4
		Commune c4 = searchCommune("4");
		for (int i = 0; i < c4.getNeigh().length; i++) {
			neighGrafo.addNode(c4.getNeigh()[i]);
		}

		// Barrios de la comuna 3
		Commune c3 = searchCommune("3");
		for (int i = 0; i < c3.getNeigh().length; i++) {
			neighGrafo.addNode(c3.getNeigh()[i]);
		}

		// Barrios de la comuna 17
		Commune c17 = searchCommune("17");
		for (int i = 0; i < c17.getNeigh().length; i++) {
			neighGrafo.addNode(c17.getNeigh()[i]);
		}

		// Barrios de la comuna 8
		Commune c8 = searchCommune("8");
		for (int i = 0; i < c8.getNeigh().length; i++) {
			neighGrafo.addNode(c8.getNeigh()[i]);
		}

		// Barrios de la comuna 2
		Commune c2 = searchCommune("2");
		for (int i = 0; i < c2.getNeigh().length; i++) {
			neighGrafo.addNode(c2.getNeigh()[i]);
		}

		// Barrios de la comuna 19
		Commune c19 = searchCommune("19");
		for (int i = 0; i < c19.getNeigh().length; i++) {
			neighGrafo.addNode(c19.getNeigh()[i]);
		}

		// Barrios de la comuna 7
		Commune c7 = searchCommune("7");
		for (int i = 0; i < c7.getNeigh().length; i++) {
			neighGrafo.addNode(c7.getNeigh()[i]);
		}

		// Barrios de la comuna 9
		Commune c9 = searchCommune("9");
		for (int i = 0; i < c9.getNeigh().length; i++) {
			neighGrafo.addNode(c9.getNeigh()[i]);
		}

		// Barrios de la comuna 10
		Commune c10 = searchCommune("10");
		for (int i = 0; i < c10.getNeigh().length; i++) {
			neighGrafo.addNode(c10.getNeigh()[i]);
		}

		// Barrios de la comuna 11
		Commune c11 = searchCommune("11");
		for (int i = 0; i < c11.getNeigh().length; i++) {
			neighGrafo.addNode(c11.getNeigh()[i]);
		}
	}

	// agregar aristas
//	public void addEdgesM() {
//
//		// Comuna 22 ciudad jardin - finca
//		neighB.addEdge(searchCommune("22").search("Ciudad Jard�n"), searchCommune("22").search("La finca"), 2.1);
//		// Ciudad Jardin - club campestre
//		neighB.addEdge(searchCommune("22").search("Ciudad Jard�n"), searchCommune("22").search("Club Campestre"), 1.4);
//		// finca - pance
//		neighB.addEdge(searchCommune("22").search("La finca"), searchCommune("22").search("Pance"), 16.6);
//		// club campestre - ca�asgordas
//		neighB.addEdge(searchCommune("22").search("Club Campestre"), searchCommune("22").search("Ca�asgordas"), 3.7);
//		// pance - ca�asgordas
//		neighB.addEdge(searchCommune("22").search("Pance"), searchCommune("22").search("Ca�asgordas"), 16.2);
//
//		// Comuna 5 
//		neighB.addEdge(searchCommune("5").search("Salomia"), searchCommune("5").search("El Sena"), 1.4);
//		
//		neighB.addEdge(searchCommune("5").search("El Sena"), searchCommune("5").search("Los Andes"), 1.5);
//		
//		neighB.addEdge(searchCommune("5").search("Los Andes"), searchCommune("5").search("Chiminangos"), 1.4);
//		
//		neighB.addEdge(searchCommune("5").search("Los Andes"), searchCommune("5").search("Brisas del Guabito"), 2.5);
//		
//		neighB.addEdge(searchCommune("5").search("Salomia"), searchCommune("5").search("Brisas del Guabito"), 2.5);
//
//		neighB.addEdge(searchCommune("4").search("Calima"), searchCommune("5").search("Chiminangos"), 2.5);
//
//		// comuna 4
//		neighB.addEdge(searchCommune("4").search("Calima"), searchCommune("4").search("Flora Industrial"), 2.5);
//
//		neighB.addEdge(searchCommune("4").search("Manzanares"), searchCommune("4").search("Las Delicias"), 1);
//
//		neighB.addEdge(searchCommune("4").search("Manzanares"), searchCommune("4").search("Flora Industrial"), 1);
//
//		neighB.addEdge(searchCommune("3").search("La Merced"), searchCommune("4").search("Flora Industrial"), 1.5);
//
//		neighB.addEdge(searchCommune("3").search("La Merced"), searchCommune("4").search("Calima"), 2.3);
//
//		// Comuna 3
//		neighB.addEdge(searchCommune("3").search("El Pe��n"), searchCommune("3").search("El Nacional"), 2.2);
//
//		neighB.addEdge(searchCommune("3").search("El Pe��n"), searchCommune("3").search("San Nicol�s"), 2.2);
//
//		neighB.addEdge(searchCommune("3").search("La Merced"), searchCommune("3").search("El Nacional"), 2.1);
//
//		neighB.addEdge(searchCommune("3").search("La Merced"), searchCommune("3").search("San Nicol�s"), 3.1);
//		
//		
//		neighB.addEdge(searchCommune("3").search("El Pe��n"), searchCommune("2").search("Normand�a"), 1.5);
//		
//		neighB.addEdge(searchCommune("2").search("Centenario"), searchCommune("2").search("Normand�a"), 1);
//		
//		neighB.addEdge(searchCommune("2").search("Centenario"), searchCommune("3").search("San Nicol�s"), 3.2);
//		
//		
//		//Comuna 17
//		
//		neighB.addEdge(searchCommune("17").search("Lil�"), searchCommune("22").search("Club Campestre"), 3);
//		
//		neighB.addEdge(searchCommune("17").search("Lil�"), searchCommune("17").search("El Ingenio"), 2.5);
//		
//		neighB.addEdge(searchCommune("17").search("Caney"), searchCommune("17").search("El Ingenio"), 2.2);
//		
//		neighB.addEdge(searchCommune("17").search("Capri"), searchCommune("17").search("El Ingenio"), 2.4);
//		
//		neighB.addEdge(searchCommune("17").search("Capri"), searchCommune("17").search("El Limonar"), 2.5);
//		
//		neighB.addEdge(searchCommune("17").search("La Hacienda"), searchCommune("17").search("El Limonar"), 1.2);
//		
//		neighB.addEdge(searchCommune("17").search("La Hacienda"), searchCommune("17").search("El Ingenio"), 1.7);
//		
//		//comuna 8
//		
//		neighB.addEdge(searchCommune("8").search("Atanasio Girardot"), searchCommune("8").search("Chapinero"), 1);
//		
//		neighB.addEdge(searchCommune("8").search("Atanasio Girardot"), searchCommune("8").search("Las �mericas"), 1.2);
//		
//		neighB.addEdge(searchCommune("8").search("El Troncal"), searchCommune("8").search("Las �mericas"), 1);
//		
//		neighB.addEdge(searchCommune("8").search("La Base"), searchCommune("8").search("Las �mericas"), 1.5);
//		
//		
//		//comuna 2
//		
//		neighB.addEdge(searchCommune("2").search("Menga"), searchCommune("2").search("Arroyohondo"), 2.3);
//		
//		neighB.addEdge(searchCommune("2").search("Menga"), searchCommune("2").search("Vipasa"), 3.1);
//		
//		neighB.addEdge(searchCommune("2").search("Ciudad los �lamos"), searchCommune("2").search("Vipasa"), 1.8);
//		
//		neighB.addEdge(searchCommune("2").search("Ciudad los �lamos"), searchCommune("4").search("Calima"), 1.4);
//		
//		neighB.addEdge(searchCommune("2").search("Ciudad los �lamos"), searchCommune("4").search("Flora Industrial"), 2.1);
//		
//		
//		//Comuna 19
//		neighB.addEdge(searchCommune("19").search("Pampalinda"), searchCommune("17").search("El Limonar"), 2.9);
//		
//		neighB.addEdge(searchCommune("19").search("Pampalinda"), searchCommune("19").search("Cuarto de Legua"), 1);
//		
//		neighB.addEdge(searchCommune("19").search("El Lido"), searchCommune("19").search("Cuarto de Legua"), 1.9);
//		
//		neighB.addEdge(searchCommune("19").search("El Lido"), searchCommune("19").search("Tequendama"), 1.1);
//		
//		
//		//Comuna 7
//		neighB.addEdge(searchCommune("7").search("Los Pinos"), searchCommune("7").search("Las Ceibas"), 1);
//		
//		neighB.addEdge(searchCommune("7").search("San Marino"), searchCommune("7").search("Las Ceibas"), 4);
//		
//		neighB.addEdge(searchCommune("7").search("San Marino"), searchCommune("7").search("Los Pinos"), 3.5);
//		
//		neighB.addEdge(searchCommune("8").search("La Base"), searchCommune("7").search("Los Pinos"), 1.4);
//		
//		
//		neighB.addEdge(searchCommune("7").search("San Marino"), searchCommune("5").search("Los Andes"), 4.7);
//		
//		
//		//Comuna 9
//		
//		neighB.addEdge(searchCommune("9").search("Guayaquil"), searchCommune("9").search("Breta�a"), 1.1);
//		
//		neighB.addEdge(searchCommune("9").search("Guayaquil"), searchCommune("9").search("Bel�lcazar"), 1.3);
//		
//		neighB.addEdge(searchCommune("3").search("San Nicol�s"), searchCommune("9").search("Breta�a"), 3.2);
//		
//		neighB.addEdge(searchCommune("9").search("Guayaquil"), searchCommune("9").search("Aranjuez"), 1);
//		
//		neighB.addEdge(searchCommune("9").search("Bel�lcazar"), searchCommune("9").search("Aranjuez"), 1.3);
//		
//		
//		//comuna 10
//		neighB.addEdge(searchCommune("10").search("Departamental"), searchCommune("19").search("Tequendama"), 2.1);
//		
//		neighB.addEdge(searchCommune("10").search("Departamental"), searchCommune("10").search("El Guabal"), 1.4);
//		
//		neighB.addEdge(searchCommune("10").search("El Dorado"), searchCommune("10").search("El Guabal"), 1.5);
//		
//		neighB.addEdge(searchCommune("10").search("El Dorado"), searchCommune("10").search("Santa Elena"), 1.5);
//		
//		
//		neighB.addEdge(searchCommune("11").search("La Independecia"), searchCommune("10").search("El Guabal"), 1.7);
//		
//		neighB.addEdge(searchCommune("9").search("Guayaquil"), searchCommune("10").search("Santa Elena"), 2.4);
//		
//		neighB.addEdge(searchCommune("11").search("San Carlos"), searchCommune("10").search("Santa Elena"), 2.3);
//		
//		
//		//Comuna 11
//		neighB.addEdge(searchCommune("11").search("La Independecia"), searchCommune("11").search("La Esperanza"), 1);
//		
//		neighB.addEdge(searchCommune("11").search("La Independecia"), searchCommune("11").search("Ciudad Modelo"), 1);
//		
//		neighB.addEdge(searchCommune("11").search("La Esperanza"), searchCommune("11").search("Ciudad Modelo"), 1);
//		
//
//	}

	public void addEdges() throws Exception {

		// Comuna 22 ciudad jardin - finca
		neighGrafo.addEdge(searchCommune("22").search("Ciudad Jard�n"), searchCommune("22").search("La finca"), 2.1);
		neighGrafo.addEdge(searchCommune("22").search("La finca"), searchCommune("22").search("Ciudad Jard�n"), 2.1);
		// Ciudad Jardin - club campestre
		neighGrafo.addEdge(searchCommune("22").search("Ciudad Jard�n"), searchCommune("22").search("Club Campestre"),
				1.4);
		neighGrafo.addEdge(searchCommune("22").search("Club Campestre"), searchCommune("22").search("Ciudad Jard�n"),
				1.4);

		// finca - pance
		neighGrafo.addEdge(searchCommune("22").search("La finca"), searchCommune("22").search("Pance"), 16.6);
		neighGrafo.addEdge(searchCommune("22").search("Pance"), searchCommune("22").search("La finca"), 16.6);

		// club campestre - ca�asgordas
		neighGrafo.addEdge(searchCommune("22").search("Club Campestre"), searchCommune("22").search("Ca�asgordas"),
				3.7);
		neighGrafo.addEdge(searchCommune("22").search("Ca�asgordas"), searchCommune("22").search("Club Campestre"),
				3.7);

		// pance - ca�asgordas
		neighGrafo.addEdge(searchCommune("22").search("Pance"), searchCommune("22").search("Ca�asgordas"), 16.2);
		neighGrafo.addEdge(searchCommune("22").search("Ca�asgordas"), searchCommune("22").search("Pance"), 16.2);

		// Comuna 5
		neighGrafo.addEdge(searchCommune("5").search("Salomia"), searchCommune("5").search("El Sena"), 1.4);
		neighGrafo.addEdge(searchCommune("5").search("El Sena"), searchCommune("5").search("Salomia"), 1.4);

		neighGrafo.addEdge(searchCommune("5").search("El Sena"), searchCommune("5").search("Los Andes"), 1.5);
		neighGrafo.addEdge(searchCommune("5").search("Los Andes"), searchCommune("5").search("El Sena"), 1.5);

		neighGrafo.addEdge(searchCommune("5").search("Los Andes"), searchCommune("5").search("Chiminangos"), 1.4);
		neighGrafo.addEdge(searchCommune("5").search("Chiminangos"), searchCommune("5").search("Los Andes"), 1.4);

		neighGrafo.addEdge(searchCommune("5").search("Los Andes"), searchCommune("5").search("Brisas del Guabito"),
				2.5);
		neighGrafo.addEdge(searchCommune("5").search("Brisas del Guabito"), searchCommune("5").search("Los Andes"),
				2.5);

		neighGrafo.addEdge(searchCommune("5").search("Salomia"), searchCommune("5").search("Brisas del Guabito"), 2.5);
		neighGrafo.addEdge(searchCommune("5").search("Brisas del Guabito"), searchCommune("5").search("Salomia"), 2.5);

		neighGrafo.addEdge(searchCommune("4").search("Calima"), searchCommune("5").search("Chiminangos"), 2.5);
		neighGrafo.addEdge(searchCommune("5").search("Chiminangos"), searchCommune("4").search("Calima"), 2.5);

		// comuna 4
		neighGrafo.addEdge(searchCommune("4").search("Calima"), searchCommune("4").search("Flora Industrial"), 2.5);
		neighGrafo.addEdge(searchCommune("4").search("Flora Industrial"), searchCommune("4").search("Calima"), 2.5);

		neighGrafo.addEdge(searchCommune("4").search("Manzanares"), searchCommune("4").search("Las Delicias"), 1);
		neighGrafo.addEdge(searchCommune("4").search("Las Delicias"), searchCommune("4").search("Manzanares"), 1);

		neighGrafo.addEdge(searchCommune("4").search("Manzanares"), searchCommune("4").search("Flora Industrial"), 1);
		neighGrafo.addEdge(searchCommune("4").search("Flora Industrial"), searchCommune("4").search("Manzanares"), 1);

		neighGrafo.addEdge(searchCommune("3").search("La Merced"), searchCommune("4").search("Flora Industrial"), 1.5);
		neighGrafo.addEdge(searchCommune("4").search("Flora Industrial"), searchCommune("3").search("La Merced"), 1.5);

		neighGrafo.addEdge(searchCommune("3").search("La Merced"), searchCommune("4").search("Calima"), 2.3);
		neighGrafo.addEdge(searchCommune("4").search("Calima"), searchCommune("3").search("La Merced"), 2.3);

		// Comuna 3
		neighGrafo.addEdge(searchCommune("3").search("El Pe��n"), searchCommune("3").search("El Nacional"), 2.2);
		neighGrafo.addEdge(searchCommune("3").search("El Nacional"), searchCommune("3").search("El Pe��n"), 2.2);

		neighGrafo.addEdge(searchCommune("3").search("El Pe��n"), searchCommune("3").search("San Nicol�s"), 2.2);
		neighGrafo.addEdge(searchCommune("3").search("San Nicol�s"), searchCommune("3").search("El Pe��n"), 2.2);

		neighGrafo.addEdge(searchCommune("3").search("La Merced"), searchCommune("3").search("El Nacional"), 2.1);
		neighGrafo.addEdge(searchCommune("3").search("El Nacional"), searchCommune("3").search("La Merced"), 2.1);

		neighGrafo.addEdge(searchCommune("3").search("La Merced"), searchCommune("3").search("San Nicol�s"), 3.1);
		neighGrafo.addEdge(searchCommune("3").search("San Nicol�s"), searchCommune("3").search("La Merced"), 3.1);

		neighGrafo.addEdge(searchCommune("3").search("El Pe��n"), searchCommune("2").search("Normand�a"), 1.5);
		neighGrafo.addEdge(searchCommune("2").search("Normand�a"), searchCommune("3").search("El Pe��n"), 1.5);

		neighGrafo.addEdge(searchCommune("2").search("Centenario"), searchCommune("3").search("San Nicol�s"), 3.2);
		neighGrafo.addEdge(searchCommune("3").search("San Nicol�s"), searchCommune("2").search("Centenario"), 3.2);

		// Comuna 17

		neighGrafo.addEdge(searchCommune("17").search("Lil�"), searchCommune("22").search("Club Campestre"), 3);
		neighGrafo.addEdge(searchCommune("22").search("Club Campestre"), searchCommune("17").search("Lil�"), 3);

		neighGrafo.addEdge(searchCommune("17").search("Lil�"), searchCommune("17").search("El Ingenio"), 2.5);
		neighGrafo.addEdge(searchCommune("17").search("El Ingenio"), searchCommune("17").search("Lil�"), 2.5);

		neighGrafo.addEdge(searchCommune("17").search("Caney"), searchCommune("17").search("El Ingenio"), 2.2);
		neighGrafo.addEdge(searchCommune("17").search("El Ingenio"), searchCommune("17").search("Caney"), 2.2);

		neighGrafo.addEdge(searchCommune("17").search("Capri"), searchCommune("17").search("El Ingenio"), 2.4);
		neighGrafo.addEdge(searchCommune("17").search("El Ingenio"), searchCommune("17").search("Capri"), 2.4);

		neighGrafo.addEdge(searchCommune("17").search("Capri"), searchCommune("17").search("El Limonar"), 2.5);
		neighGrafo.addEdge(searchCommune("17").search("El Limonar"), searchCommune("17").search("Capri"), 2.5);

		neighGrafo.addEdge(searchCommune("17").search("La Hacienda"), searchCommune("17").search("El Limonar"), 1.2);
		neighGrafo.addEdge(searchCommune("17").search("El Limonar"), searchCommune("17").search("La Hacienda"), 1.2);

		neighGrafo.addEdge(searchCommune("17").search("La Hacienda"), searchCommune("17").search("El Ingenio"), 1.7);
		neighGrafo.addEdge(searchCommune("17").search("El Ingenio"), searchCommune("17").search("La Hacienda"), 1.7);

		// comuna 8

		neighGrafo.addEdge(searchCommune("8").search("Atanasio Girardot"), searchCommune("8").search("Chapinero"), 1);
		neighGrafo.addEdge(searchCommune("8").search("Chapinero"), searchCommune("8").search("Atanasio Girardot"), 1);

		neighGrafo.addEdge(searchCommune("8").search("Atanasio Girardot"), searchCommune("8").search("Las �mericas"),
				1.2);
		neighGrafo.addEdge(searchCommune("8").search("Las �mericas"), searchCommune("8").search("Atanasio Girardot"),
				1.2);

		neighGrafo.addEdge(searchCommune("8").search("El Troncal"), searchCommune("8").search("Las �mericas"), 1);
		neighGrafo.addEdge(searchCommune("8").search("Las �mericas"), searchCommune("8").search("El Troncal"), 1);

		neighGrafo.addEdge(searchCommune("8").search("La Base"), searchCommune("8").search("Las �mericas"), 1.5);
		neighGrafo.addEdge(searchCommune("8").search("Las �mericas"), searchCommune("8").search("La Base"), 1.5);

		// comuna 2

		neighGrafo.addEdge(searchCommune("2").search("Menga"), searchCommune("2").search("Arroyohondo"), 2.3);
		neighGrafo.addEdge(searchCommune("2").search("Arroyohondo"), searchCommune("2").search("Menga"), 2.3);

		neighGrafo.addEdge(searchCommune("2").search("Menga"), searchCommune("2").search("Vipasa"), 3.1);
		neighGrafo.addEdge(searchCommune("2").search("Vipasa"), searchCommune("2").search("Menga"), 3.1);

		neighGrafo.addEdge(searchCommune("2").search("Centenario"), searchCommune("2").search("Normand�a"), 1);
		neighGrafo.addEdge(searchCommune("2").search("Normand�a"), searchCommune("2").search("Centenario"), 1);

		neighGrafo.addEdge(searchCommune("2").search("Ciudad los �lamos"), searchCommune("2").search("Vipasa"), 1.8);
		neighGrafo.addEdge(searchCommune("2").search("Vipasa"), searchCommune("2").search("Ciudad los �lamos"), 1.8);

		neighGrafo.addEdge(searchCommune("2").search("Ciudad los �lamos"), searchCommune("4").search("Calima"), 1.4);
		neighGrafo.addEdge(searchCommune("4").search("Calima"), searchCommune("2").search("Ciudad los �lamos"), 1.4);

		neighGrafo.addEdge(searchCommune("2").search("Ciudad los �lamos"),
				searchCommune("4").search("Flora Industrial"), 2.1);
		neighGrafo.addEdge(searchCommune("4").search("Flora Industrial"),
				searchCommune("2").search("Ciudad los �lamos"), 2.1);

		// Comuna 19
		neighGrafo.addEdge(searchCommune("19").search("Pampalinda"), searchCommune("17").search("El Limonar"), 2.9);
		neighGrafo.addEdge(searchCommune("17").search("El Limonar"), searchCommune("19").search("Pampalinda"), 2.9);

		neighGrafo.addEdge(searchCommune("19").search("Pampalinda"), searchCommune("19").search("Cuarto de Legua"), 1);
		neighGrafo.addEdge(searchCommune("19").search("Cuarto de Legua"), searchCommune("19").search("Pampalinda"), 1);

		neighGrafo.addEdge(searchCommune("19").search("El Lido"), searchCommune("19").search("Cuarto de Legua"), 1.9);
		neighGrafo.addEdge(searchCommune("19").search("Cuarto de Legua"), searchCommune("19").search("El Lido"), 1.9);

		neighGrafo.addEdge(searchCommune("19").search("El Lido"), searchCommune("19").search("Tequendama"), 1.1);
		neighGrafo.addEdge(searchCommune("19").search("Tequendama"), searchCommune("19").search("El Lido"), 1.1);

		// Comuna 7
		neighGrafo.addEdge(searchCommune("7").search("Los Pinos"), searchCommune("7").search("Las Ceibas"), 1);
		neighGrafo.addEdge(searchCommune("7").search("Las Ceibas"), searchCommune("7").search("Los Pinos"), 1);

		neighGrafo.addEdge(searchCommune("7").search("San Marino"), searchCommune("7").search("Las Ceibas"), 4);
		neighGrafo.addEdge(searchCommune("7").search("Las Ceibas"), searchCommune("7").search("San Marino"), 4);

		neighGrafo.addEdge(searchCommune("7").search("San Marino"), searchCommune("7").search("Los Pinos"), 3.5);
		neighGrafo.addEdge(searchCommune("7").search("San Marino"), searchCommune("7").search("San Marino"), 3.5);

		neighGrafo.addEdge(searchCommune("8").search("La Base"), searchCommune("7").search("Los Pinos"), 1.4);
		neighGrafo.addEdge(searchCommune("7").search("Los Pinos"), searchCommune("8").search("La Base"), 1.4);

		neighGrafo.addEdge(searchCommune("7").search("San Marino"), searchCommune("5").search("Los Andes"), 4.7);
		neighGrafo.addEdge(searchCommune("5").search("Los Andes"), searchCommune("7").search("San Marino"), 4.7);

		// Comuna 9

		neighGrafo.addEdge(searchCommune("9").search("Guayaquil"), searchCommune("9").search("Breta�a"), 1.1);
		neighGrafo.addEdge(searchCommune("9").search("Breta�a"), searchCommune("9").search("Guayaquil"), 1.1);

		neighGrafo.addEdge(searchCommune("9").search("Guayaquil"), searchCommune("9").search("Bel�lcazar"), 1.3);
		neighGrafo.addEdge(searchCommune("9").search("Bel�lcazar"), searchCommune("9").search("Guayaquil"), 1.3);

		neighGrafo.addEdge(searchCommune("3").search("San Nicol�s"), searchCommune("9").search("Breta�a"), 3.2);
		neighGrafo.addEdge(searchCommune("9").search("Breta�a"), searchCommune("3").search("San Nicol�s"), 3.2);

		neighGrafo.addEdge(searchCommune("9").search("Guayaquil"), searchCommune("9").search("Aranjuez"), 1);
		neighGrafo.addEdge(searchCommune("9").search("Aranjuez"), searchCommune("9").search("Guayaquil"), 1);

		neighGrafo.addEdge(searchCommune("9").search("Bel�lcazar"), searchCommune("9").search("Aranjuez"), 1.3);
		neighGrafo.addEdge(searchCommune("9").search("Aranjuez"), searchCommune("9").search("Bel�lcazar"), 1.3);

		// comuna 10
		neighGrafo.addEdge(searchCommune("10").search("Departamental"), searchCommune("19").search("Tequendama"), 2.1);
		neighGrafo.addEdge(searchCommune("19").search("Tequendama"), searchCommune("10").search("Departamental"), 2.1);

		neighGrafo.addEdge(searchCommune("10").search("Departamental"), searchCommune("10").search("El Guabal"), 1.4);
		neighGrafo.addEdge(searchCommune("10").search("El Guabal"), searchCommune("10").search("Departamental"), 1.4);

		neighGrafo.addEdge(searchCommune("10").search("El Dorado"), searchCommune("10").search("El Guabal"), 1.5);
		neighGrafo.addEdge(searchCommune("10").search("El Guabal"), searchCommune("10").search("El Dorado"), 1.5);

		neighGrafo.addEdge(searchCommune("10").search("El Dorado"), searchCommune("10").search("Santa Elena"), 1.5);
		neighGrafo.addEdge(searchCommune("10").search("Santa Elena"), searchCommune("10").search("El Dorado"), 1.5);

		neighGrafo.addEdge(searchCommune("11").search("La Independecia"), searchCommune("10").search("El Guabal"), 1.7);
		neighGrafo.addEdge(searchCommune("10").search("El Guabal"), searchCommune("11").search("La Independecia"), 1.7);

		neighGrafo.addEdge(searchCommune("9").search("Guayaquil"), searchCommune("10").search("Santa Elena"), 2.4);
		neighGrafo.addEdge(searchCommune("10").search("Santa Elena"), searchCommune("9").search("Guayaquil"), 2.4);

		neighGrafo.addEdge(searchCommune("11").search("San Carlos"), searchCommune("10").search("Santa Elena"), 2.3);
		neighGrafo.addEdge(searchCommune("10").search("Santa Elena"), searchCommune("11").search("San Carlos"), 2.3);

		// Comuna 11
		neighGrafo.addEdge(searchCommune("11").search("La Independecia"), searchCommune("11").search("La Esperanza"),
				1);
		neighGrafo.addEdge(searchCommune("11").search("La Esperanza"), searchCommune("11").search("La Independecia"),
				1);

		neighGrafo.addEdge(searchCommune("11").search("La Independecia"), searchCommune("11").search("Ciudad Modelo"),
				1);
		neighGrafo.addEdge(searchCommune("11").search("Ciudad Modelo"), searchCommune("11").search("La Independecia"),
				1);

		neighGrafo.addEdge(searchCommune("11").search("La Esperanza"), searchCommune("11").search("Ciudad Modelo"), 1);
		neighGrafo.addEdge(searchCommune("11").search("Ciudad Modelo"), searchCommune("11").search("La Esperanza"), 1);

	}

	/**
	 * @return the shortests travel into two nodes
	 * 
	 */
	public String[] shortestTravel(String communeI, String neighBorhoodI, String communeFinal, String NeighBorhoodFinal)
			throws Exception {

		Commune Cinicial = searchCommune(communeI);
		Commune Cfinal = searchCommune(communeFinal);

		Neighborhood NInicial = Cinicial.search(neighBorhoodI);
		Neighborhood NFinal = Cfinal.search(NeighBorhoodFinal);
		ListWeight<Neighborhood> dijkstra = neighGrafo.Dijkstra(NInicial, NFinal);
		String[] dijsk = new String[dijkstra.getList().size()];

		for (int i = 0; i < dijkstra.getList().size(); i++) {
			dijsk[i] = dijkstra.getList().get(i).getName();
		}

		return dijsk;
	}

	
	//Metodo de varios recorridos 
	public String[] severalDeliveries(String communeI, String neighborhoodI, String c1, String neigh1, String c2,
			String neigh2, String c3, String neigh3) throws Exception {

		String[] arr1 = null;
		String[] arr2 = null;
		String[] arr3 = null;

		if (c1 != null && neigh1 != null) {
			arr1 = shortestTravel(communeI, neighborhoodI, c1, neigh1);
			if (c2 != null && neigh2 != null) {
				arr2 = shortestTravel(c1, neigh1, c2, neigh2);
				
				if (c3 != null && neigh3 != null) {
					arr3 = shortestTravel(c2, neigh2, c3, neigh3);
				}
			}
		}
		int lenghA = 0;
		if(arr1 != null) {
			lenghA += arr1.length;
		}
		if(arr2 != null) {
			lenghA += arr2.length - 1;
		}
		if(arr3 != null) {
			lenghA += arr3.length - 1;
		}
		
		String[] finalA = new String[lenghA];

		int g = 0;

		if (arr1 != null) {
			System.out.println(arr1.length);
			for (int j = 0; j < arr1.length; j++) {
				finalA[g] = arr1[j];
				g++;
			}
		}

		if (arr2 != null) {
			System.out.println(arr2.length);
			for (int j = 1; j < arr2.length; j++) {
				finalA[g] = arr2[j];
				g++;
			}
		}
		if (arr3 != null) {
			System.out.println(arr3.length);
			for (int j = 1; j < arr3.length; j++) {
				finalA[g] = arr3[j];
				g++;
			}
		}

		return finalA;
	}

	
	//Metodo que retorna los codigos de los puntos 
	public String[] getCodeR(String[] names) {
		String[] communes = { "22", "5", "4", "3", "17", "8", "2", "19", "7", "9", "10", "11" };
		String[] code = new String[names.length];

		for (int i = 0; i < names.length; i++) {
			boolean find = false;
			for (int k = 0; k < communes.length && find == false; k++) {
				if (searchCommune(communes[k]).isElement(names[i]) == true) {
					code[i] = searchCommune(communes[k]).search(names[i]).getCode();
					System.out.println(code[i]);
					find = true;
				}
			}

		}

		return code;
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

		System.out.println(r);
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
					// System.out.println(code);
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

	public static void main(String[] args) throws Exception {
		Rappi r = new Rappi();

		r.txtCommuneNeighborhood();
		r.addNeighborhod();
		r.addEdges();

//		String[] s = r.shortestTravel("22", "Ciudad Jard�n", "17", "El Ingenio");
//		for (int i = 0; i < s.length; i++) {
//			System.out.println(s[i]);
//		}

		

//		System.out.println(r.neighGrafo.getNode(r.searchCommune("22").search("Ciudad Jard�n")));
//		System.out.println(r.neighGrafo.getNodes().size());

		//System.out.println(r.codeN("175"));
		
		//r.addEdgesM();
//		
//		double m =r.neighB.getDistance(r.searchCommune("5").search("Chiminangos"), r.searchCommune("4").search("Calima"));
//		System.out.println(r.searchCommune("17").toString());
		
		
	//	System.out.println(m);
		
		
//		String[] j = r.shortestTravel("22", "Club Campestre", "17", "Lil�");
//		
//		for (int i = 0; i < j.length; i++) {
//			System.out.println(j[i]);
//		}
//
//		System.out.println(r.codeN("220"));
//
//
//<<<<<<< HEAD
////		String[] s = r.severalDeliveries("22", "Pance", "22", "Ciudad Jard�n", "17", "El Ingenio", null,
////				null);
////
////		for (int i = 0; i < s.length; i++) {
////			System.out.println(s[i]);
////		}
//=======
//		String[] s = r.severalDeliveries("22", "Pance", "22", "Ciudad Jard�n", "19","Cuarto de Legua", null, null);
//
//		for (int i = 0; i < s.length; i++) {
//			System.out.println(s[i]);
//		}
//>>>>>>> 7b308cf0823530c58a6dc16e50b10b3d589c7626
//
//		String[] names = { "Calima", "El Ingenio", "Guayaquil", "El Lido", "Club Campestre" };
//		String[] g = r.getCodeR(names);

	}

}
