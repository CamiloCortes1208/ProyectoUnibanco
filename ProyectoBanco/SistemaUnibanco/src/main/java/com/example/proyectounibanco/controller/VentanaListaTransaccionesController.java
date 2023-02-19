package com.example.proyectounibanco.controller;

import com.example.proyectounibanco.clases.TIPO_TRANSACCION;
import static com.example.proyectounibanco.clases.TIPO_TRANSACCION.*;
import static com.example.proyectounibanco.clases.ESTADO_TRANSACCION.*;

import com.example.proyectounibanco.clases.*;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.example.proyectounibanco.controller.AppController.INSTANCE;
import static com.example.proyectounibanco.util.VentanaUtil.*;

public class VentanaListaTransaccionesController {

    @FXML
    private Button botonRegresar;

    @FXML
    private TableColumn<Transaccion, String> colCodigo;

    @FXML
    private TableColumn<Transaccion, ESTADO_TRANSACCION> colEstado;

    @FXML
    private TableColumn<Transaccion, String> colFecha;

    @FXML
    private TableColumn<Transaccion, String> colHora;

    @FXML
    private TableColumn<Transaccion, TIPO_TRANSACCION> colTipo;

    @FXML
    private TableColumn<Transaccion, Double> colValor;

    @FXML
    private ComboBox<TIPO_TRANSACCION> comboTipo;


    @FXML
    private TableView<Transaccion> tablaTransacciones;

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfNumCuenta;

    @FXML
    private TextField tfValor;

    @FXML
    public void initialize(){
        llenarTabla(INSTANCE.getBanco().getListaTransacciones());
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigoTransaccion"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoTransaccion"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoTransaccion"));
        tablaTransacciones.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));
        comboTipo.setItems(FXCollections.observableArrayList(TIPO_TRANSACCION.values()));
    }
    private void llenarCampos(Transaccion transaccion) {
        if (transaccion != null) {
            tfCodigo.setText(transaccion.getCodigoTransaccion());
            tfValor.setText(String.valueOf(transaccion.getValor()));
            comboTipo.setValue(transaccion.getTipoTransaccion());
        }
    }
    private void limpiarCampos() {
        tfCodigo.setText("");
        tfValor.setText("");
        tfNumCuenta.setText("");
    }
    private void llenarTabla(List<Transaccion> listaTransacciones){
        tablaTransacciones.setItems(FXCollections.observableArrayList(listaTransacciones));
        tablaTransacciones.refresh();
    }
    @FXML
    void actualizar(ActionEvent event) {

    }

    @FXML
    void agregar(ActionEvent event) throws Exception {
        if(tfCodigo.getText().isEmpty() || tfValor.getText().isEmpty() ||
                tfNumCuenta.getText().isEmpty() || comboTipo.getSelectionModel().isEmpty()){
            mostrarMensajeAlerta("Debe llenar todos los campos");
        }
        else{
            if(INSTANCE.getBanco().getAdministrador().filtrarClientePorNumCuenta(tfNumCuenta.getText())
                    .isEmpty()){
                mostrarMensajeAlerta("No se puede realizar la transacción porque no hay una cuenta con" +
                        " tal número en el sistema");
                limpiarCampos();
            }
            else{
                Cuenta cuenta = INSTANCE.getBanco().buscarClientePorNumCuenta(tfNumCuenta.getText()).get().getCuenta();
                String fecha = LocalDate.now().toString();
                String hora = LocalTime.now().toString();
                Transaccion transaccion = new Transaccion(tfCodigo.getText(),Double.parseDouble(tfValor.getText()),hora,
                        comboTipo.getSelectionModel().getSelectedItem(),fecha,ESTADO_TRANSACCION.NEUTRAL);
                TIPO_TRANSACCION tipoTransaccion = comboTipo.getSelectionModel().getSelectedItem();
                if(tipoTransaccion.equals(RETIRO)){
                    INSTANCE.getBanco().getAdministrador().retirar(cuenta,transaccion);
                    if(transaccion.getEstadoTransaccion().equals(RECHAZADA)){
                        mostrarMensajeAlerta("Transacción rechazada, sin suficientes fondos");
                    }
                    else if (transaccion.getEstadoTransaccion().equals(SIN_FONDOS)){
                        mostrarMensajeAlerta("Transacción rechazada, sin fondos");
                    }
                    else if(transaccion.getEstadoTransaccion().equals(EXITOSA)){
                        mostrarMensajeInformacion("Transacción","Transacción exitosa");
                        limpiarCampos();
                        llenarTabla(INSTANCE.getBanco().getListaTransacciones());
                    }
                }
                else if(tipoTransaccion.equals(DEPOSITO)){
                    INSTANCE.getBanco().getAdministrador().depositar(cuenta,transaccion);
                    mostrarMensajeInformacion("Transacción","Transacción exitosa");
                    llenarTabla(INSTANCE.getBanco().getListaTransacciones());
                }
                else if(tipoTransaccion.equals(CONSULTA)){
                    double saldoMostrar = INSTANCE.getBanco().getAdministrador().consultarSaldo(cuenta,transaccion);
                    mostrarMensajeInformacion("Saldo","Su saldo es "+saldoMostrar);
                    limpiarCampos();
                    llenarTabla(INSTANCE.getBanco().getListaTransacciones());
                }
            }
        }
    }

    @FXML
    void buscar(ActionEvent event) {
        if(INSTANCE.getBanco().getAdministrador().buscarTransaccion(tfCodigo.getText(),
                Double.parseDouble(tfValor.getText()),
                comboTipo.getSelectionModel().getSelectedItem()).isEmpty()){
            mostrarMensajeAlerta("La transacción no se encuentra registrada en el sistema");
        }
        llenarTabla(INSTANCE.getBanco().getAdministrador().buscarTransaccion(tfCodigo.getText(),
                Double.parseDouble(tfValor.getText()),
                comboTipo.getSelectionModel().getSelectedItem()));
        limpiarCampos();
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