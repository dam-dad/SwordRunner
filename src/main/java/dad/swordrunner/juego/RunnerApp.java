package dad.swordrunner.juego;

import com.almasb.fxgl.app.*;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;

import com.almasb.fxgl.input.UserAction;

import dad.swordrunner.ComoJugarController;
import dad.swordrunner.LocalController;
import dad.swordrunner.MenuController;
import dad.swordrunner.OnlineController;
import dad.swordrunner.PortadaController;
import dad.swordrunner.juego.componentes.PlayerComponent;

import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Map;
import static com.almasb.fxgl.dsl.FXGL.*;

public class RunnerApp extends GameApplication {

	@Override
	protected void initSettings(GameSettings settings) {
		settings.setWidth(2000);
		settings.setHeight(1000);
		settings.setFullScreenAllowed(true);
		settings.setFullScreenFromStart(true);
	}

	public static Entity player;
	public static GameView view;
	public static boolean iniciar = false;

	public static GameView getView() {
		return view;
	}
	
	public static void setIniciar(boolean iniciar) {
		RunnerApp.iniciar = iniciar;
	}
	
	/**Se asigna la función de cada input (a cada tecla)
	 * 
	 */

	@Override
	protected void initInput() {
		getInput().addAction(new UserAction("Left") {
			@Override
			protected void onAction() {
				player.getComponent(PlayerComponent.class).left();
			}

			@Override
			protected void onActionEnd() {
				player.getComponent(PlayerComponent.class).stop();
			}
		}, KeyCode.A);

		getInput().addAction(new UserAction("Right") {
			@Override
			protected void onAction() {
				player.getComponent(PlayerComponent.class).right();
			}

			@Override
			protected void onActionEnd() {
				player.getComponent(PlayerComponent.class).stop();
			}
		}, KeyCode.D);

		getInput().addAction(new UserAction("Jump") {
			@Override
			protected void onActionBegin() {
				player.getComponent(PlayerComponent.class).jump();
			}
		}, KeyCode.W);
	}

	@Override
	protected void initGameVars(Map<String, Object> vars) {

	}
	
	public static void botonPulsado() {
		iniciar = true;
	}

	/**Se inicializan las vistas del menu
	 * 
	 */

	@Override
	protected void initGame() {
		
		// levelEndScene = new LevelEndScene();

		// Referencias a los controladores para meter las vistas del menú en laventana
		// del juego
		PortadaController controller;
		ComoJugarController comoController;
		LocalController localController;
		OnlineController onlineController;
		MenuController menuController;
		try {
			controller = new PortadaController();
			controller.getView().setPrefWidth(2000);
			controller.getView().setPrefHeight(1000);
			controller.getView().setCenterShape(true);
			view = new GameView(controller.getView(), 0);
			getGameScene().addGameView(view);

			menuController = new MenuController(controller);
			menuController.getView().setPrefWidth(3500);
			menuController.getView().setPrefHeight(1000);
			menuController.getView().setCenterShape(true);

			comoController = new ComoJugarController(controller);
			comoController.getView().setPrefWidth(2000);
			comoController.getView().setPrefHeight(1000);
			comoController.getView().setCenterShape(true);

			localController = new LocalController(controller);
			localController.getView().setPrefWidth(2000);
			localController.getView().setPrefHeight(1000);
			localController.getView().setCenterShape(true);

			onlineController = new OnlineController(controller);
			onlineController.getView().setPrefWidth(2000);
			onlineController.getView().setPrefHeight(1000);
			onlineController.getView().setCenterShape(true);
			
			//getGameScene().removeGameView(view);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**Se localiza el lugar en el que el jugador colisionar� con la puerta de salida
	 * 
	 */
	private void makeExitDoor() {
		var doorTop = getGameWorld().getSingleton(GameType.DOOR_TOP);
		var doorBot = getGameWorld().getSingleton(GameType.DOOR_BOT);

		doorBot.getComponent(CollidableComponent.class).setValue(true);

		doorTop.getViewComponent().setOpacity(1);
		doorBot.getViewComponent().setOpacity(1);
	}
	/**Se crean las colisiones y los componentes relacionados con las f�sicas
	 * 
	 */

	@Override
	protected void initPhysics() {
		getPhysicsWorld().setGravity(0, 760);

		onCollisionOneTimeOnly(GameType.PLAYER, GameType.EXIT_SIGN, (player, sign) -> {
			var texture = texture("exit_sign.png").brighter();
			texture.setTranslateX(sign.getX() + 9);
			texture.setTranslateY(sign.getY() + 13);

			var gameView = new GameView(texture, 150);

			getGameScene().addGameView(gameView);

			runOnce(() -> getGameScene().removeGameView(gameView), Duration.seconds(1.6));
		});

		onCollisionOneTimeOnly(GameType.PLAYER, GameType.EXIT_TRIGGER, (player, trigger) -> {
			makeExitDoor();
		});

		onCollisionOneTimeOnly(GameType.PLAYER, GameType.DOOR_BOT, (player, door) -> {
			getDisplay().showMessageBox("Se acabó el juego!", () -> {

				// Cierra el juego.
				getGameController().exit();

			});

		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
