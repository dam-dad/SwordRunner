package dad.swordrunner.network;

import dad.swordrunner.ClientModel;

public class ClientGameThread extends Thread {

	ClientModel model;
	Boolean inGame;
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

		while (inGame) {
			try {
				//if (model.isPlayerAlive())
//					sendPlayerPosition();
//				desempaquetarPosiciones(model.getScanner().nextLine());
				indexError = 0;
			} catch (Exception e) {
				indexError++;
				if (indexError == 5) {

					inGame=false;
				}
			}

		}
		try {
			model.getSocket().close();
		} catch (Exception ex) {
		}

		// Sale del bucle por lo que termina la partida

	}

	
	

}
