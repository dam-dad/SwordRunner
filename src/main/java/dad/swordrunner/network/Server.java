package dad.swordrunner.network;

import java.net.ServerSocket;
import java.net.Socket;


import dad.swordrunner.ClientModel;
import javafx.concurrent.Task;

//
public class Server extends Task<Integer> {

	private ClientModel model;
	private ServerSocket skServidor;
	
	private Connection con;

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

			Socket skCliente = skServidor.accept();

			System.out.println("Cliente conectado");
		
			con=new Connection(skCliente);
			
			con.start();
			
			System.out.println(ClientGameThread.getInGame());
			while(ClientGameThread.getInGame()) {
				System.out.println(model.getFlujoEntrada());
				System.out.println(model.getFlujoEntrada().read()+"dfdfsf");
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
