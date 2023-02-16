package com.example.proyectounibanco.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.proyectounibanco.controller.AppController.INSTANCE;
import static com.example.proyectounibanco.util.VentanaUtil.*;

public class VentanaLoginClienteController {

    @FXML
    private Button botonIngresar;

    @FXML
    private Button botonRegresar;

    @FXML
    private PasswordField tfContrasenia;

    @FXML
    private TextField tfCorreo;

    @FXML
    void ingresar(ActionEvent event) {
        if(tfCorreo.getText().isEmpty()){
            mostrarMensajeAlerta("Debe ingresar un correo");
        }
        else if(tfContrasenia.getText().isEmpty()){
            mostrarMensajeAlerta("Debe ingresar una contraseña");
        }
        else if(!INSTANCE.getBanco().getAdministrador().getContrasenia().equals(tfContrasenia.getText())
                || !INSTANCE.getBanco().getAdministrador().getCorreo().equals(tfCorreo.getText())){
            mostrarMensajeAlerta("Correo o contraseña incorrectos");
        }
        else if(INSTANCE.getBanco().getAdministrador().getCorreo().equals(tfCorreo.getText()) &&
                INSTANCE.getBanco().getAdministrador().getContrasenia().equals(tfContrasenia.getText())){
            mostrarMensajeInformacion("Ingreso","Ha ingresado exitosamente");
        }
    }

    @FXML
    void regresar(ActionEvent event) throws IOException {
        cambiarVentana("VentanaInicial.fxml","UNIBANCO",
                310,130,botonRegresar);
    }

}
