package gui.willhero;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class StartMenu implements Initializable {

    @FXML
    private Button settingsButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button LoadSavedSavedGamesButton;

    @FXML
    private Button playButton;

    @FXML
    private ImageView helmet;

    @FXML
    private ImageView island1;
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



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        TranslateTransition jump = new TranslateTransition();
        jump.setDuration(Duration.seconds(1));
        jump.setToY(helmet.getY() - 50);
        jump.setAutoReverse(true);
        jump.setCycleCount(Animation.INDEFINITE);
        jump.setNode(helmet);
        jump.play();

        floating(island1);
        floating(island2);
        floatingUp(island3);
        floatingUp(island4);
        floating(island5);
        floatingUp(island6);
        moveLeft(cloud1);
        moveLeft(cloud2);
        moveLeft(cloud3);

    }

    public void setSettingsButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SettingsMenu.fxml")));
        Stage window = (Stage) settingsButton.getScene().getWindow();
        window.setTitle("Settings");
        window.setScene(new Scene(root, 712, 422));
    }

    public void setExitButton(){
        System.exit(0);
    }

    public void setLoadSavedSavedGamesButton() throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoadSavedGames.fxml")));
        Stage window = (Stage) LoadSavedSavedGamesButton.getScene().getWindow();
        window.setTitle("Saved Games");
        window.setScene(new Scene(root, 712, 422));
    }

    public void setPlayButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayGame.fxml")));
        Stage window = (Stage) playButton.getScene().getWindow();
        window.setTitle("Play !");
        window.setScene(new Scene(root, 712, 422));
    }

    public void floating(ImageView island){
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(5));
        floating.setToY(island.getY() + 10);
        floating.setAutoReverse(true);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(island);
        floating.play();
    }

    public void floatingUp(ImageView island){
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(5));
        floating.setToY(island.getY() - 10);
        floating.setAutoReverse(true);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(island);
        floating.play();
    }

    public void click(ImageView img){
        TranslateTransition click = new TranslateTransition();
        click.setDuration(Duration.seconds(1));
        click.setToY(img.getY() + 5);
        click.setAutoReverse(true);
        click.play();
    }

    public void moveLeft(ImageView cloud){
        TranslateTransition floating = new TranslateTransition();
        floating.setDuration(Duration.seconds(50));
        floating.setToX(cloud.getX() - 1000);
        floating.setCycleCount(Animation.INDEFINITE);
        floating.setNode(cloud);
        floating.play();
    }
}
