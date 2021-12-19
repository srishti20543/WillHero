module gui.willhero {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens gui.willhero to javafx.fxml;
    exports gui.willhero;
}