package dad.swordrunner;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class ComoJugarController {
	//Controllers
	private PortadaController portadaController;
	
	//view
	@FXML
    private Pane root;

    @FXML
    private Button volverButton;

    @FXML
    private Label controlesLabel;

    @FXML
    private Label movimientoLabel;

    @FXML
    private Label saltarLabel;

    @FXML
    private Label agacharseLabel;

    @FXML
    private Label correrLabel;

    @FXML
    private Label pegarLabel;

    @FXML
    private Label comoSeJuegaLabel;

    @FXML
    private Label instruccion1Label;

    @FXML
    private Label instruccion2Label;

    @FXML
    private Label instruccion3Label;

    @FXML
    private Label instruccion4Label;

    @FXML
    private Label instruccion5Label;
    
    public ComoJugarController(PortadaController portadaController) throws IOException {
		this.portadaController = portadaController;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ComoJugar.fxml"));
		loader.setController(this);
		loader.load();
	}

    @FXML
    void onVolverAction(ActionEvent event) {
    	portadaController.irAMenu();
    }
    public Pane getView() {
		return root;
	}
}
