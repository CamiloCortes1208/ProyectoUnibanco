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

public class VentanaCreacionAdministradorController {

    @FXML
    private Button botonRegresar;

    @FXML
    private PasswordField tfContrasenia1;

    @FXML
    private PasswordField tfContrasenia2;

    @FXML
    private TextField tfCorreo;

    @FXML
    void crearCuenta(ActionEvent event) {
        if(tfCorreo.getText().isEmpty()){
            mostrarMensaje("Debe ingresar un correo");
        }
        else if(tfContrasenia1.getText().isEmpty() || tfContrasenia2.getText().isEmpty()){
            mostrarMensaje("Debe ingresar una contraseña");
        }
        else if(!tfContrasenia1.getText().equals(tfContrasenia2.getText())){
            mostrarMensaje("Las contraseñas no coinciden");
        }
        else if(!tfCorreo.getText().isEmpty() && !tfContrasenia1.getText().isEmpty()
        && !tfContrasenia2.getText().isEmpty() && tfContrasenia1.getText().equals(tfContrasenia2.getText())){
            INSTANCE.getBanco().getAdministrador().setCorreo(tfCorreo.getText());
            INSTANCE.getBanco().getAdministrador().setContrasenia(tfContrasenia1.getText());
            mostrarMensaje("Cuenta creada con éxito");
        }
    }

    @FXML
    void regresar(ActionEvent event) throws IOException {
        cambiarVentana("VentanaLoginAdministrador.fxml","UNIBANCO",400,250,botonRegresar);
    }

}
