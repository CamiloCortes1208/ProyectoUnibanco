package com.example.proyectounibanco.controller;

import com.example.proyectounibanco.clases.Administrador;
import com.example.proyectounibanco.clases.Banco;

public enum AppController {
    INSTANCE;
    private final Banco banco;

    AppController(){
        this.banco = new Banco(new Administrador("",""));
    }

    public Banco getBanco() {
        return this.banco;
    }
}
