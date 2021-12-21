package gui.willhero;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.io.SequenceInputStream;
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
    private ImageView helmet;


    @FXML
    private Rectangle rec1, rec2, rec3, rec4, rec5, rec6, rec7, rec8, rec9, rec10, rec11, rec12, rec13, rec14, rec15,
            rec16, rec17, rec18;


//rec19, rec20, rec21, rec22, rec23, rec24, rec25, rec26, rec27, rec28, rec29, rec30, rec31, rec32, rec33, rec34, rec35, rec36, rec37, rec38, rec39, rec40, rec41, rec42, rec43, rec44, rec45, rec46, rec47, rec48, rec49, rec50;

    @FXML
    private ImageView island1, island2, island3, island4, island5, island6, island7, island8, island9, island10, island11, island12, island13, island14, island15, island16, island17, island18, island19, island20;

    @FXML
    private ImageView sword, knife;

    @FXML
    private ImageView cloud1, cloud2, cloud3, cloud4, cloud5, cloud6, cloud7, cloud8, cloud9, cloud10;

    @FXML
    private ImageView WeaponChestClosed;
    @FXML
    private ImageView WeaponChestOpen;

    @FXML
    private ImageView WindmillFans;

    @FXML
    private Label location;

    @FXML
    private ImageView orc1;
    @FXML
    private ImageView orc2;
    @FXML
    private ImageView orcAxe;

    @FXML
    private ImageView bg;

    @FXML
    private ImageView wm1, wm2, wm3;

    @FXML
    private Label coinCount;

    @FXML
    private Point2D playerVelocity = new Point2D(0, 0);


//    private final ArrayList<Node> platforms = new ArrayList<>();
    private int position;
    private boolean isPauseDisabled, isSettingDisabled;
    private final TranslateTransition jump = new TranslateTransition();

    private FloatingIsland floatingIsland = new FloatingIsland();
    private Windmill windmill = new Windmill();
    private Clouds cloud = new Clouds();


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        position = 0;
        isSettingDisabled = true;
        isPauseDisabled =  true;

        addPlatform();
        addWindmill();
        addCloud();

        OrcattackHelmet();
        OrcJump(orc1);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
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

    public void setMoveForward(){
        position++;
        gamePane.setTranslateX(gamePane.getTranslateX() - 75);
        bg.setTranslateX(bg.getTranslateX() + 75);
        location.setText(String.valueOf(position));
        uiPane.setTranslateX(uiPane.getTranslateX() + 75);
        movePlayerX(75);
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

    public void toggleSetting(){
        if(isPauseDisabled){
            if(isSettingDisabled){
                settingPane.setDisable(false);
                settingPane.setOpacity(1);
                isSettingDisabled = false;
            }
            else {
                settingPane.setDisable(true);
                settingPane.setOpacity(0);
                isSettingDisabled = true;
            }
        }

    }




    public void OrcattackHelmet(){
        RotateTransition attack = new RotateTransition();
        attack.setAutoReverse(true);
        attack.setToAngle(-90);
        attack.setCycleCount(Animation.INDEFINITE);
        attack.setNode(orcAxe);
        attack.play();
    }

    public void OrcJump(ImageView orc){
        TranslateTransition jmp = new TranslateTransition();
        jmp.setDuration(Duration.seconds(1.5));
        jmp.setToY(orc.getY() - 20);
        jmp.setAutoReverse(true);
        jmp.setCycleCount(Animation.INDEFINITE);
        jmp.setNode(orc);
        jmp.play();
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

    public void update(){

        if (playerVelocity.getY() < 10) {
            playerVelocity = playerVelocity.add(0, 1);
        }

        movePlayerY((int)playerVelocity.getY());
    }

    private void movePlayerX(int value) {
        boolean movingRight = value > 0;

        for (int i = 0; i < Math.abs(value); i++) {
            if(checkCollisionIsland() == 1){
                helmet.setTranslateX(helmet.getTranslateX() - 10);
            }
            helmet.setTranslateX(helmet.getTranslateX() + (movingRight ? 1 : -1));
        }
    }

    private int checkCollisionIsland(){
        return floatingIsland.onCollision(helmet);
    }

    public void movePlayerY(int value){

        for (int i = 0; i < Math.abs(value); i++) {
            if(checkCollisionIsland() == 1){
                TranslateTransition an = new TranslateTransition();
                an.setNode(helmet);
                an.setDuration(Duration.seconds(1));
                an.setByY(-75);
                an.play();
            }
        }
        helmet.setTranslateY(helmet.getTranslateY() + 1.75);
    }

    public void throwKnife(){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(knife);
        translate.setDuration(Duration.millis(1000));
        translate.setByX(500);
        translate.play();
    }

    public void rotateSword(){
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(sword);
        rotate.setDuration(Duration.millis(500));
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setByAngle(90);
        rotate.play();
    }

}
