package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SignUpController {

	@FXML
	private Label lblTitulo;
	@FXML
	private Label lblId;
	@FXML
	private Label lblName;
	@FXML
	private Label lblPassword;
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtPassword;
	@FXML
	private Button btCreate;
	@FXML
	private ImageView imgFondo;

	 private static final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent;"; 
	 private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";
	
	public void initialize() {
		btCreate.setGraphic(new ImageView(new Image("images/create.png")));
		btCreate.setStyle(HOVERED_BUTTON_STYLE);
		btCreate.setStyle(IDLE_BUTTON_STYLE);
	}
	
	@FXML
	public void iniciarSesion(ActionEvent e) throws IOException {
	
		newDealer();
		Pane root = (Pane)FXMLLoader.load(getClass().getResource("SignIn.fxml"));
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		Scene scene = new Scene(root);
		Stage pantalla = (Stage) ((Node)e.getSource()).getScene().getWindow();
		pantalla.setScene(scene);
		pantalla.show();
		pantalla.setResizable(false);
	}
	
	
	public void newDealer() {
		
		String id = txtId.getText();
		String name = txtName.getText();
		String password = txtPassword.getText();
		
		System.out.println("ID: "+id+"NOMBRE: "+name);
		JOptionPane.showMessageDialog(null, "La cuenta fue creada correctamente.");
		Main.signUpDealer(id, name, password);	
		
	}
}
