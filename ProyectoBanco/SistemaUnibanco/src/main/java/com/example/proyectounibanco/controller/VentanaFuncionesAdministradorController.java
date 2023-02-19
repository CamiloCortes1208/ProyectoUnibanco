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
    private Button botonTransacciones;

    @FXML
    private Button botonRegresar;

    @FXML
    void regresar(ActionEvent event) throws IOException {
        cambiarVentana("VentanaLoginAdministrador.fxml",
                "UNIBANCO",400,250,botonRegresar);
    }

    @FXML
    void verClientes(ActionEvent event) throws IOException {
        cambiarVentana("VentanaListaClientes.fxml",
                "Clientes",700,500,botonClientes);
    }

    @FXML
    void verTransacciones(ActionEvent event) throws IOException {
        cambiarVentana("VentanaListaTransacciones.fxml",
                "Transacciones",600,460,botonTransacciones);
    }
}

