package com.example.proyectounibanco.exception;

public class ClienteExisteException extends Exception{
    public ClienteExisteException(){
        super(("El cliente ya se encuentra en el sistema"));
    }
}
