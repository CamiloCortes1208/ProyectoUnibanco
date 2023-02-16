package com.example.proyectounibanco.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.proyectounibanco.util.VentanaUtil.cambiarVentana;

public class VentanaListaClientesController {

    @FXML
    private Button botonRegresar;

    @FXML
    private TableColumn<?, ?> colApellidos;

    @FXML
    private TableColumn<?, ?> colCedula;

    @FXML
    private TableColumn<?, ?> colDireccion;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colNumCuenta;

    @FXML
    private TableColumn<?, ?> colSaldo;

    @FXML
    private TableColumn<?, ?> colTipoCuenta;

    @FXML
    private ComboBox<?> comboTipoCuenta;

    @FXML
    private TableView<?> tablaCliente;

    @FXML
    private TextField tfApellidos;

    @FXML
    private TextField tfCedula;

    @FXML
    private TextField tfDireccion;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfNumCuenta;

    @FXML
    private TextField tfSaldo;

    @FXML
    void actualizar(ActionEvent event) {

    }

    @FXML
    void agregar(ActionEvent event) {

    }

    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void eliminar(ActionEvent event) {

    }

    @FXML
    void regresar(ActionEvent event) throws IOException {
        cambiarVentana("VentanaFuncionesAdministrador.fxml",
                "Funciones",350,170,botonRegresar);
    }

}

