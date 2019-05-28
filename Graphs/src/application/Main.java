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
		return rappi.codeN(cod);
	}
	
	public static Rappi getRappi() {
		return rappi;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
