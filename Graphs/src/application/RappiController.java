package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class RappiController {

	@FXML
	private Pane pane1;
	@FXML
	private ImageView imgBanner;
	@FXML
	private RadioButton rbtPedido1;
	@FXML
	private RadioButton rbtPedido2;
	@FXML
	private ComboBox<String> cbxComunaOrigen;
	@FXML
	private ComboBox<String> cbxBarrioOrigen;
	@FXML
	private ComboBox<String> cbxComunaDestino;
	@FXML
	private ComboBox<String> cbxBarrioDestino;
	@FXML
	private Button btRegistrar;
	@FXML
	private TextArea txtRecorrido;
	@FXML
	private ImageView imgMapa;
	@FXML
	private Label lblHola;
	
	@FXML
	private Circle circulo1;
	@FXML
	private Circle circulo2;
	
	
	//Circulos que representan los barrios
		//Comuna 22
	@FXML
	private Circle b220;
	@FXML
	private Circle b221;
	@FXML
	private Circle b222;
	@FXML
	private Circle b223;
	@FXML
	private Circle b224;
	
	
	//
	
	public void initialize() {
		
		rbtPedido1.setOnAction(e-> checkers(1));
		rbtPedido2.setOnAction(e-> checkers(-1));
		
		
		
		pane1.setVisible(false);
		
	}
	
	
	public void metocaron(MouseEvent e) {
	
			circulo1.setOnMouseMoved(a-> meto(1));
			circulo2.setOnMouseMoved(a-> meto(2));
			
		
	}
	
	
	public void mostrarBarrios(MouseEvent e) {
		b220.setOnMouseMoved(a -> buscarBarrio("220"));
		b221.setOnMouseMoved(a -> buscarBarrio("221"));
		b222.setOnMouseMoved(a -> buscarBarrio("222"));
		b223.setOnMouseMoved(a -> buscarBarrio("223"));
		b224.setOnMouseMoved(a -> buscarBarrio("224"));
		
	}
	
	
	public void buscarBarrio(String cod) {
		String barrio = Main.searchNeighborhood(cod);
		lblHola.setText(barrio);
		
	}
	
	public void meto(int i) {
		if(i == 1) {
			lblHola.setText("me tocaron");
		}if(i == 2) {
			lblHola.setText("ayyyyyyyy");
		}
	}
	
	public void checkers(int i) {
		if(i > 0) {
			if(rbtPedido1.isSelected()) {
				rbtPedido2.setSelected(false);
				System.out.println("Me seleccionaron 1");
				pane1.setVisible(true);
			}
		}else {
			if(rbtPedido2.isSelected()) {
				rbtPedido1.setSelected(false);
				System.out.println("Me seleccionaron 2");
				pane1.setVisible(false);
			}
		}
	}
	

	
}
