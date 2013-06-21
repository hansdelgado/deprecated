package pe.edu.cibertec.gch.dao;

import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pe.edu.cibertec.gch.dao.services.HorarioService;
import pe.edu.cibertec.gch.modelo.Horario;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author Student
 */
public class HorarioDaoImplMemoriaTest {
    
    private HorarioService horarioService;
    
    @Before
    public void prepararPruebas() {
        // preparacion primaria de pruebas
        horarioService = new HorarioService();
    }

    @After
    public void limpiar() {
        // limpieza posterior a todas las pruebas
        horarioService.borrarTodos();
    }

    @Test
    public void cuandoRegistraExitosamente() {
        // preparacion adicional
        Horario horario = new Horario() {
            {
                setCodigo("123");
                setDescripcion("Madrugada");
            }
        };
        horarioService.borrarTodos();
        // ejecucion
        horarioService.registrar(horario);
        // verificacion
        assertEquals(1, horarioService.listarTodos().size());
        
    }
    
    @Test
    public void cuandoBusquedaEsExitosa() {
        final String descripcion = "Madrugada";
        // preparacion adicional
        Horario horario = new Horario() {
            {
                setCodigo("123");
                setDescripcion(descripcion);
            }
        };
        horarioService.borrarTodos();
        // ejecucion
        horarioService.registrar(horario);
        List<Horario> obtenerSegun = horarioService.obtenerSegun(descripcion, TipoBusqueda.Completa);
        // verificacion
        assertEquals(1, obtenerSegun.size());
    }
    
}
