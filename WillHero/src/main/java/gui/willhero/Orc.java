package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

import java.security.Key;

abstract class Orc extends GameObject{

    private int damage;
    private double health;
    private boolean isDead;
    private String color;
    private int displacement;
    private Node img;
    private double Orcdy = 0.5;

    private Game game;
    private Node prev;

    Timeline orcGravity = new Timeline();
    Timeline checkAttack = new Timeline();

    Orc(int d, int hp, int disp, Node orcImg, Game game){
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
                prev = game.getPlatforms().get(0).getNode();
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

        KeyFrame check = new KeyFrame(Duration.millis(1), actionEvent -> {

            if(getCurPlayer().getCurWeapon()!= null){
                if(getCurPlayer().getCurWeapon().getImg().getBoundsInParent().intersects(this.getNode().getBoundsInParent())){
                    this.setHealth(0.1);
                    System.out.println(img.getId());
                    System.out.println(this.health);
                    if(health <= 0){
                        this.img.setDisable(true);
                        this.img.setOpacity(0.0);
                    }
                    GameObject.getCurPlayer().getCurWeapon().getImg().setOpacity(0.0);
                    GameObject.getCurPlayer().getCurWeapon().getImg().setDisable(true);

                }
            }
        });

        checkAttack.getKeyFrames().add(check);
        checkAttack.setCycleCount(Timeline.INDEFINITE);
        checkAttack.play();


    }

    public void setHealth(double val){
        health -= val;
    };
    public void setDead(){


    }
    public abstract void getDead();
    public Node getNode(){
        return this.img;
    }
    public void getPushed(){
        Timeline pushed = new Timeline();
        KeyFrame push = new KeyFrame(Duration.millis(10), actionEvent -> {
            this.getNode().setLayoutX(this.getNode().getLayoutX() + 1);
            if(game.checkCollisionIsland(this.getNode()) != null){
                this.getNode().setLayoutX(this.getNode().getLayoutX() - 2);
            }
        });
        pushed.getKeyFrames().add(push);
        pushed.setCycleCount(50);
        pushed.play();
    }

    public double getHealth(){
        return this.health;
    }
}

