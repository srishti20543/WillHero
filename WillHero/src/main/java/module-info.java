module gui.willhero {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.desktop;


    opens gui.willhero to javafx.fxml;
    exports gui.willhero;
}