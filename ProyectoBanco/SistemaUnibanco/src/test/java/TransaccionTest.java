import com.example.proyectounibanco.clases.Transaccion;
import static com.example.proyectounibanco.clases.ESTADO_TRANSACCION.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TransaccionTest {
    @Test
    public void validarConstructor() throws Exception {
        Transaccion transaccion = new Transaccion("123",230000,"4:30",
                "PSE","23/4/23",EXITOSA);
        assertEquals("123",transaccion.getCodigoTransaccion());
        assertEquals(230000,transaccion.getValor());
        assertEquals("4:30",transaccion.getHora());
        assertEquals("PSE",transaccion.getTipoTransaccion());
        assertEquals(EXITOSA,transaccion.getEstadoTransaccion());
    }
    @Test
    public void validarCodigo(){
        try{
            Transaccion transaccion = new Transaccion("",230000,"4:30",
                    "PSE","23/4/23",EXITOSA);
            fail("Error en el constructor");
        }catch (Exception e){
            assertEquals("El código de la transacción no puede estar vacío",e.getMessage());
        }
    }
    @Test
    public void validarValor(){
        try{
            Transaccion transaccion = new Transaccion("123",-2000,"4:30",
                    "PSE","23/4/23",EXITOSA);
            fail("Error en el constructor");
        }catch (Exception e){
            assertEquals("El valor de la transacción no puede ser negativo",e.getMessage());
        }
    }
    @Test
    public void validarValor2(){
        try{
            Transaccion transaccion = new Transaccion("123",0,"4:30",
                    "PSE","23/4/23",EXITOSA);
            fail("Error en el constructor");
        }catch (Exception e){
            assertEquals("El valor de la transaccion no puede ser igual a 0",e.getMessage());
        }
    }
    @Test
    public void validarHora(){
        try{
            Transaccion transaccion = new Transaccion("123",230000,"",
                    "PSE","23/4/23",EXITOSA);
            fail("Error en el constructor");
        }catch (Exception e){
            assertEquals("Debe registrar una hora de transaccion",e.getMessage());
        }
    }
    @Test
    public void validarTipo(){
        try{
            Transaccion transaccion = new Transaccion("123",230000,"4:30",
                    "","23/4/23",EXITOSA);
            fail("Error en el constructor");
        }catch (Exception e){
            assertEquals("El tipo de transacción no puede estar vacío",e.getMessage());
        }
    }
    @Test
    public void validarFecha(){
        try{
            Transaccion transaccion = new Transaccion("123",230000,"4:30",
                    "PSE","",EXITOSA);
            fail("Error en el constructor");
        }catch (Exception e){
            assertEquals("Debe registrar una fecha de transacción",e.getMessage());
        }
    }
}