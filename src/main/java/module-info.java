module es.mahoramas.lolpedia {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;
    requires java.sql;

    requires javafx.base;


    opens es.mahoramas.lolpedia to javafx.fxml;
    exports es.mahoramas.lolpedia;
    exports es.mahoramas.lolpedia.controller;
    exports es.mahoramas.lolpedia.model;
    opens es.mahoramas.lolpedia.controller to javafx.fxml;
    opens es.mahoramas.lolpedia.controller.abstractas to javafx.fxml;
}