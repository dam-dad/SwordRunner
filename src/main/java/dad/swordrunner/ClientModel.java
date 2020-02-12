package dad.swordrunner;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
	private BooleanProperty w=new SimpleBooleanProperty(this, "w key");
	private BooleanProperty a=new SimpleBooleanProperty(this, "a key");
	private BooleanProperty s=new SimpleBooleanProperty(this, "s key");
	private BooleanProperty d=new SimpleBooleanProperty(this, "d key");
	private BooleanProperty space=new SimpleBooleanProperty(this, "space key");
	private BooleanProperty k=new SimpleBooleanProperty(this, "k key");
	
	
	

	
	
	
	public boolean[] getInputArray() {
		boolean[] inputBoolean=new boolean[] {isA(),isW(),isS(),isD(),isSpace(),isK()};
		return inputBoolean;
	}


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

	public final StringProperty connectionStateProperty() {
		return this.connectionState;
	}

	public final String getConnectionState() {
		return this.connectionStateProperty().get();
	}

	public final void setConnectionState(final String connectionState) {
		this.connectionStateProperty().set(connectionState);
	}

	public final BooleanProperty wProperty() {
		return this.w;
	}
	

	public final boolean isW() {
		return this.wProperty().get();
	}
	

	public final void setW(final boolean w) {
		this.wProperty().set(w);
	}
	

	public final BooleanProperty aProperty() {
		return this.a;
	}
	

	public final boolean isA() {
		return this.aProperty().get();
	}
	

	public final void setA(final boolean a) {
		this.aProperty().set(a);
	}
	

	public final BooleanProperty sProperty() {
		return this.s;
	}
	

	public final boolean isS() {
		return this.sProperty().get();
	}
	

	public final void setS(final boolean s) {
		this.sProperty().set(s);
	}
	

	public final BooleanProperty dProperty() {
		return this.d;
	}
	

	public final boolean isD() {
		return this.dProperty().get();
	}
	

	public final void setD(final boolean d) {
		this.dProperty().set(d);
	}
	

	public final BooleanProperty spaceProperty() {
		return this.space;
	}
	

	public final boolean isSpace() {
		return this.spaceProperty().get();
	}
	

	public final void setSpace(final boolean space) {
		this.spaceProperty().set(space);
	}
	

	public final BooleanProperty kProperty() {
		return this.k;
	}
	

	public final boolean isK() {
		return this.kProperty().get();
	}
	

	public final void setK(final boolean k) {
		this.kProperty().set(k);
	}
	

	

}
