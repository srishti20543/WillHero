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
    private AnchorPane gamePane, settingPane;

    @FXML
    private AnchorPane uiPane;

    @FXML
    private AnchorPane pausePane;


    @FXML
    private Button moveForward, backToPause, restart, returnToMainMenu, loadSavedGames ;

    @FXML
    private ImageView helmet;

    @FXML
    private Button resume;

    @FXML
    private Button pause;

    @FXML
    private Rectangle rec1, rec3, rec2;

    @FXML
    private ImageView island1;

    @FXML
    private ImageView sword;

    @FXML
    private ImageView knife;
    @FXML
    private ImageView island2;
    @FXML
    private ImageView island3;
    @FXML
    private ImageView island4;
    @FXML
    private ImageView island5;
    @FXML
    private ImageView island6;

    @FXML
    private ImageView cloud1;
    @FXML
    private ImageView cloud2;
    @FXML
    private ImageView cloud3;

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
    private Label coinCount;

    @FXML
    private Point2D playerVelocity = new Point2D(0, 0);


    private final ArrayList<Node> platforms = new ArrayList<>();
    private int position;
    private boolean isPauseDisabled, isSettingDisabled;
    private final TranslateTransition jump = new TranslateTransition();


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        position = 0;
        isSettingDisabled = true;
        isPauseDisabled =  true;
//        jump.setDuration(Duration.seconds(1));
//        jump.setToY(helmet.getY() - 50);
//        jump.setAutoReverse(true);
//        jump.setCycleCount(Animation.INDEFINITE);
//        jump.setNode(helmet);
//        jump.play();

        floating(island1);
        floating(island2);
        floatingUp(island3);
        floatingUp(orc2);
        floatingUp(orcAxe);
        floating(island5);
        floating(orc1);
        floatingUp(island6);
        moveLeft(cloud1);
        moveLeft(cloud2);
        moveLeft(cloud3);
        floating(WeaponChestClosed);
        floating(WeaponChestOpen);
        platforms.add(rec1);
        platforms.add(rec2);
        platforms.add(rec3);

        OrcattackHelmet();
        OrcJump(orc1);
        fanRotate();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
            }
        };
        timer.start();
    }

    public void setMoveForward(){
//        jump.pause();
        gamePane.setTranslateX(gamePane.getTranslateX() - 75);
        bg.setTranslateX(bg.getTranslateX() + 75);
        position++;
        location.setText(String.valueOf(position));
//        helmet.setTranslateX(helmet.getTranslateX()+50);
        uiPane.setTranslateX(uiPane.getTranslateX() + 75);
        movePlayerX(75);
//        jump.play();
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

    public void floating(ImageView island){
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(10));
        floating.setToY(island.getY() + 10);
        floating.setAutoReverse(true);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(island);
        floating.play();
    }

    public void floatingUp(ImageView island){
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(10));
        floating.setToY(island.getY() - 10);
        floating.setAutoReverse(true);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(island);
        floating.play();
    }

    public void moveLeft(ImageView cloud){
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(150));
        floating.setToX(cloud.getX() - 1000);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(cloud);
        floating.play();
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

    public void fanRotate(){

        RotateTransition rt = new RotateTransition();
        rt.setDuration(Duration.seconds(5));
        rt.setToAngle(360);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setInterpolator(Interpolator.LINEAR);
        rt.setNode(WindmillFans);
        rt.play();
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
            for (Node platform : platforms) {
                if (helmet.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    System.out.println(helmet.getTranslateX() + " " + rec1.getTranslateX());
                    System.out.println(helmet.getTranslateY() + " " + rec1.getTranslateY());
//                    helmet.setTranslateX(helmet.getTranslateX() - 10);
                    return;
                }
            }
            helmet.setTranslateX(helmet.getTranslateX() + (movingRight ? 1 : -1));
        }
    }

    public void movePlayerY(int value){
        boolean movingDown = value > 0;

        for (int i = 0; i < Math.abs(value); i++) {
            for (Node platform : platforms) {
                if (helmet.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    TranslateTransition an = new TranslateTransition();
                    an.setNode(helmet);
                    an.setDuration(Duration.seconds(1));
                    an.setByY(-75);
                    an.play();
                    return;
                }
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
