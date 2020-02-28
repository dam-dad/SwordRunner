package dad.swordrunner.network;

import java.io.IOException;

import dad.swordrunner.ClientModel;

public class ClientGameThread extends Thread {

	ClientModel model;

	public ClientGameThread(ClientModel model) {
		this.model = model;
	}

	@Override
	public void run() {
		super.run();
		int indexError = 0;
		System.out.println("Thread conexiones up");
		System.out.println("Esperando start para sincronizar");
		System.out.println(model.getScanner().nextLine());
		model.setEnPartida(true);

		while (model.isEnPartida()) {
			try {
				//if (model.isPlayerAlive())
					sendPlayerPosition();
				System.out.println(desempaquetarPosiciones(model.getScanner().nextLine()));
				indexError = 0;
			} catch (Exception e) {
				indexError++;
				if (indexError == 5) {

					model.setEnPartida(false);
				}
			}

		}
		try {
			model.getSocket().close();
		} catch (Exception ex) {
		}

		// Sale del bucle por lo que termina la partida

	}

	

	public String desempaquetarPosiciones(String paquete) {
		return paquete;
	}

	private void sendPlayerPosition() throws Exception {

		String aux = "";
		int i;
		for (i = 0; i < model.getInputArray().length - 1; i++) {

			aux += model.getInputArray()[i] + ",";
		}
		aux += model.getInputArray()[i];
		model.getFlujoSalida().write(aux);
		model.getFlujoSalida().flush();
		System.out.println(2);
	}

}
