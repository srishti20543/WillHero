package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Game implements Initializable {

    @FXML
    private ImageView penguin;

    @FXML
    private Rectangle rec1, rec2, rec3, rec4, rec5, rec6, rec7, rec8, rec9, rec10, rec11, rec12, rec13, rec14, rec15,
            rec16, rec17, rec18, rec19, rec20, rec21, rec22, rec23, rec24, rec25;

    @FXML
    private ImageView cloud1, cloud2, cloud3, cloud4, cloud5, cloud6, cloud7, cloud8, cloud9, cloud10;

    @FXML
    private ImageView coin1, coin2, coin3, coin4, coin5, coin6, coin7, coin8, coin9, coin10,
            coin11, coin12, coin13, coin14, coin15, coin16, coin17, coin18, coin19, coin20,
            coin21, coin22, coin23, coin24, coin25, coin26, coin27, coin28, coin29, coin30,
            coin41, coin42, coin43, coin44, coin45, coin46, coin47, coin48, coin49, coin40;

    @FXML
    private ImageView ro1, ro2, ro3, ro4, ro5, ro6, ro7, ro8, ro9, ro10;

    @FXML
    private ImageView go1, go2, go3, go4, go5;
//    go6, go7,go8, go9, go10;

    @FXML
    private ImageView axe1, axe2, axe3, axe4, axe5;
//    axe6, axe7, axe8, axe9, axe10;

    @FXML
    private ImageView wm1, wm2, wm3;

    @FXML
    private Button selectKnife, selectSword;

    @FXML
    private Rectangle orc1, orc2;
    @FXML
    private AnchorPane uiPane, gamePane;

    private final ArrayList<Node> platforms = new ArrayList<>();
    private final ArrayList<Orc> orcs = new ArrayList<>();
    private final ArrayList<Coin> coins = new ArrayList<>();



    private final ArrayList<User> savedGames = new ArrayList<>();
    private final User curPlayer = new User(this);
    private Clouds cloud = new Clouds();
    private final Windmill windmill = new Windmill();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCurPlayer();
        addPlatforms();
        addOrcs();
        addCloud();
        addCoins();
        addWindmill();
    }

    private void addPlatforms(){
        platforms.add(rec1);
        platforms.add(rec2);
        platforms.add(rec3);
        platforms.add(rec4);
        platforms.add(rec5);
        platforms.add(rec6);
        platforms.add(rec8);
        platforms.add(rec9);
        platforms.add(rec7);
        platforms.add(rec10);
        platforms.add(rec11);
        platforms.add(rec12);
        platforms.add(rec13);
        platforms.add(rec14);
        platforms.add(rec15);
        platforms.add(rec16);
        platforms.add(rec17);
        platforms.add(rec18);
        platforms.add(rec19);
        platforms.add(rec20);
        platforms.add(rec21);
        platforms.add(rec22);
        platforms.add(rec24);
    }

    private void addOrcs(){
        orcs.add(new MediumHatAxe(go1, this));
        orcs.add(new MediumHatAxe(go2, this));
        orcs.add(new MediumHatAxe(go3, this));
        orcs.add(new MediumHatAxe(go4, this));
        orcs.add(new MediumHatAxe(go5, this));

        orcs.add(new ShieldedOrc(ro1, this));
        orcs.add(new ShieldedOrc(ro2, this));
        orcs.add(new ShieldedOrc(ro3, this));
        orcs.add(new ShieldedOrc(ro4, this));
        orcs.add(new ShieldedOrc(ro5, this));
        orcs.add(new ShieldedOrc(ro6, this));
        orcs.add(new ShieldedOrc(ro7, this));
        orcs.add(new ShieldedOrc(ro8, this));
        orcs.add(new ShieldedOrc(ro9, this));
        orcs.add(new ShieldedOrc(ro10, this));
    }

    private void addWindmill(){
        windmill.addWindmills(wm1);
        windmill.addWindmills(wm2);
        windmill.addWindmills(wm3);
    }

    private void addCloud(){
        cloud.addClouds(cloud1);
        cloud.addClouds(cloud2);
        cloud.addClouds(cloud3);
        cloud.addClouds(cloud4);
        cloud.addClouds(cloud5);
        cloud.addClouds(cloud6);
        cloud.addClouds(cloud7);
        cloud.addClouds(cloud8);
        cloud.addClouds(cloud9);
        cloud.addClouds(cloud10);
    }

    private void addCoins(){
        coins.add(new Coin(coin1));
        coins.add(new Coin(coin2));
        coins.add(new Coin(coin3));
        coins.add(new Coin(coin4));
        coins.add(new Coin(coin5));
        coins.add(new Coin(coin6));
        coins.add(new Coin(coin7));
        coins.add(new Coin(coin8));
        coins.add(new Coin(coin9));
        coins.add(new Coin(coin10));
        coins.add(new Coin(coin11));
        coins.add(new Coin(coin12));
        coins.add(new Coin(coin13));
        coins.add(new Coin(coin14));
        coins.add(new Coin(coin15));
        coins.add(new Coin(coin16));
        coins.add(new Coin(coin17));
        coins.add(new Coin(coin18));
        coins.add(new Coin(coin19));
        coins.add(new Coin(coin20));
        coins.add(new Coin(coin21));
        coins.add(new Coin(coin22));

    }


    public void setCurPlayer(){
        Helmet penguinHelmet = new Penguin(penguin);
        curPlayer.setHelmet(penguinHelmet);
    }

    public Node checkCollisionIsland(Node node){
        for (Node platform : platforms) {
            if (node.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                return platform;
            }
        }
        return null;
    }

    public Orc checkColiisionOrc(Node node){
        for(Orc orc : orcs){
            if (node.getBoundsInParent().intersects(orc.getNode().getBoundsInParent())) {
                return orc;
            }
        }
        return null;
    }

    public void movePlayerForward(){

        curPlayer.moveForward(gamePane, uiPane);
    }

    public ArrayList<Node> getPlatforms(){
        return this.platforms;
    }

    public void choseKnife(){
        curPlayer.setCurWeapon(0);
    }

    public void choseSword(){
        curPlayer.setCurWeapon(1);
    }

}
