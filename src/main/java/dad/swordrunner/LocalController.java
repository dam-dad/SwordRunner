package dad.swordrunner;

import static com.almasb.fxgl.dsl.FXGL.getGameScene;
import static com.almasb.fxgl.dsl.FXGL.getGameWorld;
import static com.almasb.fxgl.dsl.FXGL.set;

import java.io.IOException;

import com.almasb.fxgl.dsl.FXGL;

import dad.swordrunner.juego.GameFactory;
import dad.swordrunner.juego.RunnerApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class LocalController {
	
	SwordRunnerApp swordRunner;
	
	//controllers
	
	private PortadaController portadaController;
	
	//view
	@FXML
    private Pane root;

    @FXML
    private Button volverButton;
    
    @FXML
    private ImageView jugador1ImageView= new ImageView();
    Image imageJ1 = new Image("/images/Jugador1.png");
    
    @FXML
    private ImageView jugador2ImageView= new ImageView();
    Image imageJ2 = new Image("/images/Jugador2.png");
    
    @FXML
    private Button listoButton;

    @FXML
    void onVolverAction(ActionEvent event) {
    	portadaController.irAMenu();
    }
    
    /**
     * Se encarga de cargar la vista del fxml Local.fxml
     * @param portadaController
     * @throws IOException
     */
    public LocalController(PortadaController portadaController) throws IOException {
    	this.portadaController = portadaController;

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Local.fxml"));
		loader.setController(this);
		loader.load();
		
		jugador1ImageView.setImage(imageJ1);
		jugador1ImageView.setFitWidth(250);
		jugador1ImageView.setFitHeight(250);
		
		jugador2ImageView.setImage(imageJ2);
		jugador2ImageView.setFitWidth(250);
		jugador2ImageView.setFitHeight(250);
		
		
		
	}
    
    @FXML
    void onListoAction(ActionEvent event) {
    	
			getGameScene().removeGameView(RunnerApp.getView());
			
			getGameWorld().addEntityFactory(new GameFactory());

			RunnerApp.player = null;

			FXGL.setLevelFromMap("escenario.tmx");

			RunnerApp.player = getGameWorld().spawn("player", 100, 0);

			set("player", RunnerApp.player);

//    	
//    	RunnerApp.setIniciar(true);
//    	RunnerApp.botonPulsado();
//    	RunnerApp.botonPulsado(buton);
//    	swordRunner.getPrimaryStage().close();
    	
    	
    }

	public Pane getView() {
		return root;
	}
}
