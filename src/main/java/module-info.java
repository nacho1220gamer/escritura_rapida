module com.example.escritura_rapida {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.escritura_rapida to javafx.fxml;
    exports com.example.escritura_rapida;
    opens com.example.escritura_rapida.controllers to javafx.fxml;
    exports com.example.escritura_rapida.controllers;
}