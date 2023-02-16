package com.example.proyectounibanco.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import static com.example.proyectounibanco.util.VentanaUtil.cambiarVentana;

public class VentanaFuncionesAdministradorController {

    @FXML
    private Button botonClientes;

    @FXML
    private Button botonCuentas;

    @FXML
    private Button botonRegistroCliente;

    @FXML
    private Button botonRegresar;

    @FXML
    private Button botonTransaccion;

    @FXML
    void registrarCliente(ActionEvent event) {

    }

    @FXML
    void registrarTransaccion(ActionEvent event) {

    }

    @FXML
    void regresar(ActionEvent event) throws IOException {
        cambiarVentana("VentanaLoginAdministrador.fxml","Administrador",
                400,250,botonRegresar);
    }

    @FXML
    void verClientes(ActionEvent event) {

    }

    @FXML
    void verCuentas(ActionEvent event) {

    }

}
