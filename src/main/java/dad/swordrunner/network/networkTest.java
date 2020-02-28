package dad.swordrunner.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

import dad.swordrunner.ClientModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class networkTest extends Application {

	ClientGameThread gamethread;
	ClientGameThread gamethread2;
	ClientModel model = new ClientModel(), model2 = new ClientModel();


	@Override
	public void start(Stage primaryStage) throws Exception {
		Server server;
		Thread serverThread;
		ClientConnectionTask clientConnectionTask, clienttask2;
		Thread clientConnectionThread, clientthread2;
		

		model.setPort(2000);
		try {

			model.setIp(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		server = new Server(model);
		serverThread = new Thread(server);
		clientConnectionTask = new ClientConnectionTask(model);
		clienttask2 = new ClientConnectionTask(model2);
		clienttask2.setOnSucceeded(e -> startGame(gamethread, model));
		clientConnectionTask.setOnSucceeded(e -> startGame(gamethread2, model2));
		clientConnectionThread = new Thread(clientConnectionTask);
		clientthread2 = new Thread(clienttask2);

		serverThread.start();
	
		clientConnectionThread.start();
		clientthread2.start();
	

	

	}

	public static void main(String[] args) {
		launch(args);
	}

	private void startGame(ClientGameThread thread, ClientModel model) {
		thread = new ClientGameThread(model);
		

		thread.start();
		
	}

}
