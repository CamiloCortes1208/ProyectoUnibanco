package com.example.proyectounibanco.controller;

import static com.example.proyectounibanco.controller.AppController.INSTANCE;

import com.example.proyectounibanco.clases.Cliente;
import com.example.proyectounibanco.clases.TIPO_CUENTA;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.IOException;
import java.util.List;

import static com.example.proyectounibanco.util.VentanaUtil.cambiarVentana;

public class VentanaListaClientesController {

    @FXML
    private Button botonRegresar;

    @FXML
    private TableColumn<Cliente, String> colApellidos;

    @FXML
    private TableColumn<Cliente, String> colCedula;

    @FXML
    private TableColumn<Cliente, String> colDireccion;

    @FXML
    private TableColumn<Cliente, String> colEmail;

    @FXML
    private TableColumn<Cliente, String> colNombre;

    @FXML
    private TableColumn<Cliente,String> colNumCuenta;

    @FXML
    private TableColumn<Cliente, Double> colSaldo;

    @FXML
    private TableColumn<Cliente, TIPO_CUENTA> colTipoCuenta;

    @FXML
    private ComboBox<TIPO_CUENTA> comboTipoCuenta;

    @FXML
    private TableView<Cliente> tablaCliente;

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
    public void initialize(){
        llenarTabla(INSTANCE.getBanco().getAdministrador().buscarCliente(null,null,
                null,null,null,null,null));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colNumCuenta.setCellValueFactory(new PropertyValueFactory<>("numCuenta"));
        colSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        colTipoCuenta.setCellValueFactory(new PropertyValueFactory<>("tipoCuenta"));

        comboTipoCuenta.setItems(FXCollections.observableArrayList(TIPO_CUENTA.values()));
    }
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

    private void llenarTabla(List<Cliente> listaClientes){
        tablaCliente.setItems(FXCollections.observableArrayList(listaClientes));
        tablaCliente.refresh();
    }

}

