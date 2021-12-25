package gui.willhero;

import javafx.scene.Node;

public class MediumHatAxe extends GreenOrc{
    private Axe axe;

    MediumHatAxe(Node orcImg,Axe axe, Game game) {
        super(10, 100, 25, orcImg, game);
        this.axe = axe;
    }
}
