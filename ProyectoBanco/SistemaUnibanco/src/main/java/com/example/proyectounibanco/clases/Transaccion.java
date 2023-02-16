package com.example.proyectounibanco.clases;

public class Transaccion {
    private String codigoTransaccion;
    private double valor;
    private String hora;
    private TIPO_TRANSACCION tipoTransaccion;
    private String fecha;
    private ESTADO_TRANSACCION estadoTransaccion;

    public Transaccion(String codigoTransaccion, double valor, String hora,
                       TIPO_TRANSACCION tipoTransaccion, String fecha,
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

    public TIPO_TRANSACCION getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TIPO_TRANSACCION tipoTransaccion) {
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