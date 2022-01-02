package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

    @Serial
    private static final long serialVersionUID = 8;

    private double health;
    private int currentScore;
    private int coinsCollected;
    private boolean isDead;
    private boolean isResurrected;
    private final ArrayList<Weapons> weapons;
    private Helmet helmetChosen;
    private Weapons curWeapon;
    private transient ImageView playerHelmet;
    private final transient Animations animations = new Animations();
    private transient AnchorPane gamePane;
    private transient AnchorPane pausePane;
    private transient AnchorPane uiPane;
    private final transient Game game;
    private boolean canUse = true;

    private final transient Timeline movePlayerHorizontal = new Timeline();
    private final transient Timeline movePlayerVertical = new Timeline();
    private final transient Timeline weaponPosition = new Timeline();
    private final transient Timeline attack = new Timeline();
    private final transient Timeline delay = new Timeline();
    private final transient Timeline dead = new Timeline();
    private transient Timeline boundary = new Timeline();

    private double playerDy = 0.08;
    private final double playerDx = 0.25;
    private transient Node base;
    private double baseY;

    User(Game game, Node knife, Node sword) {
        this.health = 100;
        this.currentScore = 0;
        this.coinsCollected = 0;
        this.game = game;
        this.isDead = false;
        this.isResurrected = false;
        this. weapons = new ArrayList<>();
        weapons.add(new Knives(knife));
        weapons.add(new Sword(sword));


        KeyFrame playerVertical = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(isDead){
                movePlayerVertical.stop();
                dead.play();

            }
            if (!isDead){
                playerHelmet.setLayoutY(playerHelmet.getLayoutY() + playerDy);
                Node plat = game.checkCollisionIsland(playerHelmet);
                Node fallPlat = game.checkCollisionFallingPlatform(playerHelmet);
                Orc orc = game.checkCollisionOrc(playerHelmet);
                Coin coin = game.checkCollisionCoin(playerHelmet);
                Chest chest = game.checkCollisionChest(playerHelmet);

                if(base == null){
                    base = game.getPlatforms().get(0).getNode();
                }

                else if(plat != null){
                    base = plat;
                    baseY = plat.getLayoutY();
                    playerHelmet.setLayoutY(playerHelmet.getLayoutY() - 1);
                    playerDy = -playerDy;
                }
                else if(fallPlat != null){
                    base = fallPlat;
                    baseY = fallPlat.getLayoutY();
                    playerHelmet.setLayoutY(playerHelmet.getLayoutY() - 1);
                    playerDy = -playerDy;
                }

                else if(orc != null){
                    if(orc.getNode().getLayoutY() > playerHelmet.getLayoutY()){
                        if(Math.abs(playerHelmet.getLayoutX() - orc.getNode().getLayoutX()) < 2)
                        playerHelmet.setLayoutY(playerHelmet.getLayoutY() + 1);
                        playerDy = -playerDy;
                        setHealth(1000);
                    }
                    else{
                        base = orc.getNode();
                        baseY = orc.getNode().getLayoutY();
                        playerHelmet.setLayoutY(playerHelmet.getLayoutY() - 1);
                        playerDy = -playerDy;
                        if(curWeapon!=null){
                            if(curWeapon instanceof Sword){
                                curWeapon.use();
                            }
                        }
                    }

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
                        if(curWeapon != null){
                            weaponPosition.play();
                        }
                    }
                    if(chest instanceof CoinChest){
                        int count = ((CoinChest) chest).generateCoinCount();
                        setCoinsCollected(count);
                        game.displayCoinsAdded(count);
                    }
                    game.getChests().remove(chest);

                }

                if(playerHelmet.getLayoutY() <= baseY - 100){
                    playerDy = -playerDy;
                }
            }


        });

        movePlayerVertical.getKeyFrames().add(playerVertical);
        movePlayerVertical.setCycleCount(Timeline.INDEFINITE);

        KeyFrame playerHorizontal = new KeyFrame(Duration.millis(1), actionEvent -> {

            Node bg = game.getBackground();
            Node plat = game.checkCollisionIsland(playerHelmet);
            Orc orc = game.checkCollisionOrc(playerHelmet);
            Coin coin = game.checkCollisionCoin(playerHelmet);
            Chest chest = game.checkCollisionChest(playerHelmet);

            playerHelmet.setLayoutX(playerHelmet.getLayoutX() + playerDx);
            gamePane.setLayoutX(gamePane.getLayoutX() - playerDx);
            uiPane.setLayoutX(uiPane.getLayoutX() + playerDx);
            pausePane.setLayoutX(pausePane.getLayoutX() + playerDx);
            bg.setLayoutX(bg.getLayoutX() + playerDx);


            if(plat != null){
                playerHelmet.setLayoutX(playerHelmet.getLayoutX() - 5);
                movePlayerVertical.play();
            }
            else if(orc != null){
                orc.getNode().setLayoutX(orc.getNode().getLayoutX() + 2);
                orc.getPushed();
                movePlayerVertical.play();
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
                    if(curWeapon != null){
                        weaponPosition.play();
                    }
                }
                if(chest instanceof CoinChest){
                    int count = ((CoinChest) chest).generateCoinCount();
                    setCoinsCollected(count);
                    game.displayCoinsAdded(count);
                }
                game.getChests().remove(chest);
            }

        });

        movePlayerHorizontal.getKeyFrames().add(playerHorizontal);
        movePlayerHorizontal.setCycleCount(300);
        movePlayerVertical.play();

        KeyFrame keep = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(curWeapon != null){
                if(curWeapon instanceof Sword){
                    curWeapon.getImg().setLayoutY(playerHelmet.getLayoutY() - 38);
                    curWeapon.getImg().setLayoutX(playerHelmet.getLayoutX() + 6);
                }
            }
        });

        weaponPosition.getKeyFrames().add(keep);
        weaponPosition.setCycleCount(Timeline.INDEFINITE);
        weaponPosition.play();

        KeyFrame del = new KeyFrame(Duration.seconds(0.4), actionEvent -> {canUse = true;});
        delay.getKeyFrames().add(del);
        delay.setCycleCount(1);

        KeyFrame ded = new KeyFrame(Duration.millis(1), actionEvent -> {
            playerHelmet.setLayoutY(playerHelmet.getLayoutY() + 0.15);
        });
        dead.getKeyFrames().add(ded);
        dead.setCycleCount(Timeline.INDEFINITE);

        KeyFrame boun = new KeyFrame(Duration.millis(1), actionEvent -> {
            if(playerHelmet.getLayoutY()>400){
                System.out.println("Game Over");
                System.exit(0);
            }
        });
        boundary.getKeyFrames().add(boun);
        boundary.setCycleCount(Timeline.INDEFINITE);
        boundary.play();

    }

    public int moveForward(AnchorPane gamePane, AnchorPane UIPane, AnchorPane pausePane){
        if(!isDead){
            if(playerDy < 0){
                playerDy = -playerDy;
            }
            if(curWeapon != null && canUse){
                canUse = false;
                curWeapon.use();
                delay.play();
            }
            this.gamePane = gamePane;
            this.uiPane = UIPane;
            this.pausePane = pausePane;
            movePlayerVertical.pause();
            movePlayerHorizontal.play();
            movePlayerHorizontal.setOnFinished(actionEvent1 -> movePlayerVertical.play());
            currentScore = (int)playerHelmet.getLayoutX()/75;
        }
        return this.currentScore;
    }

    public Weapons getCurWeapon(){
        return this.curWeapon;
    }
    public Node getNode(){
        return this.helmetChosen.getImg();
    }
    public int getCurrentScore(){
        return currentScore;
    }
    public int getCoinsCollected(){
        return coinsCollected;
    }

    public void setHelmet(Helmet helmet){
        helmetChosen = helmet;
        this.playerHelmet = helmet.getImg();
    }
    public void setCurWeapon(int ind){
        if(curWeapon != null){
            curWeapon.toggle();
        }
        curWeapon = weapons.get(ind);
        curWeapon.toggle();
        curWeapon.getImg().setLayoutX(playerHelmet.getLayoutX());
        if(curWeapon instanceof Knives){
            curWeapon.toggle();
        }
    }
    public void setCoinsCollected(int val){
        coinsCollected += val;
        game.setCoinCountLabel(coinsCollected);
    }
    public void setHealth(double hp){
        this.health -= hp;
        setDead();
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

    public int updateWeapon(int val){
        weapons.get(val).update();
        return weapons.get(val).getLevel();
    }
}

