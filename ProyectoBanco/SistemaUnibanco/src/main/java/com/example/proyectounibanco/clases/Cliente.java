package com.example.proyectounibanco.clases;

import javafx.beans.property.StringProperty;

public class Cliente {
    private String nombre;
    private String apellidos;
    private String cedula;
    private String direccion;
    private String email;
    private Cuenta cuenta;

    public Cliente(String nombre, String apellidos, String cedula, String direccion, String email,
                   String numCuenta, double saldo, TIPO_CUENTA tipoCuenta) throws Exception {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.direccion = direccion;
        this.email = email;
        this.cuenta = new Cuenta(numCuenta,saldo,tipoCuenta);
    }

    public static Cliente of(String nombre, String apellidos, String cedula,
                    String direccion, String email,String numCuenta,
                             double saldo, TIPO_CUENTA tipoCuenta ) throws Exception {
        if(nombre.isEmpty()){
            throw new Exception("El nombre del cliente no puede estar vacío");
        }
        if(apellidos.isEmpty()){
            throw new Exception("Los apellidos del cliente no pueden estar vacíos");
        }
        if(cedula.isEmpty()){
            throw new Exception("La cédula del cliente no puede estar vacía");
        }
        if(direccion.isEmpty()){
            throw new Exception("La dirección del cliente no puede estar vacía");
        }
        if(email.isEmpty()){
            throw new Exception("El correo del cliente no puede estar vacío");
        }
        return new Cliente(nombre,apellidos,cedula,direccion,email,numCuenta,saldo,tipoCuenta);
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(String numCuenta, double saldo, TIPO_CUENTA tipoCuenta) {
        this.cuenta.setNumCuenta(numCuenta);
        this.cuenta.setSaldo(saldo);
        this.cuenta.setTipoCuenta(tipoCuenta);
    }
}
