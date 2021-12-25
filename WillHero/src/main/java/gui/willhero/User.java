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
    private ArrayList<Weapons> weapons;
    private Helmet helmetChosen;
    private Weapons curWeapon;
    private ImageView playerHelmet;
    private final Animations animations = new Animations();
    private AnchorPane gamePane;
    private AnchorPane uiPane;
    private Game game;

    Timeline movePlayerHorizontal = new Timeline();
    Timeline movePlayerVertical = new Timeline();

    private double playerDy = 0.5;
    private final double playerDx = 0.5;
    private Node base;

    User(Game game, Node knife, Node sword) {
        ID++;
        this.health = 100;
        this.currentScore = 0;
        this.coinsCollected = 0;
        this.game = game;
        this.isDead = false;
        this.isWinner = false;
        this.isResurrected = false;
        this. weapons = new ArrayList<>();
        weapons.add(new Knives(knife));
        weapons.add(new Sword(sword));


        KeyFrame playerVertical = new KeyFrame(Duration.millis(7), actionEvent -> {
            playerHelmet.setLayoutY(playerHelmet.getLayoutY() + playerDy);

            Node plat = game.checkCollisionIsland(playerHelmet);
            Orc orc = game.checkCollisionOrc(playerHelmet);
            Coin coin = game.checkCollisionCoin(playerHelmet);
            Chest chest = game.checkCollisionChest(playerHelmet);

            if(base == null){
                base = game.getPlatforms().get(0).getNode();
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
                setCoinsCollected(1);
            }

            if(chest != null){
                chest.openIt();
                if(chest instanceof WeaponChest){
                    int weaponNum = ((WeaponChest) chest).generateWeapon();
                    updateWeapon(weaponNum);
                    setCurWeapon(weaponNum);
                    game.updateWeaponUI(weaponNum, curWeapon.getLevel());
                }
                if(chest instanceof CoinChest){
                    setCoinsCollected(((CoinChest) chest).generateCoinCount());
                }
                game.getChests().remove(chest);
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
            Orc orc = game.checkCollisionOrc(playerHelmet);
            Coin coin = game.checkCollisionCoin(playerHelmet);
            Chest chest = game.checkCollisionChest(playerHelmet);

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
                setCoinsCollected(1);
            }
            if(chest != null){
                chest.openIt();
                if(chest instanceof WeaponChest){
                    int weaponNum = ((WeaponChest) chest).generateWeapon();
                    updateWeapon(weaponNum);
                    setCurWeapon(weaponNum);
                    game.updateWeaponUI(weaponNum, curWeapon.getLevel());
                }
                if(chest instanceof CoinChest){
                    setCoinsCollected(((CoinChest) chest).generateCoinCount());
                }
                game.getChests().remove(chest);
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
        game.setCoinCountLabel(coinsCollected);
    }

    public int updateWeapon(int val){
        weapons.get(val).update();
        return weapons.get(val).getLevel();
    }

    public void setCurWeapon(int ind){
        if(curWeapon != null){
            curWeapon.toggle();
        }
        curWeapon = weapons.get(ind);
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