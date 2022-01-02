package gui.willhero;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BonusRound implements Initializable {

    @FXML
    private Rectangle islandRec;

    @FXML
    private ImageView islandImg;

    @FXML
    private Rectangle r1, r2, r3, r4, r5;

    @FXML
    private ImageView redOrc, greenOrc;

    @FXML
    private ImageView mainOrc;


    private ArrayList<FloatingIsland> floatingIslands = new ArrayList<>();
    private ArrayList<FallingPlatform> fallingPlatforms = new ArrayList<>();

    private final User curPlayer;
    private final Game game;



    BonusRound(Game game){
        this.game = game;
        curPlayer = game.getCurPlayer();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addPlatforms();
    }

    private void addPlatforms(){
        floatingIslands.add(new FloatingIsland(islandImg, islandRec));
    }


}
