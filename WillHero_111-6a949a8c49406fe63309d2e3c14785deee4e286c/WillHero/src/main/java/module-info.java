module gui.willhero {
    requires javafx.controls;
    requires javafx.fxml;


    opens gui.willhero to javafx.fxml;
    exports gui.willhero;
}