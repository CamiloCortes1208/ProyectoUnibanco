package com.example.proyectounibanco.controller;

import com.example.proyectounibanco.clases.TIPO_CUENTA;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class VentanaCreacionClienteController {

    @FXML
    private Button botonCrear;

    @FXML
    private Button botonRegresar;

    @FXML
    private ComboBox<TIPO_CUENTA> comboTipoCuenta;

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
    void crearCuenta(ActionEvent event) {

    }

    @FXML
    void regresar(ActionEvent event) {

    }

}
