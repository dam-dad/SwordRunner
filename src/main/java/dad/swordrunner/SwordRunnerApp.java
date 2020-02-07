package dad.swordrunner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SwordRunnerApp extends Application{

	private PortadaController controller;
	public Scene scene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("/fxml/Portada.fxml"));
//		
//		Scene scene = new Scene(root);
//		primaryStage.setTitle("SwordRunner");
//		primaryStage.setScene(scene);
//		primaryStage.show();
		
		controller = new PortadaController();
		
		scene = new Scene(controller.getView());
		
		
		primaryStage.setTitle("SwordRunner");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
