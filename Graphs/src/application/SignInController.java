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
	
	
	
	
	
	/**
	 * @FXML - para abrir de una ventana a otra. 
	public void crearCuenta(MouseEvent e) throws TipoUsuarioExcepcion, IOException {
		System.out.println("Hola, crear cuenta!!");
		Pane root = (Pane)FXMLLoader.load(getClass().getResource("CrearCuenta.fxml"));
		root.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		Scene scene = new Scene(root);
		//Obtiene la información del Stage
		Stage pantalla = (Stage) ((Node)e.getSource()).getScene().getWindow();
		pantalla.setScene(scene);
		pantalla.show();
		pantalla.setResizable(false);
	}
	
	este es para guardar los datos en el archivo, puede ir en la principal del modelo
	public void guardarArchivoProveedor(String codigo, String nombre, String empresa, String nit, String direccion, String telefono, String urlImagen) {
		FileWriter flwriter = null;
		try {
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("src/datos/proveedores.txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (int i = 0; i < empleados; i++) {
				//escribe los datos en el archivo
				bfwriter.write(codigo + "," + nombre + "," + empresa
						+ "," + nit + "," + direccion + "," + telefono + "," + urlImagen +"\n");
			}
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public Proveedor cargarArchivoProveedor(String id) {
		
		String texto="";
		Proveedor c = null;
		try{
			FileReader lector=new FileReader("src/datos/proveedores.txt");

			BufferedReader contenido=new BufferedReader(lector);
			String linea= contenido.readLine();
			String[] str=linea.split(",");
		
			while(linea!=null){
			
				c = new Proveedor(str[0].toString(), str[1].toString(), str[2].toString(), str[3].toString(), str[4].toString(), str[5].toString(), str[6].toString());

				if(id.equalsIgnoreCase(str[0].toString())) {
					primerProveedor = c;
					return c;
				}
				
			}
			lector.close();
			contenido.close();
		}catch(Exception e){
			System.out.println("Error al leer");
		}
		return c;
	}
	
	
	 * */
}
