package com.example.proyectounibanco.clases;

import static com.example.proyectounibanco.controller.AppController.INSTANCE;
import com.example.proyectounibanco.exception.ClienteExisteException;
import com.example.proyectounibanco.exception.ClienteNoExisteException;
import com.example.proyectounibanco.exception.ValorRequeridoException;
import com.example.proyectounibanco.util.ClienteUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void registrarCliente(Cliente cliente) throws ClienteExisteException {
        if(INSTANCE.getBanco().getAdministrador().filtrarClientePorCedula(cliente.getCedula()).isPresent()){
            throw new ClienteExisteException();
        }
        INSTANCE.getBanco().getListaClientes().add(cliente);
    }
    public void removerCliente(String cedula) throws ClienteNoExisteException, ValorRequeridoException {
        if(Objects.requireNonNull(cedula).isEmpty()){
            throw new ValorRequeridoException("numero de identificacion");
        }
        Optional<Cliente> cliente = filtrarClientePorCedula(cedula);
        if(cliente.isEmpty()){
            throw new ClienteNoExisteException();
        }
        INSTANCE.getBanco().getListaClientes().remove(cliente.get());
    }
    public Optional<Cliente> filtrarClientePorCedula(String cedula){
        return INSTANCE.getBanco().buscarClientePorCedula(cedula);
    }
    public Optional<Cliente> filtrarClientePorEmail(String email){
        return INSTANCE.getBanco().buscarClientePorEmail(email);
    }
    public Optional<Cliente> filtrarClientePorNumCuenta(String numCuenta){
        return INSTANCE.getBanco().buscarClientePorNumCuenta(numCuenta);
    }
    public List<Cliente> buscarCliente(String nombre,String apellidos, String cedula,
                                       String direccion, String email, String numCuenta,
                                       TIPO_CUENTA tipoCuenta){
        return INSTANCE.getBanco().getListaClientes().stream().filter(ClienteUtil.buscarPorTodo(nombre,
                        apellidos,cedula,direccion,email,numCuenta, tipoCuenta))
                .collect(Collectors.toUnmodifiableList());
    }

}
