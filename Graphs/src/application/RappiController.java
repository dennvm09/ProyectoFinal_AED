package application;

import java.io.FileNotFoundException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
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
	private ChoiceBox<String> cbxComunaOrigen;
	@FXML
	private ChoiceBox<String> cbxBarrioOrigen;
	@FXML
	private ChoiceBox<String> cbxComunaDestino;
	@FXML
	private ChoiceBox<String> cbxBarrioDestino;
	@FXML
	private Button btRegistrar;
	@FXML
	private TextArea txtRecorrido;
	@FXML
	private ImageView imgMapa;
	@FXML
	private Label lblHola;
	
	
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
		//Comuna 17
	@FXML
	private Circle b170;
	@FXML
	private Circle b171;
	@FXML
	private Circle b172;
	@FXML
	private Circle b173;
	@FXML
	private Circle b174;
	@FXML
	private Circle b175;
		//Comuna 19
	@FXML
	private Circle b190;
	@FXML
	private Circle b191;
	@FXML
	private Circle b192;
	@FXML
	private Circle b193;
		//Comuna 10
	@FXML
	private Circle b100;
	@FXML
	private Circle b101;
	@FXML
	private Circle b102;
	@FXML
	private Circle b103;
		//Comuna 11
	@FXML
	private Circle b110;
	@FXML
	private Circle b111;
	@FXML
	private Circle b112;
	@FXML
	private Circle b113;
		//Comuna 9
	@FXML
	private Circle b90;
	@FXML
	private Circle b91;
	@FXML
	private Circle b92;
	@FXML
	private Circle b93;
		//Comuna 3
	@FXML
	private Circle b30;
	@FXML
	private Circle b31;
	@FXML
	private Circle b32;
	@FXML
	private Circle b33;
		//Comuna 2
	@FXML
	private Circle b20;
	@FXML
	private Circle b21;
	@FXML
	private Circle b22;
	@FXML
	private Circle b23;
	@FXML
	private Circle b24;
	@FXML
	private Circle b25;
		//Comuna 4
	@FXML
	private Circle b40;
	@FXML
	private Circle b41;
	@FXML
	private Circle b42;
	@FXML
	private Circle b43;
		//Comuna 5
	@FXML
	private Circle b50;
	@FXML
	private Circle b51;
	@FXML
	private Circle b52;
	@FXML
	private Circle b53;
	@FXML
	private Circle b54;
		//Comuna 7
	@FXML
	private Circle b70;
	@FXML
	private Circle b71;
	@FXML
	private Circle b72;
		//Comuna 8
	@FXML
	private Circle b80;
	@FXML
	private Circle b81;
	@FXML
	private Circle b82;
	@FXML
	private Circle b83;
	@FXML
	private Circle b84;
	
	@FXML
	private Button cl;

	
	public void initialize() {
		
		rbtPedido1.setOnAction(e-> checkers(1));
		rbtPedido2.setOnAction(e-> checkers(-1));
		pane1.setVisible(false);
		
		rellenarComunas();
		//barriosxComuna();
	}
	
	public void rellenarComunas() {
		ObservableList<String> items = FXCollections.observableArrayList();
		items.addAll("Comuna 2", "Comuna 3", "Comuna 4", "Comuna 5", "Comuna 7", "Comuna 8", "Comuna 9", "Comuna 10", "Comuna 11", "Comuna 17", "Comuna 19", "Comuna 22");
		cbxComunaDestino.setItems(items);
		cbxComunaOrigen.setItems(items);
		
		
		
	}
	
	public void barriosxComuna() {
		cbxComunaOrigen.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				String [] c = newValue.split(" ");
				String comuna = c[1];
				
				String[] barrios = Main.barriosxComuna(comuna);
				rellenarBarrios(barrios);

			}
			
		});
		cbxComunaDestino.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				String [] c = newValue.split(" ");
				String comuna = c[1];
				
				String[] barrios = Main.barriosxComuna(comuna);
				rellenarBarrios(barrios);

			}
			
		});
	}
	
	
	public void rellenarBarrios(String[] barrios) {
		ObservableList<String> items = FXCollections.observableArrayList();
		for(int i = 0; i < barrios.length; i++) {
			System.out.println(barrios[i]);
			items.addAll(barrios[i]);
		}
		cbxBarrioOrigen.setItems(items);
		cbxBarrioDestino.setItems(items);
	}
	
	public void mostrarBarrios(MouseEvent e) {
		b220.setOnMouseMoved(a -> buscarBarrio("220"));
		b221.setOnMouseMoved(a -> buscarBarrio("221"));
		b222.setOnMouseMoved(a -> buscarBarrio("222"));
		b223.setOnMouseMoved(a -> buscarBarrio("223"));	
		b224.setOnMouseMoved(a -> buscarBarrio("224"));
		
		b170.setOnMouseMoved(a -> buscarBarrio("170"));
		b171.setOnMouseMoved(a -> buscarBarrio("171"));
		b172.setOnMouseMoved(a -> buscarBarrio("172"));
		b173.setOnMouseMoved(a -> buscarBarrio("173"));	
		b174.setOnMouseMoved(a -> buscarBarrio("174"));
		b175.setOnMouseMoved(a -> buscarBarrio("175"));
		
		b190.setOnMouseMoved(a -> buscarBarrio("190"));
		b191.setOnMouseMoved(a -> buscarBarrio("191"));
		b192.setOnMouseMoved(a -> buscarBarrio("192"));
		b193.setOnMouseMoved(a -> buscarBarrio("193"));	
		
		b100.setOnMouseMoved(a -> buscarBarrio("100"));
		b101.setOnMouseMoved(a -> buscarBarrio("101"));
		b102.setOnMouseMoved(a -> buscarBarrio("102"));
		b103.setOnMouseMoved(a -> buscarBarrio("103"));	
		
		b110.setOnMouseMoved(a -> buscarBarrio("110"));
		b111.setOnMouseMoved(a -> buscarBarrio("111"));
		b112.setOnMouseMoved(a -> buscarBarrio("112"));
		b113.setOnMouseMoved(a -> buscarBarrio("113"));	
		
		b90.setOnMouseMoved(a -> buscarBarrio("90"));
		b91.setOnMouseMoved(a -> buscarBarrio("91"));
		b92.setOnMouseMoved(a -> buscarBarrio("92"));
		b93.setOnMouseMoved(a -> buscarBarrio("93"));	
		
		b30.setOnMouseMoved(a -> buscarBarrio("30"));
		b31.setOnMouseMoved(a -> buscarBarrio("31"));
		b32.setOnMouseMoved(a -> buscarBarrio("32"));
		b33.setOnMouseMoved(a -> buscarBarrio("33"));	
		
		b20.setOnMouseMoved(a -> buscarBarrio("20"));
		b21.setOnMouseMoved(a -> buscarBarrio("21"));
		b22.setOnMouseMoved(a -> buscarBarrio("22"));
		b23.setOnMouseMoved(a -> buscarBarrio("23"));	
		b24.setOnMouseMoved(a -> buscarBarrio("24"));
		b25.setOnMouseMoved(a -> buscarBarrio("25"));
		
		b40.setOnMouseMoved(a -> buscarBarrio("40"));
		b41.setOnMouseMoved(a -> buscarBarrio("41"));
		b42.setOnMouseMoved(a -> buscarBarrio("42"));
		b43.setOnMouseMoved(a -> buscarBarrio("43"));
		
		b50.setOnMouseMoved(a -> buscarBarrio("50"));
		b51.setOnMouseMoved(a -> buscarBarrio("51"));
		b52.setOnMouseMoved(a -> buscarBarrio("52"));
		b53.setOnMouseMoved(a -> buscarBarrio("53"));
		b54.setOnMouseMoved(a -> buscarBarrio("54"));
		
		b70.setOnMouseMoved(a -> buscarBarrio("70"));
		b71.setOnMouseMoved(a -> buscarBarrio("71"));
		b72.setOnMouseMoved(a -> buscarBarrio("72"));
		
		b80.setOnMouseMoved(a -> buscarBarrio("80"));
		b81.setOnMouseMoved(a -> buscarBarrio("81"));
		b82.setOnMouseMoved(a -> buscarBarrio("82"));
		b83.setOnMouseMoved(a -> buscarBarrio("83"));
		b84.setOnMouseMoved(a -> buscarBarrio("84"));
		
		imgMapa.setOnMouseMoved(a ->x());
	}
	public void x() {
		lblHola.setText("");
	}
	public void buscarBarrio(String cod) {
		String barrio = Main.searchNeighborhood(cod);
		lblHola.setText(barrio);
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
