package pe.edu.cibertec.gch.modelo;

import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DanJoas
 */
public class ProgramaTest {

    // clase en prueba
    private Programa programa;

    @Before
    public void setUp() {
        programa = new Programa();
        programa.setCodigo("01");
        programa.setTitulo("Java");
        programa.setDescripcion("Ninguna");
        programa.setObjetivos("Conocimientos Avanzados");
        programa.setRequisitos("POO");
        programa.setMoneda(Moneda.DolaresUS);
        programa.setPrecio(3700);
        programa.setEstado(EstadoActividad.Valido);
       // programa.setFechaInicial(new Date());
        programa.setDuracion(140);
    }

    @After
    public void tearDown() {
        programa = null;
    }

    @Test
    public void testSetFechaInicial() {
        // carga de datos
//        Calendar cal = Calendar.getInstance();
//        cal.set(2013, 10, 01);
//        // ejecuacion
//        programa.setFechaInicial(cal.getTime());
//        // verificacion
//        assertEquals("2013-11-01", programa.getFechaInicial());
    }
}
