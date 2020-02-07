package dad.swordrunner;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PortadaController implements Initializable {

	// controllers
	private MenuController menuController;
	private OnlineController onlineController;
	private LocalController localController;
	private ComoJugarController comoJugarController;
	
	// view	

	@FXML
	private BorderPane root;

	@FXML
	private Button startButton;
	
	public PortadaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Portada.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			menuController = new MenuController(this);
			onlineController = new OnlineController(this);
			localController = new LocalController(this);
			comoJugarController = new ComoJugarController(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void onPulsarEnterAction(ActionEvent event) throws IOException {
		irAMenu();
	}
	
	public void irAMenu() {
		root.getChildren().setAll(menuController.getView());
	}

	public void irADirecciones() {
		root.getChildren().setAll(onlineController.getView());
	}
	
	public void irALocal() {
		root.getChildren().setAll(localController.getView());
	}
	
	public void irAComoJugar() {
		root.getChildren().setAll(comoJugarController.getView());
	}

	public BorderPane getView() {
		return root;
	}
	
	


}
