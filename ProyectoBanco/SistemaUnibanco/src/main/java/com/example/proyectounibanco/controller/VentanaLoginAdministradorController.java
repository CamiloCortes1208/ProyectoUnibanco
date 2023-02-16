package com.example.proyectounibanco.controller;

import static com.example.proyectounibanco.controller.AppController.INSTANCE;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.proyectounibanco.util.VentanaUtil.cambiarVentana;
import static com.example.proyectounibanco.util.VentanaUtil.mostrarMensaje;

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
            mostrarMensaje("Debe ingresar un correo");
        }
        else if(tfContrasenia.getText().isEmpty()){
            mostrarMensaje("Debe ingresar una contraseña");
        }
        else if(!INSTANCE.getBanco().getAdministrador().getContrasenia().equals(tfContrasenia.getText())
        || !INSTANCE.getBanco().getAdministrador().getCorreo().equals(tfCorreo.getText())){
            mostrarMensaje("Correo o contraseña incorrectos");
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
