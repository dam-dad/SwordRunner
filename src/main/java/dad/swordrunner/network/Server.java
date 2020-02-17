package dad.swordrunner.network;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

import dad.swordrunner.ClientModel;
import javafx.concurrent.Task;

//
public class Server extends Task<Integer> {

	private ClientModel model;
	private ServerSocket skServidor;
	static CyclicBarrier barrera = new CyclicBarrier(3);
	private static Connection[] connectionsArray=new Connection[] {
			new Connection(), new Connection()
	};
	



	public static CyclicBarrier getBarrera() {
		return barrera;
	}

	private static int Puerto;
	static int numCliente = 0;

	/**
	 * Constructor del servidor que recibe como parámetro el modelo del cliente para
	 * inicializar sus variables
	 * 
	 * @param model
	 */
	public Server(ClientModel model) {
		this.model = model;
		Puerto = model.getPort();

	}

	@Override
	protected Integer call() throws Exception {
		System.out.println("server ok");
		try {

			// Inicio el servidor en el puerto
			

			skServidor = new ServerSocket(Puerto);
			model.setServerSocket(skServidor);

			
			System.out.println("Escucho el puerto " + Puerto);
			
			for(int nplayers=0; nplayers<2;nplayers++) {

			Socket skCliente = skServidor.accept();

			System.out.println("Cliente conectado");
			}

			
			barrera.await();
			
			System.out.println(ClientGameThread.getInGame());
			while(ClientGameThread.getInGame()) {
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}
		return 0;
	}

	public ClientModel getModel() {
		return model;
	}

	

}
