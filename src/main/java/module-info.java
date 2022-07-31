module com.example.snake_and_ladder {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires javafx.media;

    opens com.example.snake_and_ladder to javafx.fxml;
    exports com.example.snake_and_ladder;
}