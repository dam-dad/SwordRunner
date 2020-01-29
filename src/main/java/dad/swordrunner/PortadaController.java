package dad.swordrunner;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PortadaController {

	// view
	public PortadaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Portada.fxml"));
		loader.setController(this);
		loader.load();
	}
	

	@FXML
	private VBox root;

	@FXML
	private VBox raiz;

	@FXML
	private Button startButton;

	// view2

	@FXML
	private VBox root2;

	@FXML
	private Button comoJugarButton;

	@FXML
	private Button jugarButton;

	@FXML
	void onPulsarEnterAction(ActionEvent event) throws IOException {

		Button button = (Button) event.getSource();
		String buttonId = button.getId();
		CambioPantalla mainl = new CambioPantalla();
		mainl.chooseMenu(buttonId);
	}

	public VBox getView() {
		return root;
	}
	
	public VBox getView2() {
		return root;
	}
		
//	public void switchScene(String fxmlFile)
//	{
//
//	    FXMLLoader loader = new FXMLLoader(getClass()
//	            .getResource(fxmlFile));
//	    Parent root;
//	    try 
//	    {
//	        root = (Parent)loader.load();
//	        if(fxmlFile.equals("calculator.fxml"))
//	        {
//	            BasicCalculatorView controller = (BasicCalculatorView)loader.getController();
//	            controller.setModel(new BasicCalculatorModelTest(controller));
//	            controller.setLogic(this);
//	        }
//	        else if(fxmlFile.equals("TestSwitch.fxml"))
//	        {
//	            TestSwitch controller = (TestSwitch)loader.getController();
//	            controller.setLogic(this);
//	        }
//	        this.stage.setScene(new Scene(root));
//	    } 
//	    catch (IOException e)
//	    {
//	        e.printStackTrace();
//	    }
//
//	}


}
