package dad.swordrunner.juego;

import com.almasb.fxgl.app.*;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.level.Level;
import com.almasb.fxgl.entity.level.tiled.TMXLevelLoader;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.PhysicsComponent;

import dad.swordrunner.ClientModel;
import dad.swordrunner.ComoJugarController;
import dad.swordrunner.LocalController;
import dad.swordrunner.MenuController;
import dad.swordrunner.OnlineController;
import dad.swordrunner.PortadaController;
import dad.swordrunner.juego.componentes.PlayerComponent;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import static com.almasb.fxgl.dsl.FXGL.*;

public class RunnerApp extends GameApplication {
	
	
	
	@Override
	protected void initSettings(GameSettings settings) {
		settings.setWidth(8500);
		settings.setHeight(4000);
		settings.setFullScreenAllowed(true);
		settings.setFullScreenFromStart(true);
	}

	private ClientModel model;
	
	private Entity player;
//	private static boolean iniciar;

	@Override
	protected void initInput() {
		getInput().addAction(new UserAction("Left") {
			@Override
			protected void onAction() {
				player.getComponent(PlayerComponent.class).left();
				model.setA(true);
			}

			@Override
			protected void onActionEnd() {
				player.getComponent(PlayerComponent.class).stop();
				model.setA(false);
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

	@Override
	protected void initGame() {

		//levelEndScene = new LevelEndScene();
		
//		PortadaController controller;
//		ComoJugarController comoController;
//		LocalController localController;
//		OnlineController onlineController;
//		MenuController menuController;
//		try {
//			controller = new PortadaController();
//			controller.getView().setPrefWidth(770);
//			controller.getView().setPrefHeight(480);
//			controller.getView().setCenterShape(true);
//			GameView view = new GameView(controller.getView(), 0);
//			getGameScene().addGameView(view);
//			
//			menuController = new MenuController(controller);
//			menuController.getView().setPrefWidth(770);
//			menuController.getView().setPrefHeight(480);
//			menuController.getView().setCenterShape(true);
//			
//			comoController = new ComoJugarController(controller);
//			comoController.getView().setPrefWidth(770);
//			comoController.getView().setPrefHeight(480);
//			comoController.getView().setCenterShape(true);
//			
//			localController = new LocalController(controller);
//			localController.getView().setPrefWidth(750);
//			localController.getView().setPrefHeight(480);
//			localController.getView().setCenterShape(true);
//			
//			onlineController = new OnlineController(controller);
//			onlineController.getView().setPrefWidth(750);
//			onlineController.getView().setPrefHeight(480);
//			onlineController.getView().setCenterShape(true);
			
			
			

//			if (iniciar == true) { 
				getGameWorld().addEntityFactory(new GameFactory());

				player = null;

				FXGL.setLevelFromMap("escenario.tmx");
				
				player = getGameWorld().spawn("player", 100, 0);
				
				set("player", player);
//			}
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//        System.out.println("0");
//    	
//        getGameWorld().addEntityFactory(new GameFactory());
//
//        player = null;
//        
//        System.out.println("1");
//        
//        FXGL.setLevelFromMap("mapa.tmx");
//
//        System.out.println("2");

		// var levelFile = new File("mapa.tmx");
		// Level level;
//		try {
//			level = new TMXLevelLoader().load(levelFile.toURI().toURL(), getGameWorld());
//			FXGL.getGameWorld().setLevel(level);
//		} catch (MalformedURLException e) {
//
//			e.printStackTrace();
//		}

//        System.out.println("4");
//		
//        player = getGameWorld().spawn("player", 0, 0);
//
//        System.out.println("5");
//        
//        set("player", player);
	}

//	public static void botonPulsado(boolean b) {
//		iniciar = b;
//	}
	
	private void makeExitDoor() {
        var doorTop = getGameWorld().getSingleton(GameType.DOOR_TOP);
        var doorBot = getGameWorld().getSingleton(GameType.DOOR_BOT);

        doorBot.getComponent(CollidableComponent.class).setValue(true);

        doorTop.getViewComponent().setOpacity(1);
        doorBot.getViewComponent().setOpacity(1);
    }

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
				 
				 //Cierra el juego.
				 getGameController().exit();
				 
				 
				//Abrir la ventana principal del juego
				//Abrir la ventana principal del juego
				//Abrir la ventana principal del juego
				 
				//Introducir codigo aqui
				//Introducir codigo aqui
				//Introducir codigo aqui
				//Introducir codigo aqui
				//Introducir codigo aqui
				//Introducir codigo aqui
				 
				 
				 
				 
				 
				 
				 
			 });
//	            levelEndScene.onLevelFinish();

	            // the above runs in its own scene, so fade will wait until
	            // the user exits that scene
	        });
	}

	public static void main(String[] args) {
		launch(args);
	}
}
