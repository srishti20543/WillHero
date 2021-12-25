package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Game implements Initializable {

    @FXML
    private ImageView penguin;
    @FXML
    private Rectangle r1, r2, r3, r4;
    @FXML
    private Rectangle orc1, orc2;
    @FXML
    private AnchorPane uiPane, gamePane;

    private final ArrayList<Node> platforms = new ArrayList<>();
    private final ArrayList<Orc> orcs = new ArrayList<>();


    private final ArrayList<User> savedGames = new ArrayList<>();
    private final User curPlayer = new User(this);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCurPlayer();
        addPlatforms();
        addOrcs();
    }

    private void addPlatforms(){
        platforms.add(r1);
        platforms.add(r2);
        platforms.add(r3);
        platforms.add(r4);
    }

    private void addOrcs(){
        orcs.add(new GreenOrc(10, 100, 25, orc1, this));
        orcs.add(new GreenOrc(10, 100, 25, orc2, this));
    }


    public void setCurPlayer(){
        Helmet penguinHelmet = new Penguin(penguin);
        curPlayer.setHelmet(penguinHelmet);
    }

    public Node checkCollisionIsland(Node node){
        for (Node platform : platforms) {
            if (node.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                return platform;
            }
        }
        return null;
    }

    public Orc checkColiisionOrc(Node node){
        for(Orc orc : orcs){
            if (node.getBoundsInParent().intersects(orc.getNode().getBoundsInParent())) {
                return orc;
            }
        }
        return null;
    }

    public void movePlayerForward(){

        curPlayer.moveForward(gamePane, uiPane);
    }

    public ArrayList<Node> getPlatforms(){
        return this.platforms;
    }

}
