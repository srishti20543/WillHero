package gui.willhero;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class PlayGame implements Initializable {

    @FXML
    private AnchorPane gamePane, settingPane, uiPane, pausePane;

    @FXML
    private Button moveForward, backToPause, restart, returnToMainMenu, loadSavedGames, resume, pause ;

    @FXML
    private Button selectKnife, selectSword;

    @FXML
    private ImageView helmet;


    @FXML
    private Rectangle rec1, rec2, rec3, rec4, rec5, rec6, rec7, rec8, rec9, rec10, rec11, rec12, rec13, rec14, rec15,
            rec16, rec17, rec18;

    @FXML
    private Rectangle deadByGravity;


//rec19, rec20, rec21, rec22, rec23, rec24, rec25, rec26, rec27, rec28, rec29, rec30, rec31, rec32, rec33, rec34, rec35, rec36, rec37, rec38, rec39, rec40, rec41, rec42, rec43, rec44, rec45, rec46, rec47, rec48, rec49, rec50;

    @FXML
    private ImageView island1, island2, island3, island4, island5, island6, island7, island8, island9, island10, island11, island12, island13, island14, island15, island16, island17, island18, island19, island20;

    @FXML
    private ImageView swordUI, knifeUI, playerSword, playerKnife;

    @FXML
    private ImageView cloud1, cloud2, cloud3, cloud4, cloud5, cloud6, cloud7, cloud8, cloud9, cloud10;

    @FXML
    private ImageView coin1, coin2, coin3, coin4, coin5, coin6, coin7, coin8, coin9, coin10;

    @FXML
    private ImageView ro1, ro2, ro3, ro4, ro5, ro6, ro7, ro8, ro9, ro10;

    @FXML
    private ImageView go1, go2, go3, go4, go5;
//    go6, go7,go8, go9, go10;

    @FXML
    private ImageView axe1, axe2, axe3, axe4, axe5;
//    axe6, axe7, axe8, axe9, axe10;

    @FXML
    private ImageView wcc1, wco1, wcc2, wco2, wcc3, wco3;


    @FXML
    private ImageView WindmillFans;

    @FXML
    private ImageView bg;

    @FXML
    private ImageView wm1, wm2, wm3;

    @FXML
    private Label coinCount, location, knifeLevel, swordLevel;


    @FXML
    private Point2D playerVelocity = new Point2D(0, 0);

    private int position;
    private int coinCnt;
    private boolean isPauseDisabled, isSettingDisabled;
//    private final TranslateTransition jump = new TranslateTransition();

    private final FloatingIsland floatingIsland = new FloatingIsland();
    private final Windmill windmill = new Windmill();
    private final Clouds cloud = new Clouds();
    private final Coin coin = new Coin();
    private final Weapons axe = new Axe();
    private final Orc gOrc = new MediumHatAxe();
    private final Orc rOrc = new ShieldedOrc();
    private final Chest weaponChest = new WeaponChest();
    private final Chest coinChest = new CoinChest();
    private final Knives knife = new Knives();
    private final Sword sword = new Sword();


    private ArrayList<User> savedGames = new ArrayList<>();
    private User curPlayer = new User(helmet);
    private int highscore = 0;




    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        position = 0;
        coinCnt = 0;
        isSettingDisabled = true;
        isPauseDisabled =  true;

        addPlatform();
        addWindmill();
        addCloud();
        addCoins();
        addGreenOrc();
        addRedOrc();
        addAxe();
        addWeaponChest();

        curPlayer.setWeaponImage(playerKnife, playerSword);
        knife.addWep(knifeUI);
        sword.addWep(swordUI);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
                movePlayerWeapons();
            }
        };
        timer.start();
    }


    private void addPlatform(){
        floatingIsland.addPlatform(island1, rec1);
        floatingIsland.addPlatform(island2, rec2);
        floatingIsland.addPlatform(island3, rec3);
        floatingIsland.addPlatform(island4, rec4);
        floatingIsland.addPlatform(island5, rec5);
        floatingIsland.addPlatform(island6, rec6);
        floatingIsland.addPlatform(island7, rec7);
        floatingIsland.addPlatform(island8, rec8);
        floatingIsland.addPlatform(island9, rec9);
        floatingIsland.addPlatform(island10, rec10);
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
        coin.addCoins(coin1);
        coin.addCoins(coin2);
        coin.addCoins(coin3);
        coin.addCoins(coin4);
        coin.addCoins(coin5);
        coin.addCoins(coin6);
        coin.addCoins(coin7);
        coin.addCoins(coin8);
        coin.addCoins(coin9);
        coin.addCoins(coin10);
    }

    private void addRedOrc(){
        rOrc.addOrc(ro1);
        rOrc.addOrc(ro2);
        rOrc.addOrc(ro3);
        rOrc.addOrc(ro4);
        rOrc.addOrc(ro5);
        rOrc.addOrc(ro6);
        rOrc.addOrc(ro7);
        rOrc.addOrc(ro8);
        rOrc.addOrc(ro9);
        rOrc.addOrc(ro10);
    }

    private void addGreenOrc() {
        gOrc.addOrc(go1);
        gOrc.addOrc(go2);
        gOrc.addOrc(go3);
        gOrc.addOrc(go4);
        gOrc.addOrc(go5);
//        gOrc.addOrc(go6);
//        gOrc.addOrc(go7);
//        gOrc.addOrc(go8);
//        gOrc.addOrc(go9);
//        gOrc.addOrc(go10);
    }

    private void addAxe(){

        axe.addWep(axe1);
        axe.addWep(axe2);
        axe.addWep(axe3);
        axe.addWep(axe4);
        axe.addWep(axe5);
//        axe.addWep(axe6);
//        axe.addWep(axe7);
//        axe.addWep(axe8);
//        axe.addWep(axe9);
//        axe.addWep(axe10);

    }

    private void addWeaponChest() {
        weaponChest.addChest(wcc1, wco1);
        weaponChest.addChest(wcc2, wco2);
        weaponChest.addChest(wcc3, wco3);
    }

    public void update(){

        if (playerVelocity.getY() < 10) {
            playerVelocity = playerVelocity.add(0, 1);
        }

        movePlayerY((int)playerVelocity.getY());
    }

    public void movePlayerWeapons(){
        playerSword.setTranslateX(helmet.getX());

        playerSword.setTranslateY(helmet.getTranslateY());
        playerKnife.setTranslateY(helmet.getTranslateY());
    }

    public void setMoveForward(){
        position++;
        gamePane.setTranslateX(gamePane.getTranslateX() - 75);
        bg.setTranslateX(bg.getTranslateX() + 75);
        location.setText(String.valueOf(position));
        uiPane.setTranslateX(uiPane.getTranslateX() + 75);
        movePlayerX(75);
        curPlayer.setCurrentScore(position);
        curPlayer.useCurWeapon(helmet.getX());
    }

    private void movePlayerX(int value) {

        int var;

        for (int i = 0; i < Math.abs(value); i++) {
            if(checkCollisionIsland() == 1){
                helmet.setTranslateX(helmet.getTranslateX() - 10);
            }
            else if(checkCollisionWithBorder() == 1){
                curPlayer.setHealth(0);
            }
            else if(checkCollisionCoin() == 1){
                coinCnt++;
                coinCount.setText(String.valueOf(coinCnt));
                curPlayer.setCoinsCollected(1);
            }
            else if ((var = checkCollisionWeaponChest()) == 1){
                int lvl = curPlayer.updateWeapon(var);
                if(var == 0){
                    knifeLevel.setText(String.valueOf(lvl));
                    if (lvl == 1){
                        knife.toggle();
                        selectKnife.setDisable(false);
                    }
                    choseKnife();
                }
                else{
                    swordLevel.setText(String.valueOf(lvl));
                    if (lvl == 1){
                        sword.toggle();
                        selectSword.setDisable(false);
                    }
                    choseSword();
                }

            }
            else if ((var = checkCollisionCoinChest())!= -1){
                coinCnt += var;
                coinCount.setText(String.valueOf(coinCnt));
                curPlayer.setCoinsCollected(var);
            }

            helmet.setTranslateX(helmet.getTranslateX() + 1);
        }
    }

    public void movePlayerY(int value){

        int var;

        for (int i = 0; i < Math.abs(value); i++) {
            if(checkCollisionIsland() == 1){
                TranslateTransition an = new TranslateTransition();
                an.setNode(helmet);
                an.setDuration(Duration.seconds(1));
                an.setByY(-75);
                an.play();
            }
            else if(checkCollisionWithBorder() == 1){
                curPlayer.setHealth(0);
            }
            else if(checkCollisionCoin() == 1){
                coinCnt++;
                coinCount.setText(String.valueOf(coinCnt));
                curPlayer.setCoinsCollected(1);
            }
            else if ((var = checkCollisionWeaponChest()) != -1){
                int lvl = curPlayer.updateWeapon(var);
                if(var == 0){
                    knifeLevel.setText(String.valueOf(lvl));
                    if (lvl == 1){
                        knife.toggle();
                        selectKnife.setDisable(false);
                    }
                    choseKnife();
                }
                else{
                    swordLevel.setText(String.valueOf(lvl));
                    if (lvl == 1){
                        sword.toggle();
                        selectSword.setDisable(false);
                    }
                    choseSword();
                }
            }
            else if ((var = checkCollisionCoinChest())!= -1){
                coinCnt += var;
                coinCount.setText(String.valueOf(coinCnt));
                curPlayer.setCoinsCollected(var);
            }
        }
        helmet.setTranslateY(helmet.getTranslateY() + 1.75);
    }

    private int checkCollisionIsland(){
        return floatingIsland.onCollision(helmet);
    }

    private int checkCollisionCoin(){
        return coin.onCollision(helmet);
    }

    private int checkCollisionWeaponChest(){
        return weaponChest.onCollision(helmet);
    }

    private int checkCollisionCoinChest(){
        return coinChest.onCollision(helmet);
    }

    private int checkCollisionWithBorder(){
        if (helmet.getBoundsInParent().intersects(deadByGravity.getBoundsInParent())) {
            return 1;
        }
        return -1;
    }





    public void choseKnife(){
        curPlayer.setCurWeapon(0);
    }

    public void choseSword(){
        curPlayer.setCurWeapon(1);
    }

    public void setReturnToMainMenu() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartMenu.fxml")));
        Stage window = (Stage) returnToMainMenu.getScene().getWindow();
        window.setTitle("Start Game");
        window.setScene(new Scene(root, 712, 422));
    }

    public void setExit(){
        System.exit(0);
    }

    public void setLoadSavedSavedGamesButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoadSavedGamesFromPause.fxml")));
        Stage window = (Stage) loadSavedGames.getScene().getWindow();
        window.setTitle("Saved Games");
        window.setScene(new Scene(root, 712, 422));
    }

    public void setRestart() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayGame.fxml")));
        Stage window = (Stage) restart.getScene().getWindow();
        window.setTitle("Start Game");
        window.setScene(new Scene(root, 712, 422));
    }

    public void setSaveGame(){
        //functionality
    }

    public void toggleSetting() {
        if (isPauseDisabled) {
            if (isSettingDisabled) {
                settingPane.setDisable(false);
                settingPane.setOpacity(1);
                isSettingDisabled = false;
            } else {
                settingPane.setDisable(true);
                settingPane.setOpacity(0);
                isSettingDisabled = true;
            }
        }

    }

    public void togglePause(){
        if(isPauseDisabled){
            pausePane.setDisable(false);
            pausePane.setOpacity(1);
            isPauseDisabled = false;
        }
        else {
            pausePane.setDisable(true);
            pausePane.setOpacity(0);
            isPauseDisabled = true;
        }
    }

}
