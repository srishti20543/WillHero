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
    private double Orcdy = 0.05;

    private Game game;
    private Node prev;

    Timeline orcGravity = new Timeline();
    Timeline checkAttack = new Timeline();
    Timeline checkDead = new Timeline();
    Timeline follow = new Timeline();

    Orc(int d, int hp, int disp, Node orcImg, Game game){
        this.isDead = false;
        this.damage = d;
        this.health = hp;
        this.displacement = disp;
        this.img = orcImg;
        this.game = game;

        KeyFrame orcG = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(img.getLayoutY() > 400){
                isDead = true;
            }

            img.setLayoutY(img.getLayoutY() + Orcdy);

            Node n = game.checkCollisionIsland(img);
            Node fp = game.checkCollisionFallingPlatform(img);

            if(prev == null){
                prev = game.getPlatforms().get(0).getNode();
            }

            if(n!= null){
                prev = n;
                img.setLayoutY(img.getLayoutY() - 1);
                Orcdy = -Orcdy;
            }

            if(fp != null){
                prev = fp;
                img.setLayoutY(img.getLayoutY() - 1);
                Orcdy = -Orcdy;
            }

            if(img.getLayoutY() <= prev.getLayoutY() - 150){
                Orcdy = -Orcdy;
            }
        });

        orcGravity.getKeyFrames().add(orcG);
        orcGravity.setCycleCount(Timeline.INDEFINITE);
        orcGravity.play();

        KeyFrame check = new KeyFrame(Duration.millis(1), actionEvent -> {
            Weapons wep = getCurPlayer().getCurWeapon();
            if(wep != null){
                if(wep.getImg().getBoundsInParent().intersects(this.getNode().getBoundsInParent())){
                    if(wep instanceof Sword){
                        wep.use();
                    }
                    wep.getImg().setDisable(true);
                    health -= wep.getDamage()*0.5;
                    if(health <= 0){
                        isDead = true;
                        checkAttack.stop();
                    }

                }
            }
        });

        checkAttack.getKeyFrames().add(check);
        checkAttack.setCycleCount(Timeline.INDEFINITE);
        checkAttack.play();

        KeyFrame ded = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(isDead){
                game.getCurPlayer().setCoinsCollected(10);
                game.displayCoinsAdded(10);
                getGame().getOrcs().remove(this);
                getGame().getGamePane().getChildren().remove(this.getNode());
                checkDead.stop();
            }
        });

        checkDead.getKeyFrames().add(ded);
        checkDead.setCycleCount(Timeline.INDEFINITE);
        checkDead.play();

        KeyFrame fol = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(getCurPlayer().getNode().getLayoutX() > img.getLayoutX() + 100){
                follow.setCycleCount(2);
                follow.play();
            }
            if(img.getLayoutX() >= getCurPlayer().getNode().getLayoutX() + 30){
                follow.stop();
            }
            getPushed();

        });

        follow.getKeyFrames().add(fol);
        follow.play();


    }

    public void setHealth(double val){
        health -= val;
    };
    public void getPushed(){
        Timeline pushed = new Timeline();
        KeyFrame push = new KeyFrame(Duration.millis(1), actionEvent -> {
            this.getNode().setLayoutX(this.getNode().getLayoutX() + 0.05);
            if(game.checkCollisionIsland(this.getNode()) != null){
                this.getNode().setLayoutX(this.getNode().getLayoutX() - 2);
            }
        });
        pushed.getKeyFrames().add(push);
        pushed.setCycleCount(100);
        pushed.play();
    }

    public Node getNode(){
        return this.img;
    }

    public double getHealth(){
        return this.health;
    }
}



