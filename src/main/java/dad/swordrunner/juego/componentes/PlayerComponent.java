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

    private boolean isBeingDamaged = false;

    public PlayerComponent() {

        Image image1 = image("quieto.png");
        Image image2 = image("correr.png");

        animIdle = new AnimationChannel(image1, 1, 22, 45, Duration.seconds(1), 0, 0);
        animWalk = new AnimationChannel(image2, 8, 352/8, 38, Duration.seconds(1), 0, 7);

        texture = new AnimatedTexture(animIdle);
        texture.loop();
    }

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

    private boolean isMoving() {
        return physics.isMovingX();
    }

    public void left() {
        if (isBeingDamaged)
            return;

        getEntity().setScaleX(-1);
        physics.setVelocityX(-170);
    }

    public void right() {
        if (isBeingDamaged)
            return;

        getEntity().setScaleX(1);
        physics.setVelocityX(170);
    }

    public void stop() {
        if (isBeingDamaged)
            return;

        physics.setVelocityX(0);
    }

    public void jump() {
        if (isBeingDamaged)
            return;

        if (jumps == 0)
            return;


        physics.setVelocityY(-300);

        jumps--;
    }

    public void superJump() {
        physics.setVelocityY(-930);
    }
}
