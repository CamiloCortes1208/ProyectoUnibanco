package com.example.proyectounibanco.clases;

import com.example.proyectounibanco.exception.ClienteExisteException;
import com.example.proyectounibanco.exception.ClienteNoExisteException;
import com.example.proyectounibanco.exception.ValorRequeridoException;
import com.example.proyectounibanco.util.ClienteUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.proyectounibanco.util.ClienteUtil.buscarPorCedula;

public class Banco {
    private String nombre;
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Cuenta> listaCuentas = new ArrayList<>();
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

    public Optional<Cliente> buscarClientePorCedula(String cedula) {
        return listaClientes.stream().filter(ClienteUtil.buscarPorCedula(cedula)).findFirst();
    }
    public Optional<Cliente> buscarClientePorEmail(String email){
        return listaClientes.stream().filter(ClienteUtil.buscarPorEmail(email)).findFirst();
    }
    public Optional<Cliente> buscarClientePorNumCuenta(String numCuenta){
        return listaClientes.stream().filter(ClienteUtil.buscarPorNumCuenta(numCuenta)).findFirst();
    }
}
