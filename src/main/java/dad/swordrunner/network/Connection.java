package dad.swordrunner.network;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

public class Connection extends Thread {

	private Socket sk;
	
	static CyclicBarrier barrera = new CyclicBarrier(3);
	
	private String skin;
	private String itemStateString;

	Scanner entrada;
	OutputStreamWriter salida;

	public Connection(Socket sk) throws IOException {
		this.sk = sk;

		entrada = new Scanner(this.sk.getInputStream(), "UTF8");
		salida = new OutputStreamWriter(this.sk.getOutputStream(), "UTF8");

	}

	@Override
	public void run() {
		super.run();
		boolean aux = false;

		skin = entrada.nextLine().toString().split(",")[1];

		System.out.println("Cliente con skin " + skin);

		try {

			do {
				try {
					aux = false;
					System.out.println(entrada.nextLine());

				} catch (NoSuchElementException e) {
					aux = true;
				}
			} while (aux);

			salida.write("start\n");
			salida.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void send(String str) throws IOException {
		salida.write(str);
		salida.flush();

	}

	public void recive() {

		itemStateString = entrada.nextLine();

	}

	public Socket getSocket() {
		return sk;
	}

	public String getSkin() {
		return skin;
	}

	public String getItemStateString() {
		return itemStateString;
	}

}
