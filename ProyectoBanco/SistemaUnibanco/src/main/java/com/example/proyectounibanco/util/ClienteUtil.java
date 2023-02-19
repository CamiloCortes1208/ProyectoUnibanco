package com.example.proyectounibanco.util;

import com.example.proyectounibanco.clases.Cliente;
import com.example.proyectounibanco.clases.TIPO_CUENTA;

import java.util.function.Predicate;

public class ClienteUtil {
    public static Predicate<Cliente> buscarPorNombre(String nombre){
        return cliente -> cliente.getNombre().equals(nombre);
    }
    public static Predicate<Cliente> buscarPorApellidos(String apellidos){
        return cliente -> cliente.getApellidos().equals(apellidos);
    }
    public static Predicate<Cliente> buscarPorCedula(String cedula){
        return cliente -> cliente.getCedula().equals(cedula);
    }
    public static Predicate<Cliente> buscarPorDireccion(String direccion){
        return cliente -> cliente.getDireccion().equals(direccion);
    }
    public static Predicate<Cliente> buscarPorEmail(String email){
        return cliente -> cliente.getEmail().equals(email);
    }
    public static Predicate<Cliente> buscarPorNumCuenta(String numCuenta){
        return cliente -> cliente.getCuenta().getNumCuenta().equals(numCuenta);
    }
    public static Predicate<Cliente> buscarPorTipoCuenta(TIPO_CUENTA tipoCuenta){
        return cliente -> cliente.getCuenta().getTipoCuenta().equals(tipoCuenta);
    }
    public static Predicate<Cliente> buscarPorTodo(String nombre, String apellidos, String cedula,
                                                   String direccion,String email, String numCuenta,
                                                   TIPO_CUENTA tipoCuenta) {
        Predicate<Cliente> predicado = cliente -> true;
        if (nombre != null && !nombre.isEmpty()) {
            predicado = predicado.and(buscarPorNombre(nombre));
        }
        if (apellidos != null && !apellidos.isEmpty()) {
            predicado = predicado.and(buscarPorApellidos(apellidos));
        }
        if (cedula != null && !cedula.isEmpty()) {
            predicado = predicado.and(buscarPorCedula(cedula));
        }
        if (direccion != null && !direccion.isEmpty()) {
            predicado = predicado.and(buscarPorDireccion(direccion));
        }
        if (email != null && !email.isEmpty()) {
            predicado = predicado.and(buscarPorEmail(email));
        }
        if (numCuenta != null && !numCuenta.isEmpty()) {
            predicado = predicado.and(buscarPorNumCuenta(numCuenta));
        }
        if (email != null && !email.isEmpty()) {
            predicado = predicado.and(buscarPorEmail(email));
        }
        if (tipoCuenta != null) {
            predicado = predicado.and(buscarPorTipoCuenta(tipoCuenta));
        }
        return predicado;
    }
}
