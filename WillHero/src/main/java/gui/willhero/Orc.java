package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

abstract class Orc extends GameObject{

    private int damage;
    private int health;
    private boolean isDead;
    private String color;
    private int displacement;
    private Node img;
    private double Orcdy = 0.5;

    private PlayGame game;
    private Node prev;

    Timeline orcGravity = new Timeline();


    Orc(int d, int hp, int disp, Node orcImg, PlayGame game){
        this.isDead = false;
        this.damage = d;
        this.health = hp;
        this.displacement = disp;
        this.img = orcImg;
        this.game = game;
        KeyFrame orcG = new KeyFrame(Duration.millis(7), actionEvent -> {
            img.setLayoutY(img.getLayoutY() + Orcdy);

            Node n = game.checkCollisionIsland(img);

            if(prev == null){
                prev = game.getPlatforms().get(0);
            }

            if(n!= null){
                prev = n;
                Orcdy = -Orcdy;
            }

            if(img.getLayoutY() <= prev.getLayoutY() - 100){
                Orcdy = -Orcdy;
            }
        });

        orcGravity.getKeyFrames().add(orcG);
        orcGravity.setCycleCount(Timeline.INDEFINITE);
        orcGravity.play();
    }

    public abstract void setHealth();
    public abstract void setDead();
    public abstract void getDead();
    public Node getNode(){
        return this.img;
    }
    public void getPushed(){
        Timeline pushed = new Timeline();
        KeyFrame push = new KeyFrame(Duration.millis(10), actionEvent -> {
            this.getNode().setLayoutX(this.getNode().getLayoutX() + 1);
        });
        pushed.getKeyFrames().add(push);
        pushed.setCycleCount(50);
        pushed.play();
    }
}

