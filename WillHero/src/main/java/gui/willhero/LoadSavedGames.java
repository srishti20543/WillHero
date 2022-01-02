package gui.willhero;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoadSavedGames implements Initializable {

    @FXML
    private AnchorPane storeGames;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        storeGames.setLayoutY(storeGames.getLayoutY()-50);

    }

    public void addGame(User curPlayer) throws IOException {


    }

}
