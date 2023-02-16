package com.example.proyectounibanco.clases;

import com.example.proyectounibanco.clases.ESTADO_TRANSACCION;

public class Transaccion {
    private String codigoTransaccion;
    private double valor;
    private String hora;
    private String tipoTransaccion;
    private String fecha;
    private ESTADO_TRANSACCION estadoTransaccion;

    public Transaccion(String codigoTransaccion, double valor, String hora,
                       String tipoTransaccion, String fecha,
                       ESTADO_TRANSACCION estadoTransaccion) throws Exception {
        if (codigoTransaccion.isEmpty()){
            throw new Exception("El código de la transacción no puede estar vacío");
        }
        this.codigoTransaccion = codigoTransaccion;
        if(valor<0){
            throw new Exception("El valor de la transacción no puede ser negativo");
        }
        if(valor == 0){
            throw new Exception("El valor de la transaccion no puede ser igual a 0");
        }
        this.valor = valor;
        if(hora.isEmpty()){
            throw new Exception("Debe registrar una hora de transaccion");
        }
        this.hora = hora;
        if(tipoTransaccion.isEmpty()){
            throw new Exception("El tipo de transacción no puede estar vacío");
        }
        this.tipoTransaccion = tipoTransaccion;
        if(fecha.isEmpty()){
            throw new Exception("Debe registrar una fecha de transacción");
        }
        this.fecha = fecha;
        this.estadoTransaccion = estadoTransaccion;
    }

    public String getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(String codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ESTADO_TRANSACCION getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(ESTADO_TRANSACCION estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }
}