package com.example.proyectounibanco.clases;

public class Administrador {
    private String correo;
    private String contrasenia;

    public Administrador(String correo, String contrasenia){
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
