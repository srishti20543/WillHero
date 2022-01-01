package gui.willhero;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Game implements Initializable {

    @FXML
    private ImageView penguin, bg;

    @FXML
    private Label coinCount, knifeLevel, swordLevel;
    @FXML
    private Label score = new Label();

    @FXML
    private ImageView island1, island2, island3, island4, island5, island6, island7, island8, island9, island10,
            island11, island12, island13, island14, island15, island16, island17, island18, island19, island20,
            island21, island22, island23, island24, island25;

    @FXML
    private Rectangle rec1, rec2, rec3, rec4, rec5, rec6, rec7, rec8, rec9, rec10, rec11, rec12, rec13, rec14, rec15,
            rec16, rec17, rec18, rec19, rec20, rec21, rec22, rec23, rec24, rec25;

    @FXML
    private ImageView cloud1, cloud2, cloud3, cloud4, cloud5, cloud6, cloud7, cloud8, cloud9, cloud10;

    @FXML
    private ImageView coin1, coin2, coin3, coin4, coin5, coin6, coin7, coin8, coin9, coin10;

    @FXML
    private ImageView ro1, ro2, ro3, ro4, ro5, ro6, ro7, ro8, ro9, ro10;

    @FXML
    private ImageView go1, go2, go3, go4, go5;

    @FXML
    private ImageView axe1, axe2, axe3, axe4, axe5;

    @FXML
    private ImageView wm1, wm2, wm3;

    @FXML
    private ImageView wcc1, wco1, wcc2, wco2, wcc3, wco3;

    @FXML
    private ImageView swordUI, knifeUI, playerSword, playerKnife;

    @FXML
    private Button selectKnife, selectSword;

    @FXML
    private AnchorPane uiPane, gamePane;

    private final Clouds cloud = new Clouds();
    private final Windmill windmill = new Windmill();
    private final ArrayList<FloatingIsland> platforms = new ArrayList<>();
    private final ArrayList<Orc> orcs = new ArrayList<>();
    private final ArrayList<Coin> coins = new ArrayList<>();
    private final ArrayList<Chest> chests = new ArrayList<>();
    private final ArrayList<User> savedGames = new ArrayList<>();
    private final ArrayList<Weapons> weaponsForUser = new ArrayList<>();

    private User curPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        curPlayer = new User(this, playerKnife, playerSword);
        setCurPlayer();
        addPlatforms();
        addOrcs();
        addCloud();
        addCoins();
        addWindmill();
        addChest();
        addWeaponsForUser();
    }

    private void addPlatforms(){
        platforms.add(new FloatingIsland(island1, rec1));
        platforms.add(new FloatingIsland(island2, rec2));
        platforms.add(new FloatingIsland(island3, rec3));
        platforms.add(new FloatingIsland(island4, rec4));
        platforms.add(new FloatingIsland(island5, rec5));
        platforms.add(new FloatingIsland(island6, rec6));
        platforms.add(new FloatingIsland(island7, rec7));
        platforms.add(new FloatingIsland(island8, rec8));
        platforms.add(new FloatingIsland(island9, rec9));
        platforms.add(new FloatingIsland(island10, rec10));
        platforms.add(new FloatingIsland(island11, rec11));
        platforms.add(new FloatingIsland(island12, rec12));
        platforms.add(new FloatingIsland(island13, rec13));
        platforms.add(new FloatingIsland(island14, rec14));
        platforms.add(new FloatingIsland(island15, rec15));
        platforms.add(new FloatingIsland(island16, rec16));
        platforms.add(new FloatingIsland(island17, rec17));
        platforms.add(new FloatingIsland(island18, rec18));
        platforms.add(new FloatingIsland(island19, rec19));
        platforms.add(new FloatingIsland(island20, rec20));
        platforms.add(new FloatingIsland(island21, rec21));
        platforms.add(new FloatingIsland(island22, rec22));
        platforms.add(new FloatingIsland(island23, rec23));
        platforms.add(new FloatingIsland(island24, rec24));
        platforms.add(new FloatingIsland(island25, rec25));
    }

    private void addOrcs(){
        orcs.add(new MediumHatAxe(go1, new Axe(axe1, go1), this));
        orcs.add(new MediumHatAxe(go2, new Axe(axe2, go2), this));
        orcs.add(new MediumHatAxe(go3, new Axe(axe3, go3), this));
        orcs.add(new MediumHatAxe(go4, new Axe(axe4, go4), this));
        orcs.add(new MediumHatAxe(go5, new Axe(axe5, go5), this));

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

    private void addWeaponsForUser(){
        weaponsForUser.add(new Knives(knifeUI));
        weaponsForUser.add(new Sword(swordUI));
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

    }

    private void addChest() {
        chests.add(new WeaponChest(wcc1, wco1, this));
        chests.add(new WeaponChest(wcc2, wco2, this));
        chests.add(new WeaponChest(wcc3, wco3, this));
    }

    public void setCurPlayer(){
        Helmet penguinHelmet = new Penguin(penguin);
        curPlayer.setHelmet(penguinHelmet);
    }

    public Node checkCollisionIsland(Node node){

        for(int i = 0; i<platforms.size(); i++){
            if (node.getBoundsInParent().intersects(platforms.get(i).getNode().getBoundsInParent())) {
                return platforms.get(i).getNode();
            }
        }
        return null;
    }

    public Orc checkCollisionOrc(Node node){
        for(Orc orc : orcs){
            if (node.getBoundsInParent().intersects(orc.getNode().getBoundsInParent())) {
                return orc;
            }
        }
        return null;
    }

    public Coin checkCollisionCoin(Node node){
        for(Coin coin : coins){
            if (node.getBoundsInParent().intersects(coin.getNode().getBoundsInParent())) {
                return coin;
            }
        }
        return null;
    }

    public Chest checkCollisionChest(Node node){
        for(Chest chest : chests){
            if(!chest.getIfopen()){
                if (node.getBoundsInParent().intersects(chest.getNode().getBoundsInParent())) {
                    return chest;
                }
            }
        }
        return null;
    }



    public void movePlayerForward(){
        setLocationLabel(curPlayer.moveForward(gamePane, uiPane));
    }

    public ArrayList<FloatingIsland> getPlatforms(){
        return this.platforms;
    }
    public ArrayList<Chest> getChests(){
        return this.chests;
    }
    public ArrayList<Coin> getCoins(){
        return this.coins;
    }
    public ArrayList<Weapons> getWeaponsForUser(){
        return this.weaponsForUser;
    }
    public Node getBackground(){
        return this.bg;
    }

    public void setCoinCountLabel(int val){
        coinCount.setText(String.valueOf(val));
    }
    public void setLocationLabel(int val){
        score.setText(String.valueOf(val));
    }
    public void updateWeaponUI(int ind, int level){
        Weapons temp = weaponsForUser.get(ind);
        if(level == 1){
            temp.toggle();

        }
        if(temp instanceof Knives){
            knifeLevel.setText(String.valueOf(level));
            ((Knives) temp).showSelected();
            selectKnife.setDisable(false);
        }
        else if(temp instanceof Sword){
            swordLevel.setText(String.valueOf(level));
            ((Sword) temp).showSelected();
            selectSword.setDisable(false);
        }
    }

    public void choseKnife(){
        System.out.println("0");
        curPlayer.setCurWeapon(0);
        ((Knives)weaponsForUser.get(0)).showSelected();
    }
    public void choseSword(){
        System.out.println(1);
        curPlayer.setCurWeapon(1);
        ((Sword)weaponsForUser.get(1)).showSelected();
    }

}
