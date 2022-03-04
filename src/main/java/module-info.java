module fr.cefim.demofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens fr.cefim.demofx to javafx.fxml;
    exports fr.cefim.demofx;
    exports fr.cefim.demofx.controllers;
    opens fr.cefim.demofx.controllers to javafx.fxml;
}