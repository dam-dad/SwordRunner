package dad.swordrunner.juego.componentes;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.image;

public class PlayerComponent extends Component {

    private PhysicsComponent physics;


    private AnimatedTexture texture;

    private AnimationChannel animIdle, animWalk;

    private int jumps = 2;
    
    /**Se le asignan las texturas al componente "PlayerComponent"
     */

    public PlayerComponent() {

        Image image1 = image("quieto.png");
        Image image2 = image("correr.png");

        animIdle = new AnimationChannel(image1, 1, 43, 79, Duration.seconds(1), 0, 0);
        animWalk = new AnimationChannel(image2, 8, 730/8, 76, Duration.seconds(0.6), 0, 7);

        texture = new AnimatedTexture(animIdle);
        texture.loop();
    }

    /**Se crean las propiedades del componente "PlayerComponent"
     * 
     */
    
    @Override
    public void onAdded() {
        entity.getTransformComponent().setScaleOrigin(new Point2D(16, 21));
        entity.getViewComponent().addChild(texture);

        physics.onGroundProperty().addListener((obs, old, isOnGround) -> {
            if (isOnGround) {
                jumps = 2;
            }
        });
    }

    /**Se cambian las texturas dependiendo de la accion realizada por el componente "PlayerComponent
     * "
     */
    @Override
    public void onUpdate(double tpf) {
        if (isMoving()) {
            if (texture.getAnimationChannel() != animWalk) {
                texture.loopAnimationChannel(animWalk);
            }
        } else {
           if (texture.getAnimationChannel() != animIdle) {
                texture.loopAnimationChannel(animIdle);
            }
        }
    }

    /**Se comprueba si el componente "PlayerComponent" se esta moviendo en el eje x
     * 
     * @return boolean
     */
    private boolean isMoving() {
        return physics.isMovingX();
    }

    /**Se desplaza en el eje x negativamente
     * 
     */
    public void left() {
        getEntity().setScaleX(-1);
        physics.setVelocityX(-220);
    }

    /**Se desplaza en el eje x positivamente
     * 
     */
    public void right() {
        getEntity().setScaleX(1);
        physics.setVelocityX(220);
    }

    /**Se queda inmóvil
     * 
     */
    public void stop() {
        physics.setVelocityX(0);
    }

    /**Se desplaza en el eje y de forma ascendente
     * 
     */
    public void jump() {
        if (jumps == 0)
            return;


        physics.setVelocityY(-350);

        jumps--;
    }

    //Permite desplazarse en el eje y de forma ascendente
    public void superJump() {
        physics.setVelocityY(-930);
    }
}
