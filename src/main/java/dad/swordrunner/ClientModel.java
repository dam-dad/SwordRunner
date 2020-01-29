package dad.swordrunner;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ClientModel {

	private boolean host;

	private String skin;

	// gameplay

	private IntegerProperty health = new SimpleIntegerProperty(this, "health", 3);
	private DoubleProperty movSpeed = new SimpleDoubleProperty(this, "movSpeed", 1);
	private DoubleProperty playerX = new SimpleDoubleProperty(this, "playerX");
	private DoubleProperty playerY = new SimpleDoubleProperty(this, "playerY");

	// Conectividad
	private int port;
	private String ip;
	private Socket socket;
	private Scanner scanner;
	private ServerSocket serverSocket;

	private StringProperty connectionState = new SimpleStringProperty(this, "connection State", "");

	private InputStreamReader flujoEntrada;
	private OutputStreamWriter flujoSalida;

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public boolean isHost() {
		return host;
	}

	public void setHost(boolean host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public InputStreamReader getFlujoEntrada() {
		return flujoEntrada;
	}

	public void setFlujoEntrada(InputStreamReader flujoEntrada) {
		this.flujoEntrada = flujoEntrada;
	}

	public OutputStreamWriter getFlujoSalida() {
		return flujoSalida;
	}

	public void setFlujoSalida(OutputStreamWriter flujoSalida) {
		this.flujoSalida = flujoSalida;
	}

	public final IntegerProperty healthProperty() {
		return this.health;
	}

	public final int getHealth() {
		return this.healthProperty().get();
	}

	public final void setHealth(final int health) {
		this.healthProperty().set(health);
	}

	public final DoubleProperty movSpeedProperty() {
		return this.movSpeed;
	}

	public final double getMovSpeed() {
		return this.movSpeedProperty().get();
	}

	public final void setMovSpeed(final double movSpeed) {
		this.movSpeedProperty().set(movSpeed);
	}

	public final DoubleProperty playerXProperty() {
		return this.playerX;
	}

	public final double getPlayerX() {
		return this.playerXProperty().get();
	}

	public final void setPlayerX(final double playerX) {
		this.playerXProperty().set(playerX);
	}

	public final DoubleProperty playerYProperty() {
		return this.playerY;
	}

	public final double getPlayerY() {
		return this.playerYProperty().get();
	}

	public final void setPlayerY(final double playerY) {
		this.playerYProperty().set(playerY);
	}

	public final StringProperty connectionStateProperty() {
		return this.connectionState;
	}

	public final String getConnectionState() {
		return this.connectionStateProperty().get();
	}

	public final void setConnectionState(final String connectionState) {
		this.connectionStateProperty().set(connectionState);
	}

}
