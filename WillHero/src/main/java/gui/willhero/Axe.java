package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Axe extends Weapons{

    private Node axe;
    private int level;
    private Node orcNode;

    private Timeline staywOrc = new Timeline();

    Axe(Node axe, Node orc){
        super("Axe", 10);
        level = 1;
        this.axe = axe;
        this.orcNode = orc;

        KeyFrame attach = new KeyFrame(Duration.millis(1), actionEvent -> {
            axe.setLayoutX(orcNode.getLayoutX() + 11);
            axe.setLayoutY(orcNode.getLayoutY() - 10);
        });
        staywOrc.getKeyFrames().add(attach);
        staywOrc.setCycleCount(Timeline.INDEFINITE);
        staywOrc.play();

    }

    @Override
    public void use(User user) {
        return;
    }

    @Override
    public void toggle() {

    }

    @Override
    public Node getImg() {
        return axe;
    }

    @Override
    public Node onCollision(ImageView helmet) {
        return null;
    }
}
