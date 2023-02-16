package com.example.proyectounibanco.exception;

public class ClienteNoExisteException extends Exception{
    public ClienteNoExisteException(){
        super(String.format("El cliente no se encuentra registrado" +
                "en el sistema"));
    }
}
