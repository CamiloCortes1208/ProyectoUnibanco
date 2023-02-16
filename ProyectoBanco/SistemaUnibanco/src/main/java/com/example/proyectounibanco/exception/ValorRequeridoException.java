package com.example.proyectounibanco.exception;

public class ValorRequeridoException extends Exception{
    public ValorRequeridoException(String mensaje){
        super(String.format("Se requiere de %s", mensaje));
    }
}
