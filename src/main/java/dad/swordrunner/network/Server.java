package dad.swordrunner.network;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import dad.swordrunner.ClientModel;
import javafx.concurrent.Task;

//
public class Server extends Task<Integer> {

	private static int nPlayers;
	private static ArrayList<Connection> playersArray = new ArrayList<Connection>();

	private static String players = "", playersState = "";

	private ClientModel model;
	private ServerSocket skServidor;


	public static String getPlayers() {
		return players;
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
		nPlayers = 2;
		Puerto = model.getPort();

	}

	
	@Override
	protected Integer call() throws Exception {
		try {

			// Inicio el servidor en el puerto

			skServidor = new ServerSocket(Puerto);
			model.setServerSocket(skServidor);

			System.out.println("Escucho el puerto " + Puerto);

			while (numCliente < 2) {

				Socket skCliente = skServidor.accept();

				System.out.println("Cliente conectado");

//				Atiendo al cliente mediante un thread
				playersArray.add(new Connection(skCliente, ++numCliente, playersArray));
			}

			for (Connection con : playersArray) {
				con.start();
			}

			Connection.barrera.await();

			for (Connection con : playersArray) {
				players += con.getIdentity() + "," + con.getNombre() + "," + con.getSkin() + "_";
			}

			players.concat("\n");
			Connection.barrera.await();
		
			Connection.barrera.await();
			
			while (playersArray.size() != 1) {

				playersState = "";
				for (Connection con : playersArray) {
				

					try {
						System.out.println("asdfdsklfhadsklfhadsgfd");
						con.recive();
						playersState += con.getItemStateString();
						
					} catch (NoSuchElementException e) {
						System.out.println("dsfdsfsfadsfdsfasf");
					}

				}

				

				playersState += "\n";
				for (Connection con : playersArray) {
					try {
						con.send(playersState);
					} catch (Exception e) {
					}

				}

			}
			System.out.println("cacac");
		
		
			
			
			skServidor.close();

		} catch (Exception e) {
			e.printStackTrace();
			return 1;
		}

		return 0;
	}


}
