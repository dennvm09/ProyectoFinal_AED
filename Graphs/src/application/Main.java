package application;
	
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Rappi;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static Rappi rappi = new Rappi();
	
	public Main() {
		
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("SignIn.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void signUpDealer(String id, String name, String password) {
		rappi.addDealer(id, name, password);
	}
	
	public static String searchNeighborhood(String cod) {
		
		try {
			rappi.txtCommuneNeighborhood();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String barrio = rappi.codeN(cod);
		return barrio;
	}
	
	public static String[] barriosxComuna(String comuna) {
		try {
			rappi.txtCommuneNeighborhood();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] barrios = rappi.searchCommune(comuna).toString().split("	");
		return barrios;
	}
	
	public static String[] shortestPath(String cI, String bI, String cF, String bF) throws Exception {
	
		rappi.txtCommuneNeighborhood();
		rappi.addNeighborhod();
		rappi.addEdges();

		String[] path = path = rappi.shortestTravel(cI, bI, cF, bF);
				
		return path;
	}
	
	public static String[] variosPedidos(String communeI, String neighborhoodI, String c1, String neigh1, String c2,
			String neigh2, String c3, String neigh3) throws Exception {
		
		rappi.txtCommuneNeighborhood();
		rappi.addNeighborhod();
		rappi.addEdges();
		String [] paths = rappi.severalDeliveries(communeI, neighborhoodI, c1, neigh1, c2, neigh2, c3, neigh3);
		
		return paths;
	}
	
	public static Rappi getRappi() {
		return rappi;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
