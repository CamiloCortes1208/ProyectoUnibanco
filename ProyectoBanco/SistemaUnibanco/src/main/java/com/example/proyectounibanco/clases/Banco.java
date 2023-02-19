package com.example.proyectounibanco.clases;

import com.example.proyectounibanco.util.ClienteUtil;
import com.example.proyectounibanco.util.TransaccionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Banco {
    private String nombre;
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Cuenta> listaCuentas = new ArrayList<>();
    private List<Transaccion> listaTransacciones = new ArrayList<>();
    private final Administrador administrador;

    public Banco(Administrador administrador) {
        this.nombre = "Unibanco";
        this.administrador = administrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
    public Administrador getAdministrador() {
        return administrador;
    }

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }
    public Optional<Cliente> buscarClientePorCedula(String cedula) {
        return listaClientes.stream().filter(ClienteUtil.buscarPorCedula(cedula)).findFirst();
    }
    public Optional<Cliente> buscarClientePorEmail(String email){
        return listaClientes.stream().filter(ClienteUtil.buscarPorEmail(email)).findFirst();
    }
    public Optional<Cliente> buscarClientePorNumCuenta(String numCuenta){
        return listaClientes.stream().filter(ClienteUtil.buscarPorNumCuenta(numCuenta)).findFirst();
    }
    public Optional<Transaccion> buscarTransaccionPorCodigoTransaccion(String codigoTransaccion){
        return listaTransacciones.stream().filter(TransaccionUtil
                .buscarPorCodigoTransaccion(codigoTransaccion)).findFirst();
    }
}
