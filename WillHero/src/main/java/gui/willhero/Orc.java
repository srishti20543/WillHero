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
    private double Orcdy = 0.3;

    private Game game;
    private Node prev;

    Timeline orcGravity = new Timeline();
    Timeline checkAttack = new Timeline();
    Timeline checkDead = new Timeline();

    Orc(int d, int hp, int disp, Node orcImg, Game game){
        this.isDead = false;
        this.damage = d;
        this.health = hp;
        this.displacement = disp;
        this.img = orcImg;
        this.game = game;

        KeyFrame orcG = new KeyFrame(Duration.millis(7), actionEvent -> {
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

            if(prev == null){
                prev = game.getPlatforms().get(0).getNode();
            }

            if(n!= null){
                prev = n;
                Orcdy = -Orcdy;
            }

            if(img.getLayoutY() <= prev.getLayoutY() - 75){
                Orcdy = -Orcdy;
            }
        });

        orcGravity.getKeyFrames().add(orcG);
        orcGravity.setCycleCount(Timeline.INDEFINITE);
        orcGravity.play();

        KeyFrame check = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(getCurPlayer().getCurWeapon()!= null){
                if(getCurPlayer().getCurWeapon().getImg().getBoundsInParent().intersects(this.getNode().getBoundsInParent())){
                    getCurPlayer().getCurWeapon().getImg().setDisable(true);
                    health -= 5;
                    if(health <= 0){
                        isDead = true;
                        checkAttack.stop();
                    }
                    System.out.println(img.getId());
                    System.out.println(this.health);

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

