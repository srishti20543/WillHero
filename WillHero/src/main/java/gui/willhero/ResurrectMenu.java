package gui.willhero;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ResurrectMenu {

    @FXML
    private Button y, n;

    public void yes(){

    }

    public void no(){

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GameOverMenu.fxml")));
            Stage window = (Stage) n.getScene().getWindow();
            window.setTitle("Game Over");
            window.setScene(new Scene(root, 712, 422));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
