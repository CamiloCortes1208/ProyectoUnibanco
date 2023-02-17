module com.example.proyectounibanco {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.proyectounibanco.exception;
    opens com.example.proyectounibanco to javafx.fxml;
    exports com.example.proyectounibanco.clases;
    exports com.example.proyectounibanco;
    exports com.example.proyectounibanco.controller;
    opens com.example.proyectounibanco.controller to javafx.fxml;
}