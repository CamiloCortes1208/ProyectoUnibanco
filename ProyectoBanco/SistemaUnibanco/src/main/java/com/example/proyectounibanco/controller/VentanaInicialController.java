package com.example.proyectounibanco.controller;

import static com.example.proyectounibanco.util.VentanaUtil.cambiarVentana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class VentanaInicialController {

    @FXML
    private Button botonAdministrador;

    @FXML
    private Button botonCliente;

    @FXML
    void ingresarAdministrador(ActionEvent event) throws IOException {
        cambiarVentana("VentanaLoginAdministrador.fxml","Ingreso Administrador",
                400,250,botonAdministrador);
    }

    @FXML
    void ingresarCliente(ActionEvent event) {
        cambiarVentana("VentanaLoginCliente.fxml","Ingreso Cliente",
                400,250,botonCliente);
    }

}
