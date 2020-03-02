package dad.swordrunner.juego;


import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.physics.box2d.dynamics.FixtureDef;

import dad.swordrunner.juego.componentes.PlayerComponent;
import javafx.geometry.Point2D;

import static com.almasb.fxgl.dsl.FXGL.*;


public class GameFactory implements EntityFactory {

	/**Inicializa cada componente del archivo .tmx con el tipo "platform" y le aplica las propiedades declaradas
	 * 
	 * @param data
	 * @return propiedades
	 */
    @Spawns("platform")
    public Entity newPlatform(SpawnData data) {
        return entityBuilder()
                .type(GameType.PLATFORM)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

    /**Se aplican las propiedades especificadas para las entidades de tipo "player"
	 *
	 */
    @Spawns("player")
    public Entity newPlayer(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
        physics.addGroundSensor(new HitBox("GROUND_SENSOR", new Point2D(16, 38), BoundingShape.box(6, 8)));

        physics.setFixtureDef(new FixtureDef().friction(0.0f));

        return entityBuilder()
                .type(GameType.PLAYER)
                .from(data)
                .bbox(new HitBox(new Point2D(5,5), BoundingShape.circle(12)))
                .bbox(new HitBox(new Point2D(10,25), BoundingShape.box(10, 17)))
                .with(physics)
                .with(new CollidableComponent(true))
                .with(new IrremovableComponent())
                .with(new PlayerComponent())
                .build();
    }
    
    /**Se crea la hitbox del componente "exitTrigger" con el tamaño especificado a través del archivo .tmx
     * 
     * @param data
     * @return propiedades
     */
    
    @Spawns("exitTrigger")
    public Entity newExitTrigger(SpawnData data) {
        return entityBuilder()
                .type(GameType.EXIT_TRIGGER)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new CollidableComponent(true))
                .build();
    }
    
    /**Se crea la hitbox del componente "exitSign" con el tamaño especificado a través del archivo .tmx
     * 
     * @param data
     * @return propiedades
     */
    
    @Spawns("exitSign")
    public Entity newExit(SpawnData data) {
        return entityBuilder()
                .type(GameType.EXIT_SIGN)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new CollidableComponent(true))
                .build();
    }
    
    /**Se añade el tipo "doorTop" a GameType
     * 
     * @param data
     * @return propiedades
     */
    
    @Spawns("doorTop")
    public Entity newDoorTop(SpawnData data) {
        return entityBuilder()
                .type(GameType.DOOR_TOP)
                .from(data)
                .opacity(0)
                .build();
    }
    
    /**Se crea la hitbox del componente "doorBot" con el tamaño especificado a través del archivo .tmx
     * 
     * @param data
     * @return propiedades
     */

    @Spawns("doorBot")
    public Entity newDoorBot(SpawnData data) {
        return entityBuilder()
                .type(GameType.DOOR_BOT)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .opacity(0)
                .with(new CollidableComponent(false))
                .build();
    }
}
