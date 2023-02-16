package com.example.proyectounibanco.controller;

import static com.example.proyectounibanco.controller.AppController.INSTANCE;
import static com.example.proyectounibanco.util.VentanaUtil.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class VentanaLoginAdministradorController {

    @FXML
    private Button botonIngresar;

    @FXML
    private Button botonRegistrar;

    @FXML
    private PasswordField tfContrasenia;

    @FXML
    private TextField tfCorreo;

    @FXML
    void ingresar(ActionEvent event) throws IOException {
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
            cambiarVentana("VentanaCreacionCliente.fxml","Administrador",
                    500,350,botonIngresar);
        }
    }

    @FXML
    void registrar(ActionEvent event) throws IOException {
        cambiarVentana("VentanaCreacionAdministrador.fxml","Crea tu cuenta",
                400,250,botonRegistrar);
    }

}
