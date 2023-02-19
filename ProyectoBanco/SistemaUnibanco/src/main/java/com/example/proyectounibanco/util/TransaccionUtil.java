package com.example.proyectounibanco.util;

import com.example.proyectounibanco.clases.*;

import java.util.function.Predicate;

public class TransaccionUtil {
    public static Predicate<Transaccion> buscarPorCodigoTransaccion(String codigoTransaccion) {
        return transaccion -> transaccion.getCodigoTransaccion().equals(codigoTransaccion);
    }
    public static Predicate<Transaccion> buscarPorValor(double valor){
        return transaccion -> valor == transaccion.getValor();
    }
    public static Predicate<Transaccion> buscarPorHora(String hora){
        return transaccion -> transaccion.getHora().equals(hora);
    }
    public static Predicate<Transaccion> buscarPorTipoTransaccion(TIPO_TRANSACCION tipoTransaccion){
        return transaccion -> transaccion.getTipoTransaccion().equals(tipoTransaccion);
    }
    public static Predicate<Transaccion> buscarPorFecha(String fecha){
        return transaccion -> transaccion.getFecha().equals(fecha);
    }
    public static Predicate<Transaccion> buscarPorEstadoTransaccion(ESTADO_TRANSACCION estadoTransaccion){
        return transaccion -> transaccion.getEstadoTransaccion().equals(estadoTransaccion);
    }
    public static Predicate<Transaccion> buscarPorTodo(String codigoTransaccion, TIPO_TRANSACCION tipoTransaccion) {
        Predicate<Transaccion> predicado = transaccion -> true;
        if (codigoTransaccion != null && !codigoTransaccion.isEmpty()) {
            predicado = predicado.and(buscarPorCodigoTransaccion(codigoTransaccion));
        }
        if (tipoTransaccion != null) {
            predicado = predicado.and(buscarPorTipoTransaccion(tipoTransaccion));
        }
        return predicado;
    }
}
