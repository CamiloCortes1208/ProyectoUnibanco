package com.example.proyectounibanco.controller;
import static com.example.proyectounibanco.util.VentanaUtil.cambiarVentana;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class VentanaInicialController {

    @FXML
    private Button botonAdministrador;

    @FXML
    private Button botonCliente;

    @FXML
    private Label labelBienvenida;

    @FXML
    void ingresarAdministrador(ActionEvent event) throws IOException {
        labelBienvenida.setText("Hola que hace");
        cambiarVentana("VentanaLoginAdministrador.fxml","Administrador",400,250,botonAdministrador);
    }

    @FXML
    void ingresarCliente(ActionEvent event) throws IOException {
        labelBienvenida.setText("Adios que hizo");
        cambiarVentana("VentanaConsulta.fxml","Cliente",300,120,botonCliente);
    }

}
