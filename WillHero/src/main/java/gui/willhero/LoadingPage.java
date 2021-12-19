package gui.willhero;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        isLoading = true;

        bar.setLayoutX(306);
        bar.setLayoutY(327);
        bar.setHeight(10);
        bar.setWidth(20);
        bar.setFill(Color.DODGERBLUE);

        ScaleTransition load = new ScaleTransition(Duration.seconds(2), bar);
        load.setToX(50);
        load.setOnFinished(event -> set());
        load.play();

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
