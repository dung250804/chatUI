module com.example.chattin {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;

    requires com.dlsc.formsfx;

    opens com.example.chattin to javafx.fxml;
    exports com.example.chattin;
}