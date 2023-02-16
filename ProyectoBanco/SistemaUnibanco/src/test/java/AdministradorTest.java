import com.example.proyectounibanco.clases.Administrador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class AdministradorTest {
    @Test
    public void validarConstructor() throws Exception {
        Administrador administrador = new Administrador("123@gmail.com","1234");
        assertEquals("123@gmail.com",administrador.getCorreo());
        assertEquals("1234",administrador.getContrasenia());
    }
    @Test
    public void verificarCorreo(){
        try{
            Administrador administrador = new Administrador("","1234");
            fail("Error constructor");
        }catch (Exception e){
            assertEquals("El correo no puede estar vacío",e.getMessage());
        }
    }
    @Test
    public void verificarContrasenia(){
        try{
            Administrador administrador = new Administrador("12@gmail.com","");
            fail("Error constructor");
        }catch (Exception e){
            assertEquals("La contraseña no puede estar vacía",e.getMessage());
        }
    }
}
