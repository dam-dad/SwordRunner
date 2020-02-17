package dad.swordrunner.network;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;

import dad.swordrunner.ClientModel;

public class ClientGameThread extends Thread {

	ClientModel model;
	static Boolean inGame = true;

	public ClientGameThread(ClientModel model) {
		this.model = model;
	}

	@Override
	public void run() {
		super.run();
		int indexError = 0;
//		System.out.println("Thread conexiones up");
//		System.out.println("Esperando start para sincronizar");
//		System.out.println(model.getScanner().nextLine());
//	

		try {
			Server.barrera.await();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BrokenBarrierException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (inGame) {
			try {

				sendLocalPlayerData();
				unpackData(model.getScanner().nextLine());

				indexError = 0;

			} catch (Exception e) {
				e.printStackTrace();
				indexError++;
				if (indexError == 5) {

					inGame = false;
				}
			}

		}
		try {
			model.getSocket().close();
		} catch (Exception ex) {
		}

		// Sale del bucle por lo que termina la partida

	}

	public static Boolean getInGame() {
		return inGame;
	}

	private void unpackData(String playerData) {

	}

	private void sendLocalPlayerData() throws IOException {
		String aux = "";
		int i;
		for (i = 0; i < model.getInputArray().length - 1; i++) {

			aux += model.getInputArray()[i] + ",";
		}
		System.out.println(model.getInputArray()[i]);
		aux += model.getInputArray()[i];
		System.out.println(aux);
		model.getFlujoSalida().write(aux);
	}

}
