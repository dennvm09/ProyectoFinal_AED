package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
	
    private static final String IDLE_BUTTON_STYLE = "-fx-background-color: transparent;"; 
    private static final String HOVERED_BUTTON_STYLE = "-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, -fx-body-color;";
	
	public void initialize() {
		
		
		btEntrar.setGraphic(new ImageView(new Image("images/signin.png")));
		btEntrar.setStyle(HOVERED_BUTTON_STYLE);
		btEntrar.setStyle(IDLE_BUTTON_STYLE);
		
	}
}
