package gui.willhero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PauseMenu {

    @FXML
    private AnchorPane root;

    @FXML
    private Button cross;

    @FXML
    private Button settingsButton;

    @FXML
    private Button returnToMainMenu;

    @FXML
    private Button exit;

    @FXML
    private Button LoadSavedSavedGamesButton;

    @FXML
    private Button restart;

    @FXML
    private Button saveGame;

    public void setCross(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayGame.fxml")));
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setTitle("Start Game");
//        window.setScene(new Scene(root, 712, 422));

        AnchorPane save =  FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayGame.fxml")));
        root.getChildren().setAll(save);
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
        Stage window = (Stage) LoadSavedSavedGamesButton.getScene().getWindow();
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

    public void setSettingsButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SettingsFromPause.fxml")));
        Stage window = (Stage) settingsButton.getScene().getWindow();
        window.setTitle("Settings");
        window.setScene(new Scene(root, 712, 422));
    }
}
