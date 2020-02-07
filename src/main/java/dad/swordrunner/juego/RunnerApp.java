package dad.swordrunner.juego;


import com.almasb.fxgl.app.*;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.level.Level;
import com.almasb.fxgl.entity.level.tiled.TMXLevelLoader;
import com.almasb.fxgl.input.UserAction;

import dad.swordrunner.MenuController;
import dad.swordrunner.PortadaController;
import dad.swordrunner.juego.componentes.PlayerComponent;
import javafx.scene.input.KeyCode;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import static com.almasb.fxgl.dsl.FXGL.*;

public class RunnerApp extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1280);
        settings.setHeight(720);
        settings.setFullScreenAllowed(true);
        settings.setFullScreenFromStart(true);
    }

    private Entity player;

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

    @Override
    protected void initGame() {
    	
    	PortadaController controller;
		try {
			controller = new PortadaController();
			controller.getView().setPrefWidth(getGameScene().getWidth());
			controller.getView().setPrefHeight(getGameScene().getHeight());
	    	GameView view = new GameView(controller.getView(), 0);
	    	getGameScene().addGameView(view);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
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
        
        //var levelFile = new File("mapa.tmx");
        //Level level;
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

    @Override
    protected void initPhysics() {
        getPhysicsWorld().setGravity(0, 760);
    }
 

    public static void main(String[] args) {
        launch(args);
    }
}
