package gui.willhero;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Game implements Initializable {

    @FXML
    private ImageView penguin, bg;

    @FXML
    private Label coinCount, knifeLevel, swordLevel, coinsAdded;

    @FXML
    private Label score = new Label();

    @FXML
    private ImageView island1, island2, island3, island4, island5, island6, island7, island8, island9, island10,
            island11, island12, island13, island14, island15, island16, island17, island18, island19, island20,
            island21, island22, island23, island24, island25, island26, island27, island28, island29, island30,
            island31, island32, island33, island34, island35, island36, island37, island38, island39, island40,
            island41, island42, island43, island44, island45, island46, island47, island48, island49, island50;

    @FXML
    private Rectangle rec1, rec2, rec3, rec4, rec5, rec6, rec7, rec8, rec9, rec10, rec11, rec12, rec13, rec14, rec15,
            rec16, rec17, rec18, rec19, rec20, rec21, rec22, rec23, rec24, rec25, rec26, rec27, rec28, rec29, rec30,
            rec31, rec32, rec33, rec34, rec35, rec36, rec37, rec38, rec39, rec40, rec41, rec42, rec43, rec44, rec45,
            rec46, rec47, rec48, rec49, rec50;

    @FXML
    private ImageView cloud1, cloud2, cloud3, cloud4, cloud5, cloud6, cloud7, cloud8, cloud9, cloud10, cloud11, cloud12,
            cloud13, cloud14, cloud15, cloud16, cloud17, cloud18, cloud19, cloud20, cloud21, cloud22;

    @FXML
    private ImageView coin1, coin2, coin3, coin4, coin5, coin6, coin7, coin8, coin9, coin10, bigCoin, coin11, coin12,
            coin13, coin14, coin15, coin16, coin17, coin18, coin19, coin20, coin21, coin22, coin23, coin24, coin25,
            coin26, coin27, coin28, coin29, coin30, coin31, coin32, coin33, coin34, coin35, coin36, coin37, coin38,
            coin39, coin40, coin41, coin42, coin43, coin44, coin45, coin46, coin47, coin48, coin49, coin50, coin51,
            coin52, coin53, coin54, coin55, coin56, coin57, coin58, coin59, coin60;

    @FXML
    private ImageView ro1, ro2, ro3, ro4, ro5, ro6, ro7, ro8, ro9, ro10;

    @FXML
    private Rectangle fp1, fp2, fp3, fp4, fp5;

    @FXML
    private ImageView go1, go2, go3, go4, go5;

    @FXML
    private ImageView bossOrc, bossOrcAxe, bossBoundary;

    @FXML
    private ImageView axe1, axe2, axe3, axe4, axe5;
    @FXML
    private ImageView axe1b, axe2b;

    @FXML
    private ImageView wm1, wm2, wm3;

    @FXML
    private ImageView wcc1, wco1, wcc2, wco2, wcc3, wco3;

    @FXML
    private ImageView ccc1, cco1;

    @FXML
    private ImageView swordUI, knifeUI, playerSword, playerKnife;

    @FXML
    private Button selectKnife, selectSword, pauseButton, restart;

    @FXML
    private AnchorPane uiPane, gamePane, pausePane, savedGamePane, List;

    private final Clouds cloud = new Clouds();
    private final LoadSavedGames lsd = new LoadSavedGames();
    private final Windmill windmill = new Windmill();
    private final ArrayList<FloatingIsland> platforms = new ArrayList<>();
    private final ArrayList<Orc> orcs = new ArrayList<>();
    private final ArrayList<Coin> coins = new ArrayList<>();
    private final ArrayList<Chest> chests = new ArrayList<>();
    private final ArrayList<User> savedGames = new ArrayList<>();
    private final ArrayList<Weapons> weaponsForUser = new ArrayList<>();
    private final ArrayList<FallingPlatform> fallingPlatforms = new ArrayList<>();

    private User curPlayer;
    private Animations animations = new Animations();
    private boolean isPauseDisabled = true;
    private boolean isSavedDisabled = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        GameObject.setGame(this);
        setCurPlayer(new User(this, playerKnife, playerSword, gamePane, pausePane, uiPane, savedGamePane, bg, new Penguin(penguin), 148, 248));
        gamePane.setLayoutX(0);
        addPlatforms();
        addFallingPlatform();
        addOrcs();
        addCloud();
        addCoins();
        addWindmill();
        addChest();
        addWeaponsForUser();
        try {
            addPrevGames();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addPlatforms() {
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
        platforms.add(new FloatingIsland(island21, rec21));
        platforms.add(new FloatingIsland(island22, rec22));
        platforms.add(new FloatingIsland(island23, rec23));
        platforms.add(new FloatingIsland(island24, rec24));
        platforms.add(new FloatingIsland(island25, rec25));
        platforms.add(new FloatingIsland(island26, rec26));
        platforms.add(new FloatingIsland(island27, rec27));
        platforms.add(new FloatingIsland(island28, rec28));
        platforms.add(new FloatingIsland(island29, rec29));
        platforms.add(new FloatingIsland(island30, rec30));
        platforms.add(new FloatingIsland(island31, rec31));
        platforms.add(new FloatingIsland(island32, rec32));
        platforms.add(new FloatingIsland(island33, rec33));
        platforms.add(new FloatingIsland(island34, rec34));
        platforms.add(new FloatingIsland(island35, rec35));
        platforms.add(new FloatingIsland(island36, rec36));
        platforms.add(new FloatingIsland(island37, rec37));
        platforms.add(new FloatingIsland(island38, rec38));
        platforms.add(new FloatingIsland(island39, rec39));
        platforms.add(new FloatingIsland(island40, rec40));
        platforms.add(new FloatingIsland(island41, rec41));
        platforms.add(new FloatingIsland(island42, rec42));
        platforms.add(new FloatingIsland(island43, rec43));
        platforms.add(new FloatingIsland(island44, rec44));
        platforms.add(new FloatingIsland(island45, rec45));
        platforms.add(new FloatingIsland(island46, rec46));
        platforms.add(new FloatingIsland(island47, rec47));
        platforms.add(new FloatingIsland(island48, rec48));

    }

    private void addFallingPlatform() {
        fallingPlatforms.add(new FallingPlatform(fp1, fp2, fp3, fp4, fp5));
    }

    private void addOrcs() {
//        orcs.add(new MediumHatAxe(go1, new Axe(axe1, go1, axe1b), this));
        orcs.add(new MediumHatAxe(go2, new Axe(axe2, go2, axe1b), this));
        orcs.add(new MediumHatAxe(go3, new Axe(axe3, go3, axe1b), this));
        orcs.add(new MediumHatAxe(go4, new Axe(axe4, go4, axe1b), this));
        orcs.add(new MediumHatAxe(go5, new Axe(axe5, go5, axe1b), this));

        orcs.add(new BossOrc(go1, new Axe(axe1, go1, axe1b), this));

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

    private void addWeaponsForUser() {
        weaponsForUser.add(new Knives(knifeUI));
        weaponsForUser.add(new Sword(swordUI));
    }

    private void addWindmill() {
        windmill.addWindmills(wm1);
        windmill.addWindmills(wm2);
        windmill.addWindmills(wm3);
    }

    private void addCloud() {
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
        cloud.addClouds(cloud11);
        cloud.addClouds(cloud12);
        cloud.addClouds(cloud13);
        cloud.addClouds(cloud14);
        cloud.addClouds(cloud15);
        cloud.addClouds(cloud16);
        cloud.addClouds(cloud17);
        cloud.addClouds(cloud18);
        cloud.addClouds(cloud19);
        cloud.addClouds(cloud20);
        cloud.addClouds(cloud21);
        cloud.addClouds(cloud22);
    }

    private void addCoins() {
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
        coins.add(new Coin(coin23));
        coins.add(new Coin(coin24));
        coins.add(new Coin(coin25));
        coins.add(new Coin(coin26));
        coins.add(new Coin(coin27));
        coins.add(new Coin(coin28));
        coins.add(new Coin(coin29));
        coins.add(new Coin(coin30));
        coins.add(new Coin(coin31));
        coins.add(new Coin(coin32));
        coins.add(new Coin(coin33));
        coins.add(new Coin(coin34));
        coins.add(new Coin(coin35));
        coins.add(new Coin(coin36));
        coins.add(new Coin(coin37));
        coins.add(new Coin(coin38));
        coins.add(new Coin(coin39));
        coins.add(new Coin(coin40));
        coins.add(new Coin(coin41));
        coins.add(new Coin(coin42));
        coins.add(new Coin(coin43));
        coins.add(new Coin(coin44));
        coins.add(new Coin(coin45));
        coins.add(new Coin(coin46));
        coins.add(new Coin(coin47));
        coins.add(new Coin(coin48));
        coins.add(new Coin(coin49));
        coins.add(new Coin(coin50));
        coins.add(new Coin(coin51));
        coins.add(new Coin(coin52));
        coins.add(new Coin(coin53));
        coins.add(new Coin(coin54));
        coins.add(new Coin(coin55));
        coins.add(new Coin(coin56));
        coins.add(new Coin(coin57));
        coins.add(new Coin(coin58));
    }

    private void addChest() {
        chests.add(new WeaponChest(wcc1, wco1, this));
        chests.add(new WeaponChest(wcc2, wco2, this));
        chests.add(new WeaponChest(wcc3, wco3, this));
        chests.add(new CoinChest(ccc1, cco1, this));

    }

    private void addPrevGames() throws IOException, ClassNotFoundException {
        File savedGames = new File("SavedGames");
        File[] savedFiles = savedGames.listFiles();
        ObjectInputStream in = null;
        User temp = null;
        Image t1_img = new Image("bg.jpg");

        if (savedFiles.length != 0) {
            for (int i = 0; i < savedFiles.length; i++) {
                String filename = "SavedGames\\" + savedFiles[i].getName();
                in = new ObjectInputStream(new FileInputStream(filename));
                temp = (User) in.readObject();
                Label lbl = new Label("hello");
                lbl.setLayoutX(20);
                lbl.setLayoutY((i + 1) * 50);
                lbl.setPrefWidth(450);
                lbl.setPrefHeight(25);
                ImageView t1 = new ImageView();
                t1.setImage(t1_img);
                t1.setFitWidth(450);
                t1.setFitHeight(25);
                t1.setLayoutY((i + 1) * 50);
                t1.setLayoutX(20);
                List.getChildren().add(t1);
                String text = temp.toString();
                lbl.setText("" + (i + 1) + "                           " + text);
                lbl.setFont(new Font("Comic Sans MS", 20));
                lbl.setTextFill(Color.WHITE);
                lbl.addEventHandler(MouseEvent.MOUSE_CLICKED, this::selectImage);
                if(i<10){
                    lbl.setId("0" + String.valueOf(i));
                }
                else{
                    lbl.setId(String.valueOf(i));
                }
                List.getChildren().add(lbl);
            }
        }
    }

    public Node checkCollisionIsland(Node node) {

        for (int i = 0; i < platforms.size(); i++) {
            if (node.getBoundsInParent().intersects(platforms.get(i).getNode().getBoundsInParent())) {
                return platforms.get(i).getNode();
            }
        }
        return null;
    }

    public Node checkCollisionFallingPlatform(Node node) {
        Node temp;
        for (FallingPlatform fallingPlatform : fallingPlatforms) {
            if ((temp = fallingPlatform.checkCollision(node)) != null) {
                return temp;
            }
        }
        return null;
    }

    public Orc checkCollisionOrc(Node node){
        for (Orc orc : orcs) {
            if (node.getBoundsInParent().intersects(orc.getNode().getBoundsInParent())) {
                return orc;
            }
        }
        return null;
    }
    public Coin checkCollisionCoin(Node node){
        for (Coin coin : coins) {
            if (node.getBoundsInParent().intersects(coin.getNode().getBoundsInParent())) {
                return coin;
            }
        }
        return null;
    }
    public Chest checkCollisionChest(Node node) {
        for (Chest chest : chests) {
            if (!chest.getIfopen()) {
                if (node.getBoundsInParent().intersects(chest.getNode().getBoundsInParent())) {
                    return chest;
                }
            }
        }
        return null;
    }
    public void movePlayerForward() {
        setLocationLabel(curPlayer.moveForward());
    }

    public ArrayList<FloatingIsland> getPlatforms() {
        return this.platforms;
    }
    public ArrayList<Chest> getChests() {
        return this.chests;
    }
    public ArrayList<Coin> getCoins() {
        return this.coins;
    }
    public ArrayList<Orc> getOrcs() {
        return this.orcs;
    }
    public ArrayList<Weapons> getWeaponsForUser() {
        return this.weaponsForUser;
    }
    public Node getBackground() {
        return this.bg;
    }
    public AnchorPane getGamePane() {
        return this.gamePane;
    }
    public User getCurPlayer() {
        return curPlayer;
    }

    public void setCurPlayer(User u) {
        System.out.println(u.toString());
        curPlayer = u;
        GameObject.setUser(curPlayer);
        System.out.println(u.toString());
        gamePane.setLayoutX(-curPlayer.getPosX() + 148);
        pausePane.setLayoutX(curPlayer.getPosX() - 148);
        System.out.println(u.toString());
        uiPane.setLayoutX(curPlayer.getPosX() - 148);
        savedGamePane.setLayoutX(curPlayer.getPosX() - 148);
        bg.setLayoutX(curPlayer.getPosX() - 148);
        setCoinCountLabel(curPlayer.getCoinsCollected());
        setLocationLabel(curPlayer.getCurrentScore());

    }

    public void setCoinCountLabel(int val) {
        animations.scaleCoin(bigCoin);
        coinCount.setText(String.valueOf(val));
    }

    public void setLocationLabel(int val) {
        score.setText(String.valueOf(val));
    }

    public void updateWeaponUI(int ind, int level) {
        Weapons temp = weaponsForUser.get(ind);
        if (level == 1) {
            temp.toggle();

        }
        if (temp instanceof Knives) {
            knifeLevel.setText(String.valueOf(level));
            ((Knives) temp).showSelected();
            selectKnife.setDisable(false);
        } else if (temp instanceof Sword) {
            swordLevel.setText(String.valueOf(level));
            ((Sword) temp).showSelected();
            selectSword.setDisable(false);
        }
    }

    public void displayCoinsAdded(int count) {
        coinsAdded.setText("+" + String.valueOf(count));
        animations.fadeLabel(coinsAdded);
    }

    public void setRestart() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayGame.fxml")));
        Stage window = (Stage) restart.getScene().getWindow();
        window.setTitle("Start Game");
        window.setScene(new Scene(root, 712, 422));
    }

    public void setExit() {
        System.exit(0);
    }

    public void setReturnToMainMenu() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartMenu.fxml")));
        Stage window = (Stage) restart.getScene().getWindow();
        window.setTitle("Start Game");
        window.setScene(new Scene(root, 712, 422));
    }

    public void saveGame() throws Exception {
        File savedGames = new File("SavedGames");
        File[] savedFiles = savedGames.listFiles();
        String name = "SavedGames\\game";
        name += savedFiles.length;
        name += ".txt";
        File newGameSaved = new File(name);
        try {
            System.out.println(newGameSaved.createNewFile());
        } catch (IOException e) {
            System.out.println("not possible");
        }
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(name));
            out.writeObject(curPlayer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

        Label lbl = new Label("hello");
        Image t1_img = new Image("bg.jpg");
        lbl.setLayoutX(20);
        lbl.setLayoutY((savedFiles.length + 1) * 50);
        lbl.setPrefWidth(450);
        lbl.setPrefHeight(25);
        ImageView t1 = new ImageView();
        t1.setImage(t1_img);
        t1.setFitWidth(450);
        t1.setFitHeight(25);
        t1.setLayoutY((savedFiles.length + 1) * 50);
        t1.setLayoutX(20);
        List.getChildren().add(t1);
        String text = curPlayer.toString();
        lbl.setText("" + (savedFiles.length + 1) + "                           " + text);
        lbl.setFont(new Font("Comic Sans MS", 20));
        lbl.setTextFill(Color.WHITE);
        lbl.addEventHandler(MouseEvent.MOUSE_CLICKED, this::selectImage);
        if(savedFiles.length<10){
            lbl.setId("0" + String.valueOf(savedFiles.length));
        }
        else{
            lbl.setId(String.valueOf(savedFiles.length));
        }
        List.getChildren().add(lbl);
    }

    public void loadSavedGames() throws IOException {
        toggleSaved();
    }

    public void choseKnife() {
        System.out.println("0");
        curPlayer.setCurWeapon(0);
        ((Knives) weaponsForUser.get(0)).showSelected();
    }
    public void choseSword() {
        System.out.println(1);
        curPlayer.setCurWeapon(1);
        ((Sword) weaponsForUser.get(1)).showSelected();
    }

    public void togglePause() {
        curPlayer.pauseTimelines();
        if (isPauseDisabled) {
            pausePane.setDisable(false);
            pausePane.setOpacity(1.0);
            isPauseDisabled = false;
        } else {
            pausePane.setDisable(true);
            pausePane.setOpacity(0.0);
            isPauseDisabled = true;
        }
    }
    public void toggleSaved() {
        if (isSavedDisabled) {
            savedGamePane.setDisable(false);
            savedGamePane.setOpacity(1.0);
            isSavedDisabled = false;
        } else {
            savedGamePane.setDisable(true);
            savedGamePane.setOpacity(0.0);
            isSavedDisabled = true;
        }
    }

    @FXML
    private void selectImage(MouseEvent event) {
        String source1 = event.getSource().toString(); //yields complete string
        int s = Integer.parseInt(source1.substring(9,11));
        String filename = "SavedGames\\game";
        filename += s;
        filename += ".txt";
        System.out.println(filename);
        try {
            deserialize(filename);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deserialize(String fname) throws IOException, ClassNotFoundException {
        File savedGames = new File("SavedGames");
        File[] savedFiles = savedGames.listFiles();
        ObjectInputStream in = null;
        User temp = null;
        in = new ObjectInputStream(new FileInputStream(fname));
        temp = (User) in.readObject();

        User u = new User(this, playerKnife, playerSword, gamePane, pausePane, uiPane, savedGamePane, bg, new Penguin(penguin), temp.getPosX(), temp.getPosY());
        u.setPosX(temp.getPosX());
        u.setPosY(temp.getPosY());
        u.setCoinsCollected(temp.getCoinsCollected());
        u.setHealth(temp.getHealth());
        u.setScore(temp.getScore());
        toggleSaved();
        togglePause();
        setCurPlayer(u);
    }

}
