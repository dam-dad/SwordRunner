package jueguito;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JueguitoApp extends Application{

	private PortadaController controller;
	
	

	
	public void start(Stage primaryStage) throws Exception {
		
		controller = new PortadaController();
		
		Scene scene = new Scene(controller.getView());
		
		primaryStage.setTitle("Tablas");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
