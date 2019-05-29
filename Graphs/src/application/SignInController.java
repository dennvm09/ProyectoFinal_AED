package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.w3c.dom.events.MouseEvent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SignInController {
	
	
	
	@FXML
	private ImageView imgFondo;
	@FXML
	private ImageView imgLogoRappi;
	@FXML
	private Label lblUsuario;
	@FXML
	private Label lblContrasenia;
	@FXML
	private TextField txtUsuario;
	@FXML
	private PasswordField txtContrasenia;
	@FXML
	private Button btEntrar;
	@FXML
	private Button btSignUp;
	
	
	
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent;"; 
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";
	
	public void initialize() {
		
		
		btEntrar.setGraphic(new ImageView(new Image("images/signin.png")));
		btEntrar.setStyle(HOVERED_BUTTON_STYLE);
		btEntrar.setStyle(IDLE_BUTTON_STYLE);
		
		btSignUp.setGraphic(new ImageView(new Image("images/signup.png")));
		btSignUp.setStyle(HOVERED_BUTTON_STYLE);
		btSignUp.setStyle(IDLE_BUTTON_STYLE);
		
	}
	
	@FXML
	public void nuevaCuenta(ActionEvent e) throws IOException {
		System.out.println("Nueva cuenta!!");
		Pane root = (Pane)FXMLLoader.load(getClass().getResource("SignUp.fxml"));
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		Scene scene = new Scene(root);
		Stage pantalla = (Stage) ((Node)e.getSource()).getScene().getWindow();
		pantalla.setScene(scene);
		pantalla.show();
		pantalla.setResizable(false);
	}
	

	
	@FXML
	public void ventanaPrincipal(ActionEvent e) throws IOException {
		System.out.println("Rappiii!!");
		Pane root = (Pane)FXMLLoader.load(getClass().getResource("Rappi.fxml"));
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		Scene scene = new Scene(root);
		Stage pantalla = (Stage) ((Node)e.getSource()).getScene().getWindow();
		pantalla.setScene(scene);
		pantalla.show();
		pantalla.setResizable(false);
	}
	

	public void iniciar(ActionEvent e) throws IOException {
		
		String id = txtUsuario.getText();
		String password = txtContrasenia.getText();
		
		boolean entrar = Main.iniciar(id, password);
		
		if(entrar) {
			ventanaPrincipal(e);
		}else {
			JOptionPane.showMessageDialog(null, "Usuario o contraseña equivocados.");
			txtUsuario.setText("");
			txtContrasenia.setText("");
		}
		
		
	}
}
