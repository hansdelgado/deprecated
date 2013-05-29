package pe.edu.cibertec.gch.dao;

import java.util.List;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pe.edu.cibertec.gch.modelo.Horario;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author Student
 */
public class HorarioDaoImplMemoriaTest {
    
    private HorarioDao horarioDao;
    
    @Before
    public void prepararPruebas() {
        // preparacion primaria de pruebas
        horarioDao = FactoryDao.getInstance().getHorarioDao();
    }

    @After
    public void limpiar() {
        // limpieza posterior a todas las pruebas
        horarioDao.borrarTodos();
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
        horarioDao.borrarTodos();
        // ejecucion
        horarioDao.registrar(horario);
        // verificacion
        assertEquals(1, horarioDao.listarTodos().size());
        
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
        horarioDao.borrarTodos();
        // ejecucion
        horarioDao.registrar(horario);
        List<Horario> obtenerSegun = horarioDao.obtenerSegun(descripcion, TipoBusqueda.Completa);
        // verificacion
        assertEquals(1, obtenerSegun.size());
    }
    
}
