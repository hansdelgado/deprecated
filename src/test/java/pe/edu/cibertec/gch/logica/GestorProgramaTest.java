package pe.edu.cibertec.gch.logica;

import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 * @author DanJoas
 */
public class GestorProgramaTest {

    GestorPrograma gestorPrograma;

    public GestorProgramaTest() {
    }

    @Before
    public void setUp() {

        gestorPrograma = new GestorPrograma();
    }

    @After
    public void tearDown() {
        gestorPrograma.borrarTodos();
    }

    @Test
    public void consultarProgramaPorCodigo() {
        // carga de datos
        gestorPrograma.borrarTodos();
        Programa p1 = new Programa("01");
        gestorPrograma.registrar(p1);
        // ejecucion y verificacion
        assertEquals(p1, gestorPrograma.consultarPorCodigo("01"));
    }

    @Test
    public void registrarPrograma() {
        // carga de datos
        gestorPrograma.borrarTodos();
        Programa p1 = new Programa("01");
        // ejecutar
        gestorPrograma.registrar(p1);
        // verificar
        assertEquals(1, gestorPrograma.listarTodos().size());
    }

    @Test
    public void listarTodosLosProgramas() {
        gestorPrograma.borrarTodos();
        Programa p1 = new Programa("01");
        Programa p2 = new Programa("02");
        gestorPrograma.registrar(p1);
        gestorPrograma.registrar(p2);

        List<Programa> lstProgramas = gestorPrograma.listarTodos();

        assertEquals(2, lstProgramas.size());
    }

    @Test
    public void eliminarProgramaPorCodigo() {
        gestorPrograma.borrarTodos();
        Programa p1 = new Programa("01");
        p1.setEstado(EstadoActividad.Valido);
        gestorPrograma.registrar(p1);

        gestorPrograma.eliminarPorCodigo("01");

        assertEquals(EstadoActividad.Obsoleto, gestorPrograma.listarTodos().get(0).getEstado());
    }

    @Test
    public void borrarTodosLosProgramas() {
        Programa p1 = new Programa("01");
        Programa p2 = new Programa("02");
        gestorPrograma.registrar(p1);
        gestorPrograma.registrar(p2);

        gestorPrograma.borrarTodos();

        assertEquals(0, gestorPrograma.listarTodos().size());
    }

    @Test
    public void listarSegunTipoCompleta() {
        gestorPrograma.borrarTodos();
        Programa p1 = new Programa("01", "Tecnicos", "Ninguno");
        gestorPrograma.registrar(p1);

        List<Programa> lstProgramas = gestorPrograma.listarSegun("Tecnicos", "Ninguno", TipoBusqueda.Completa);

        assertEquals(p1, lstProgramas.get(0));
    }

    @Test
    public void listarSegunTipoParcial() {
        gestorPrograma.borrarTodos();
        Programa p1 = new Programa("01", "Tecnicos", "Ninguno");
        gestorPrograma.registrar(p1);

        List<Programa> lstProgramas = gestorPrograma.listarSegun("Tecnicos", "Ninguno", TipoBusqueda.Parcial);

        assertEquals(p1, lstProgramas.get(0));
    }
}
