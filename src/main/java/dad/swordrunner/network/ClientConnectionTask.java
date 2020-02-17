package dad.swordrunner.network;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

import dad.swordrunner.ClientModel;
import javafx.concurrent.Task;

public class ClientConnectionTask extends Task<Integer> {

	ClientModel model;

	public ClientConnectionTask(ClientModel model) {
		this.model = model;
	}

	
	
	/**
	 * Establece la conexión con el servidor con un máximo de 5 intentos
	 * 
	 */
	
	
	@Override
	protected Integer call() throws Exception {
		System.out.println("dvsdmbvsdzgfasdfjl");
		final int MAX_INTENTOS = 5;
		int intentos = 0;
		model.setSocket(new Socket());
		model.setConnectionState("Buscando servidor");
		while (intentos != MAX_INTENTOS && !model.getSocket().isConnected()) {
			try {
				model.setConnectionState(model.getConnectionState() + ".");
				intentos++;
				model.setSocket(new Socket(model.getIp(), 2000));
			} catch (Exception e) {
				// Si se han llegado a 3 intentos se cancela la conexión y da excepción para
				// salir del task
				if (intentos == MAX_INTENTOS) {
					System.err.println("No se ha encontrado un servidor");
					throw new SocketTimeoutException();
				}
				// Ignorar la excepcion y esperar un poco
				Thread.sleep(1000);
			}
		}

		
		model.setConnectionState("Servidor encontrado, esperando jugadores");
		
		// Establecer los flujos



		model.setScanner(new Scanner(model.getFlujoEntrada()));



		model.setConnectionState("Esperando señal de inicio desde el servidor...");
		
		Server.getBarrera().await();
		
		Server.getBarrera().await();
		model.setConnectionState("Empezando la partida...");
		
		

		return 0;
	}
}
