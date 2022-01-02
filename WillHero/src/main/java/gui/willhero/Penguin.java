package gui.willhero;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Penguin extends Helmet{

    private transient ImageView penguinImg;
    private static final long serialVersionUID = 71;

    Penguin(ImageView img) {
        super("Penguin");
        this.penguinImg = img;
    }

    @Override
    public ImageView getImg() {
        return this.penguinImg;
    }

}
