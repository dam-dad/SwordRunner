package dad.swordrunner;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class LocalController {
	
	//controllers
	
	private PortadaController portadaController;
	
	//view
	@FXML
    private VBox root;

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

	public VBox getView() {
		return root;
	}
}
