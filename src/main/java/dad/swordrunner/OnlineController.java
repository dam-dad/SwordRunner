package dad.swordrunner;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class OnlineController {

	// controllers

	private PortadaController portadaController;
	private ClientModel model;
	
	//bindeos
	
	
	

	// view

	@FXML
	private Pane root;

	@FXML
	private VBox componentes;

	@FXML
	private Label ipLabel;

	@FXML
	private TextField ipTextField;

	@FXML
	private Label puertoLabel;

	@FXML
	private TextField puertoTextField;

	@FXML
	private Label nickLabel;

	@FXML
	private TextField nickTextField;

	@FXML
	private Button confirmarButton;

	@FXML
	private Button volverButton;

	@FXML
	void onVolverAction(ActionEvent event) {
		portadaController.irAMenu();
	}
	
	/**
	 * Botón que comprueba si la información introducida concuerda con los parámetros necesarios. En caso de que no concuerde,
	 * se mostrarán ventanas acorde a los errores.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void onConfirmarAction(ActionEvent event) throws IOException {
		StringProperty ipDatos = ipTextField.textProperty();
		StringProperty puertoDatos = puertoTextField.textProperty();
		StringProperty nickDatos = nickTextField.textProperty();

		Pattern patron = Pattern.compile("^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$");
		
		Matcher mather = patron.matcher(ipDatos.get());
		
		model.setIp(ipDatos.toString());
		model.setPort(Integer.parseInt(puertoDatos.toString()));
		model.setName(nickDatos.toString());
		
		
		if (ipDatos.get().isEmpty() | puertoDatos.get().isEmpty()) {
			Alert alertaOnline = new Alert(AlertType.ERROR);
			alertaOnline.setTitle("Error");
			alertaOnline.setHeaderText("Error");
			alertaOnline.setContentText("Alguno de los campos (Ip o Puerto) no se ha introducido.");
			alertaOnline.showAndWait();
		}else {
			if (puertoDatos.get().length()!=4) {
				Alert alertaOnline = new Alert(AlertType.ERROR);
				alertaOnline.setTitle("Error");
				alertaOnline.setHeaderText("Error");
				alertaOnline.setContentText("El campo Puerto se ha introducido incorrectamente.");
				alertaOnline.showAndWait();
			}
			if(mather.find() == false) {
				Alert alertaOnline = new Alert(AlertType.ERROR);
				alertaOnline.setTitle("Error");
				alertaOnline.setHeaderText("Error");
				alertaOnline.setContentText("El campo Ip se ha introducido incorrectamente.");
				alertaOnline.showAndWait();
			}
			if(nickDatos.get().length()>12) {
				Alert alertaOnline = new Alert(AlertType.ERROR);
				alertaOnline.setTitle("Error");
				alertaOnline.setHeaderText("Error");
				alertaOnline.setContentText("El Nick se pasa de los caracteres permitidos. \nPrueba otro más corto(Max 12 cararcteres).");
				alertaOnline.showAndWait();
			}else if(nickDatos.get().isEmpty()) {
				nickDatos.set("user.name");
			}
		}
	}
	

	
	

	public OnlineController(PortadaController portadaController) throws IOException {
		this.portadaController = portadaController;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Direcciones.fxml"));
		loader.setController(this);
		loader.load();
	}

	public Pane getView() {
		return root;
	}
}
