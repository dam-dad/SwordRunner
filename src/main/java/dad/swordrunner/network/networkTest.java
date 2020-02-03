package dad.swordrunner.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

import dad.swordrunner.ClientModel;

public class networkTest {

	public static void main(String[] args){
		ClientModel model = new ClientModel();
		Server server;
		Thread serverThread;
		ClientConnectionTask clientConnectionTask;
		Thread clientConnectionThread;
		
		model.setPort(2000);
		try {
			
		model.setIp(InetAddress.getLocalHost().getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		server = new Server(model);
		serverThread = new Thread(server);
		serverThread.start();

		clientConnectionTask = new ClientConnectionTask(model);

		clientConnectionTask.setOnSucceeded(e -> startGame());
		clientConnectionThread = new Thread(clientConnectionTask);

		clientConnectionThread.start();
	}

	private static void startGame() {
		System.out.println("jaja todo ok");
	}
}
