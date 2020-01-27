package jueguito;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CambioPantalla {
	private PortadaController controller;
	public void chooseMenu(String chooseView) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));

		controller = new PortadaController();

		Scene scene = new Scene(controller.getView2());

	}

}
