package com.example.proyectounibanco.controller;

import static com.example.proyectounibanco.controller.AppController.INSTANCE;
import static com.example.proyectounibanco.util.VentanaUtil.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

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
            mostrarMensajeAlerta("Debe ingresar un correo");
        }
        else if(tfContrasenia1.getText().isEmpty() || tfContrasenia2.getText().isEmpty()){
            mostrarMensajeAlerta("Debe ingresar una contraseña");
        }
        else if(!tfContrasenia1.getText().equals(tfContrasenia2.getText())){
            mostrarMensajeAlerta("Las contraseñas no coinciden");
        }
        else if(!tfCorreo.getText().isEmpty() && !tfContrasenia1.getText().isEmpty()
        && !tfContrasenia2.getText().isEmpty() && tfContrasenia1.getText().equals(tfContrasenia2.getText())){
            INSTANCE.getBanco().getAdministrador().setCorreo(tfCorreo.getText());
            INSTANCE.getBanco().getAdministrador().setContrasenia(tfContrasenia1.getText());
            mostrarMensajeInformacion("","Cuenta creada con éxito");
        }
    }

    @FXML
    void regresar(ActionEvent event) throws IOException {
        cambiarVentana("VentanaLoginAdministrador.fxml","Ingreso Administrador",
                400,250,botonRegresar);
    }

}
