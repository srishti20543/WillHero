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
    private transient Node img;
    private double Orcdy = 0.05;
    private static final long serialVersionUID = 4;
    private transient Game game;
    private transient Node prev;

    private transient Timeline orcGravity = new Timeline();
    private transient Timeline checkAttack = new Timeline();
    private transient Timeline checkDead = new Timeline();
    private transient Timeline follow = new Timeline();
    private transient Timeline followP = new Timeline();
    private transient Timeline check = new Timeline();

    Orc(int d, int hp, int disp, Node orcImg, Game game){
        this.isDead = false;
        this.damage = d;
        this.health = hp;
        this.displacement = disp;
        this.img = orcImg;
        this.game = game;


        KeyFrame kf = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(getCurPlayer().getNode().getLayoutX() > this.getNode().getLayoutX()){
                follow.play();
                check.stop();
            }
        });
        check.getKeyFrames().add(kf);
        check.setCycleCount(Timeline.INDEFINITE);
        check.play();

        KeyFrame fol = new KeyFrame(Duration.millis(1), actionEvent -> {
            this.getNode().setLayoutX(this.getNode().getLayoutX() + 0.2);
            if(this.getNode().getLayoutX() >= getCurPlayer().getNode().getLayoutX() + 10){
                followP.stop();
                check.play();
            }
        });

        followP.getKeyFrames().add(fol);
        followP.setCycleCount(Timeline.INDEFINITE);

        KeyFrame orcG = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(img.getLayoutY() > 400){
                isDead = true;
            }

            if(img.getLayoutY() < 300){
                int c = 0;
                if(img.getLayoutX() - getCurPlayer().getNode().getLayoutX() < 60){
                    c = -1;
                    img.setLayoutX(img.getLayoutX() + c*0.25);
                }

                if(getCurPlayer().getNode().getLayoutX() > img.getLayoutX() + 60){
                    c = 1;
                    img.setLayoutX(img.getLayoutX() + c*0.25);
                }

                Node n = game.checkCollisionIsland(img);

                if(n != null){
                    img.setLayoutX(img.getLayoutX() + -1*c);
                }

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



