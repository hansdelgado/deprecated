package pe.edu.cibertec.gch.modelo;

import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Verifica el comportamiento de profesor
 */
public class ProfesorTest {

    private static final String CODIGO_VALIDO = "pxvbalta";

    // clase a probar
    private Profesor profesor;

    @Before
    public void setUp() {
        profesor = new Profesor() {
            {
                setCodigo(CODIGO_VALIDO);
                setNombres("Victor");
                setApellidoPaterno("Balta");
                setFechaNacimiento(new Date());
                setSexo(Genero.Masculino);
                setEstado(EstadoProfesor.Activo);
            }
        };
    }

    @Test
    public void cuandoTieneDatosValidos() {
        boolean conDatosObligatorios = profesor.tieneDatosObligatorios();

        assertTrue(conDatosObligatorios);
    }

    @Test
    public void cuandoTieneCodigoNulo() {
        profesor.setCodigo(null);
        boolean conDatosObligatorios = profesor.tieneDatosObligatorios();

        assertFalse(conDatosObligatorios);
    }

    @Test
    public void cuandoTieneNombresNulo() {
        profesor.setNombres(null);
        boolean conDatosObligatorios = profesor.tieneDatosObligatorios();

        assertFalse(conDatosObligatorios);
    }

    @Test
    public void cuandoProfesorTieneNombresNulo() {
        // preparacion adicional de la prueba
        profesor.setNombres(null);
        // ejecucion del cuerpo de la prueba
        boolean conDatosObligatorios = profesor.tieneDatosObligatorios();
        // verificacion de los datos de la prueba
        assertFalse(conDatosObligatorios);
    }

    @Test
    public void cuandoProfesorTieneApellidoPaternoNulo() {
        // preparacion adicional de la prueba
        profesor.setApellidoPaterno(null);
        // ejecucion del cuerpo de la prueba
        boolean conDatosObligatorios = profesor.tieneDatosObligatorios();
        // verificacion de los datos de la prueba
        assertFalse(conDatosObligatorios);
    }

    @Test
    public void cuandoProfesorTieneFechaNacimientoNulo() {
        // preparacion adicional de la prueba
        profesor.setFechaNacimiento(null);
        // ejecucion del cuerpo de la prueba
        boolean conDatosObligatorios = profesor.tieneDatosObligatorios();
        // verificacion de los datos de la prueba
        assertFalse(conDatosObligatorios);
    }

    @Test
    public void cuandoProfesorTieneGeneroNulo() {
        // preparacion adicional de la prueba
        profesor.setSexo(null);
        // ejecucion del cuerpo de la prueba
        boolean conDatosObligatorios = profesor.tieneDatosObligatorios();
        // verificacion de los datos de la prueba
        assertFalse(conDatosObligatorios);
    }

    @Test
    public void cuandoProfesorTieneEstadoNulo() {
        // preparacion adicional de la prueba
        profesor.setEstado(null);
        // ejecucion del cuerpo de la prueba
        boolean conDatosObligatorios = profesor.tieneDatosObligatorios();
        // verificacion de los datos de la prueba
        assertFalse(conDatosObligatorios);
    }

    @Test
    public void cuandoTieneCodigoInvalido() {
        // ejecucion del cuerpo de la prueba
        profesor.setCodigo("blah");
        // verificacion de los datos de la prueba
        assertEquals(CODIGO_VALIDO, profesor.getCodigo());
    }
}
