package gui.willhero;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.security.Key;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class LoadingPage implements Initializable {

    private boolean isLoading;

    @FXML
    private Rectangle bar;

    @FXML
    private Button goToStart;

    @FXML
    private ImageView click;

    @FXML
    private Label progress;

    private int l = 0;
    private Timeline loading = new Timeline();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        isLoading = true;
        bar.setLayoutX(-712);

        KeyFrame load = new KeyFrame(Duration.millis(100), actionEvent -> {
            l += 5;
            progress.setText(String.valueOf(l) + " %");
            bar.setLayoutX(bar.getLayoutX() + 36);

        });
        loading.getKeyFrames().add(load);
        loading.setCycleCount(20);
        loading.setOnFinished(actionEvent -> set());
        loading.play();

    }

    public void set(){
        isLoading = false;
        click.setOpacity(1);
    }

    public void setGoToStart() throws IOException {
        if (!isLoading){
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartMenu.fxml")));
            Stage window = (Stage) goToStart.getScene().getWindow();
            window.setTitle("Start Game");
            window.setScene(new Scene(root, 712, 422));
        }
    }




}
