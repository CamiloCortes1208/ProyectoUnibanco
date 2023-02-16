package com.example.proyectounibanco.clases;

import java.util.ArrayList;
import java.util.List;

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

}
