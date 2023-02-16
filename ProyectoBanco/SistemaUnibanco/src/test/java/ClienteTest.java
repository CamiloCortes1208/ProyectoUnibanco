import com.example.proyectounibanco.clases.Cliente;
import static com.example.proyectounibanco.clases.TIPO_CUENTA.*;

import com.example.proyectounibanco.clases.Cuenta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ClienteTest {
    @Test
    public void validarConstructor() throws Exception {
        Cliente cliente = new Cliente("Juan","Gutierrez",
                "123","Los Alamos","123@gmail.com",new Cuenta("123",20000,AHORROS));
        assertEquals("Juan",cliente.getNombre());
        assertEquals("123",cliente.getCuenta().getNumCuenta());
        assertEquals(20000,cliente.getCuenta().getSaldo());
        assertEquals(AHORROS,cliente.getCuenta().getTipoCuenta());
    }
    @Test
    public void validarNombre(){
        try{
            Cliente cliente = new Cliente("","Gutierrez",
                    "123","Los Alamos","123@gmail.com",
                    new Cuenta("123",12,AHORROS));
            fail("Error en constructor");
        }catch (Exception e){
            assertEquals("El nombre del cliente no puede estar vacío",e.getMessage());
        }
    }

    @Test
    public void validarApellidos(){
        try{
            Cliente cliente = new Cliente("Juan","",
                    "123","Los Alamos","123@gmail.com",
                    new Cuenta("123",12,AHORROS));
            fail("Error en constructor");
        }catch (Exception e){
            assertEquals("Los apellidos del cliente no pueden estar vacíos",e.getMessage());
        }
    }

    @Test
    public void validarCedula(){
        try{
            Cliente cliente = new Cliente("Juan","Gutierrez",
                    "","Los Alamos","123@gmail.com",
                    new Cuenta("123",12,AHORROS));
            fail("Error en constructor");
        }catch (Exception e){
            assertEquals("La cédula del cliente no puede estar vacía",e.getMessage());
        }
    }
    @Test
    public void validarDireccion(){
        try{
            Cliente cliente = new Cliente("Juan","Gutierrez",
                    "123","","123@gmail.com",
                    new Cuenta("123",12,AHORROS));
            fail("Error en constructor");
        }catch (Exception e){
            assertEquals("La dirección del cliente no puede estar vacía",e.getMessage());
        }
    }
    @Test
    public void validarEmail(){
        try{
            Cliente cliente = new Cliente("Juan","Gutierrez",
                    "123","Los Alamos","",
                    new Cuenta("123",12,AHORROS));
            fail("Error en constructor");
        }catch (Exception e){
            assertEquals("El correo del cliente no puede estar vacío",e.getMessage());
        }
    }
}