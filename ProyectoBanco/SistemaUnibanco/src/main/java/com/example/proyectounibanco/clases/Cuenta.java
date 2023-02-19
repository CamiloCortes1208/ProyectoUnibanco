package com.example.proyectounibanco.clases;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String numCuenta;
    private double saldo;
    private TIPO_CUENTA tipoCuenta;

    public Cuenta(String numCuenta, double saldo, TIPO_CUENTA tipoCuenta) throws Exception {
        if(numCuenta.isEmpty()){
            throw new Exception("El numero de la cuenta no puede estar vacío");
        }
        this.numCuenta = numCuenta;
        if(saldo < 0){
            throw new Exception("El saldo de la cuenta no puede ser negativo");
        }
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public TIPO_CUENTA getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TIPO_CUENTA tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

}
