package dad.swordrunner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwordRunnerApp extends Application{

	private PortadaController controller;
	public Scene scene;
	private static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Portada.fxml"));
//		
//		Scene scene = new Scene(root);
//		primaryStage.setTitle("SwordRunner");
//		primaryStage.setScene(scene);
//		primaryStage.show();
		
		SwordRunnerApp.primaryStage = primaryStage;
		
		controller = new PortadaController();
		
		scene = new Scene(controller.getView(), 1280, 720);
		
		
		primaryStage.setTitle("SwordRunner");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
