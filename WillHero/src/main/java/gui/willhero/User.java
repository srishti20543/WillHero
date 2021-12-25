package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

    private static int ID;
    private static int highScore = 0;
    private int health;
    private int currentScore;
    private int coinsCollected;
    private boolean isDead;
    private boolean isWinner;
    private boolean isResurrected;
    private ArrayList<Weapons> weaponsUnlocked;
    private Helmet helmetChosen;
    private Weapons curWeapon;
    private ImageView playerHelmet;
    private Animations animations = new Animations();

    private Game game;

    Timeline movePlayerHorizontal = new Timeline();
    Timeline movePlayerVertical = new Timeline();

    private double playerDy = 0.5;
    private final double playerDx = 0.5;
    private Node base;

    User(Game game) {
        ID++;
        this.health = 100;
        this.currentScore = 0;
        this.coinsCollected = 0;
        this.game = game;
        this.isDead = false;
        this.isWinner = false;
        this.isResurrected = false;
        this. weaponsUnlocked = new ArrayList<>();
        weaponsUnlocked.add(new Knives());
        weaponsUnlocked.add(new Sword());


        KeyFrame playerVertical = new KeyFrame(Duration.millis(7), actionEvent -> {
            playerHelmet.setLayoutY(playerHelmet.getLayoutY() + playerDy);

            Node plat = game.checkCollisionIsland(playerHelmet);
            Orc orc = game.checkColiisionOrc(playerHelmet);
            Coin coin = game.checkCollsionCoin(playerHelmet);

            if(base == null){
                base = game.getPlatforms().get(0);
            }

            else if(plat != null){
                base = plat;
                playerDy = -playerDy;
            }

            else if(orc != null){
                base = orc.getNode();
                playerDy = -playerDy;
            }
            if(coin != null){
                animations.toggleOpacity((ImageView) coin.getNode());
                game.getCoins().remove(coin);
                this.coinsCollected++;
                game.setCoinCountLabel(coinsCollected);
            }

            if(playerHelmet.getLayoutY() <= base.getLayoutY() - 100){
                playerDy = -playerDy;
            }
        });

        movePlayerVertical.getKeyFrames().add(playerVertical);
        movePlayerVertical.setCycleCount(Timeline.INDEFINITE);

        KeyFrame playerHorizontal = new KeyFrame(Duration.millis(4), actionEvent -> {

            Node bg = game.getBackground();
            Node plat = game.checkCollisionIsland(playerHelmet);
            Orc orc = game.checkColiisionOrc(playerHelmet);
            Coin coin = game.checkCollsionCoin(playerHelmet);

            playerHelmet.setLayoutX(playerHelmet.getLayoutX() + playerDx);
            gamePane.setLayoutX(gamePane.getLayoutX() - playerDx);
            uiPane.setLayoutX(uiPane.getLayoutX() + playerDx);
            bg.setLayoutX(bg.getLayoutX() + playerDx);

            if(plat != null){
                playerHelmet.setLayoutX(playerHelmet.getLayoutX() - 5);
                movePlayerVertical.play();
            }
            else if(orc != null){
                orc.getNode().setLayoutX(orc.getNode().getLayoutX() + 10);
                orc.getPushed();
            }
            if(coin != null){
                animations.toggleOpacity((ImageView) coin.getNode());
                game.getCoins().remove(coin);
                this.coinsCollected++;
                game.setCoinCountLabel(coinsCollected);
            }

        });

        movePlayerHorizontal.getKeyFrames().add(playerHorizontal);
        movePlayerHorizontal.setCycleCount(100);

        movePlayerVertical.play();
    }
    public void setCurrentScore(int score) {
        this.currentScore = score;
        highScore=Math.max(highScore,score);
    }

    public void setWinner(){
        if(currentScore >= 122) {
            this.isWinner = true;
        }
    }

    public void setDead(){
        if(health <= 0) {
            this.isDead = true;
            System.out.println("ded");
            if(isResurrected == false){
                //show resurrection menu
                isResurrected = true;
                //check conditions and set isDead = T/F
            }
            if (isResurrected == true){
                //game over
            }
        }
    }

    public void setHealth(int hp){
        this.health = hp;
        setDead();
    }

    public void setCoinsCollected(int val){
        coinsCollected += val;
    }


    public int updateWeapon(int val){
        weaponsUnlocked.get(val).update();
        return weaponsUnlocked.get(val).getLevel();
    }

    public void setWeaponImage(ImageView knife, ImageView sword){
//        weaponsUnlocked.get(0).addWep(knife);
//        weaponsUnlocked.get(1).addWep(sword);

    }

    public void setCurWeapon(int ind){
        if(curWeapon != null){
            curWeapon.toggle();
        }
        curWeapon = weaponsUnlocked.get(ind);
        curWeapon.toggle();
    }

    public void useCurWeapon(double pos){
        if(curWeapon == null){
            return;
        }
        curWeapon.use();

    }

    public void setHelmet(Helmet helmet){
        helmetChosen = helmet;
        this.playerHelmet = helmet.getImg();
    }

    public Node getNode(){
        return this.helmetChosen.getImg();
    }

    private AnchorPane gamePane;
    private AnchorPane uiPane;

    public int moveForward(AnchorPane gamePane, AnchorPane UIPane){
        if(playerDy < 0){
            playerDy = -playerDy;
        }
        this.gamePane = gamePane;
        this.uiPane = UIPane;
        movePlayerVertical.pause();
        movePlayerHorizontal.play();
        movePlayerHorizontal.setOnFinished(actionEvent1 -> movePlayerVertical.play());
        currentScore++;
        return this.currentScore;
    }
}