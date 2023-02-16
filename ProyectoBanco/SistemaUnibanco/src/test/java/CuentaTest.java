import com.example.proyectounibanco.clases.Cuenta;
import static com.example.proyectounibanco.clases.TIPO_CUENTA.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CuentaTest {
    @Test
    public void validarConstructor() throws Exception {
        Cuenta cuenta = new Cuenta("123",23000,AHORROS);
        assertEquals("123",cuenta.getNumCuenta());
        assertEquals(23000,cuenta.getSaldo());
        assertEquals(AHORROS,cuenta.getTipoCuenta());
    }
    @Test
    public void validarNumCuenta(){
        try{
            Cuenta cuenta = new Cuenta("",23000,AHORROS);
            fail("Error en constructor");
        }catch (Exception e){
            assertEquals("El numero de la cuenta no puede estar vacío",e.getMessage());
        }
    }
    @Test
    public void validarSaldo(){
        try{
            Cuenta cuenta = new Cuenta("123",-1000,AHORROS);
            fail("Error en constructor");
        }catch (Exception e){
            assertEquals("El saldo de la cuenta no puede ser negativo",e.getMessage());
        }
    }
}