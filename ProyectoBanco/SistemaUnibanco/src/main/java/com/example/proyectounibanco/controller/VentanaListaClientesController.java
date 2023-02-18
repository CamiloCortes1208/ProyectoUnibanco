package com.example.proyectounibanco.controller;

import static com.example.proyectounibanco.controller.AppController.INSTANCE;
import static com.example.proyectounibanco.util.VentanaUtil.*;

import com.example.proyectounibanco.clases.Cliente;
import com.example.proyectounibanco.clases.TIPO_CUENTA;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.IOException;
import java.util.List;

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
        llenarTabla(INSTANCE.getBanco().getListaClientes());
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tablaCliente.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));

        comboTipoCuenta.setItems(FXCollections.observableArrayList(TIPO_CUENTA.values()));
    }

    private void llenarCampos(Cliente cliente) {
        if (cliente != null) {
            tfNombre.setText(cliente.getNombre());
            tfApellidos.setText(cliente.getApellidos());
            tfCedula.setText(cliente.getCedula());
            tfDireccion.setText(cliente.getDireccion());
            tfEmail.setText(cliente.getEmail());
            tfNumCuenta.setText(cliente.getCuenta().getNumCuenta());
            tfSaldo.setText(String.valueOf(cliente.getCuenta().getSaldo()));
            comboTipoCuenta.setValue(cliente.getCuenta().getTipoCuenta());
        }
    }

    private void limpiarCampos(){
        tfNombre.setText("");
        tfApellidos.setText("");
        tfCedula.setText("");
        tfDireccion.setText("");
        tfEmail.setText("");
        tfNumCuenta.setText("");
        tfSaldo.setText("");
    }

    @FXML
    void actualizar(ActionEvent event) {

    }

    @FXML
    void agregar(ActionEvent event) throws Exception {
        if(tfNombre.getText().isEmpty() || tfApellidos.getText().isEmpty() ||
                tfCedula.getText().isEmpty() || tfDireccion.getText().isEmpty() ||
                tfNumCuenta.getText().isEmpty() || tfSaldo.getText().isEmpty() ||
                comboTipoCuenta.getSelectionModel().isEmpty()){
            mostrarMensajeAlerta("Debe llenar todos los campos");
        }
        else{
            Cliente cliente = new Cliente(tfNombre.getText(),tfApellidos.getText(),
                    tfCedula.getText(),tfDireccion.getText(),tfEmail.getText(),
                    tfNumCuenta.getText(),Double.parseDouble(tfSaldo.getText()),
                    comboTipoCuenta.getSelectionModel().getSelectedItem());
            if(INSTANCE.getBanco().getAdministrador().filtrarClientePorCedula(cliente.getCedula()).isPresent()
            || INSTANCE.getBanco().getAdministrador().filtrarClientePorEmail(cliente.getEmail()).isPresent()
            || INSTANCE.getBanco().getAdministrador().filtrarClientePorNumCuenta(cliente
                    .getCuenta().getNumCuenta()).isPresent()){
                mostrarMensajeAlerta("El cliente ya se encuentra en el sistema");
            }
            else{
                INSTANCE.getBanco().getAdministrador().registrarCliente(cliente);
                limpiarCampos();
                llenarTabla(INSTANCE.getBanco().getListaClientes());
                mostrarMensajeInformacion("Cliente","El cliente "+cliente.getNombre()+
                            " fue agregado al sistema");
            }
         }
        limpiarCampos();
    }

    @FXML
    void buscar(ActionEvent event) {
        if(INSTANCE.getBanco().getAdministrador().buscarCliente(tfNombre.getText(),tfApellidos.getText(),
                tfCedula.getText(),tfDireccion.getText(),tfEmail.getText(),
                tfNumCuenta.getText(),comboTipoCuenta.getSelectionModel().getSelectedItem()).isEmpty()){
            mostrarMensajeAlerta("El cliente no se encuentra en el sistema");
        }
        llenarTabla(INSTANCE.getBanco().getAdministrador().buscarCliente(tfNombre.getText(),tfApellidos.getText(),
                tfCedula.getText(),tfDireccion.getText(),tfEmail.getText(),
                tfNumCuenta.getText(),comboTipoCuenta.getSelectionModel().getSelectedItem()));
        limpiarCampos();
    }

    @FXML
    void eliminar(ActionEvent event) {
        if(tablaCliente.getSelectionModel().isEmpty()){
            mostrarMensajeAlerta("Debe seleccionar un cliente a eliminar");
        }
        else{
            Cliente cliente = tablaCliente.getSelectionModel().getSelectedItem();
            INSTANCE.getBanco().getListaClientes().remove(cliente);
            tablaCliente.getSelectionModel().clearSelection();
            llenarTabla(INSTANCE.getBanco().getListaClientes());
            limpiarCampos();
            mostrarMensajeInformacion("UNIBANCO","Cliente eliminado con exito");
        }
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

