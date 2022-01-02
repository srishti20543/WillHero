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

        File savedGames = new File("SavedGames");
        File[] savedFiles = savedGames.listFiles();
        String name = "SavedGames\\game";
        name += savedFiles.length;
        name += ".txt";
        File newGameSaved = new File(name);
        try {
            System.out.println(newGameSaved.createNewFile());
        }
        catch (IOException e){
            System.out.println("not possible");
        }
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(name));
            out.writeObject(curPlayer);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(out!= null){
                out.close();
            }
        }

        hello(curPlayer, savedFiles);


    }

    public void hello(User curPlayer, File[] savedFiles){
        Label lbl = new Label("hello");
        lbl.setLayoutX(180);
        lbl.setLayoutY((savedFiles.length +1)*100);
        lbl.setPrefWidth(100);
        lbl.setPrefHeight(100);
        String Text = curPlayer.toString();
        System.out.println(Text);
        lbl.setText("hi");
        lbl.setTextFill(Color.RED);
        storeGames.getChildren().add(lbl);
    }

}
