package gui.willhero;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameWonMenu {

    @FXML
    private Button mm;

    public void setExit() {
        System.exit(0);
    }

    public void setReturnToMainMenu() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartMenu.fxml")));
        Stage window = (Stage) mm.getScene().getWindow();
        window.setTitle("Start Game");
        window.setScene(new Scene(root, 712, 422));
    }
}
