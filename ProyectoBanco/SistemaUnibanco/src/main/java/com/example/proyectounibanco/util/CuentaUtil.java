package com.example.proyectounibanco.util;

import com.example.proyectounibanco.clases.Cuenta;
import com.example.proyectounibanco.clases.TIPO_CUENTA;

import java.util.function.Predicate;

public class CuentaUtil {
    public static Predicate<Cuenta> buscarPorNumCuenta(String numCuenta) {
        return cuenta -> cuenta.getNumCuenta().equals(numCuenta);
    }
    public static Predicate<Cuenta> buscarPorTipoCuenta(TIPO_CUENTA tipoCuenta){
        return cuenta -> cuenta.getTipoCuenta().equals(tipoCuenta);
    }
}
