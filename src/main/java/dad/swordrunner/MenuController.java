package dad.swordrunner;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MenuController {
	
	//  controllers
	private PortadaController portadaController;
	
	// view

	@FXML
	private Pane root;

	@FXML
	private Button comoJugarButton;

	@FXML
	private Button jugarButton;

	public MenuController(PortadaController portadaController) throws IOException {
		this.portadaController = portadaController;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@FXML
	void onJugarConAmigosAction(ActionEvent event) throws IOException {
		portadaController.irADirecciones();
	}
	
	@FXML
    void onComoJugarAction(ActionEvent event) {
		portadaController.irAComoJugar();
    }

    @FXML
    void onLocalAction(ActionEvent event) {
    	portadaController.irALocal();
    }

	public Pane getView() {
		return root;
	}

}
