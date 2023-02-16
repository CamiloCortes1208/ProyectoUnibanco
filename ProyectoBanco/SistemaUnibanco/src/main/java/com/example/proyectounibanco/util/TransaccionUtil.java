package com.example.proyectounibanco.util;

import com.example.proyectounibanco.clases.Cuenta;
import com.example.proyectounibanco.clases.ESTADO_TRANSACCION;
import com.example.proyectounibanco.clases.TIPO_TRANSACCION;
import com.example.proyectounibanco.clases.Transaccion;

import java.util.function.Predicate;

public class TransaccionUtil {
    public static Predicate<Transaccion> buscarPorCodigoTransaccion(String codigoTransaccion) {
        return transaccion -> transaccion.getCodigoTransaccion().equals(codigoTransaccion);
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
}
