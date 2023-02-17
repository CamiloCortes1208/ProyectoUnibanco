package com.example.proyectounibanco.controller;

import static com.example.proyectounibanco.controller.AppController.INSTANCE;
import static com.example.proyectounibanco.util.VentanaUtil.*;

import com.example.proyectounibanco.clases.Cliente;
import com.example.proyectounibanco.clases.Cuenta;
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
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colNumCuenta.setCellValueFactory(new PropertyValueFactory<>("Cuenta.numCuenta"));
        colSaldo.setCellValueFactory(new PropertyValueFactory<>("Cuenta.saldo"));
        colTipoCuenta.setCellValueFactory(new PropertyValueFactory<>("Cuenta.tipoCuenta"));

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
        Cliente cliente = new Cliente(tfNombre.getText(),tfApellidos.getText(),
                tfCedula.getText(),tfDireccion.getText(),tfEmail.getText(),
                new Cuenta(tfNumCuenta.getText(),Double.parseDouble(tfSaldo.getText()),
                        comboTipoCuenta.getSelectionModel().getSelectedItem()));
        if(INSTANCE.getBanco().getAdministrador().filtrarClientePorCedula(cliente.getCedula()).isPresent()){
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

    @FXML
    void buscar(ActionEvent event) {
        llenarTabla(INSTANCE.getBanco().getAdministrador().buscarCliente(tfNombre.getText(),tfApellidos.getText(),
                tfCedula.getText(),tfDireccion.getText(),tfEmail.getText(),
                tfNumCuenta.getText(),comboTipoCuenta.getSelectionModel().getSelectedItem()));
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

