package com.example.proyectounibanco.util;

import com.example.proyectounibanco.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaUtil {
    public static void cambiarVentana(String fxml, String titulo, int ancho, int largo, Button button) throws IOException {
        Parent parent = FXMLLoader.load(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(parent, ancho, largo);
        Stage stage = new Stage();
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.initOwner(button.getScene().getWindow());
        button.getScene().getWindow().hide();
        stage.show();
    }
    public static void mostrarMensajeAlerta(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Error");
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    public static void mostrarMensajeInformacion(String titulo,String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
