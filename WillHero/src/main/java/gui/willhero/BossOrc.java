package gui.willhero;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

import java.util.ArrayList;

public class BossOrc extends RedOrc{

    private static final long serialVersionUID = 411;

    BossOrc(Node orcImg, Game game) {
        super(10, 10000, 10, orcImg, game);

    }
}
