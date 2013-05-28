package pe.edu.cibertec.gch.dao;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pe.edu.cibertec.gch.modelo.Horario;

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
        ((HorarioDaoImplMemoria) horarioDao).borrarTodos();
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
        ((HorarioDaoImplMemoria) horarioDao).borrarTodos();
        // ejecucion
        horarioDao.registrar(horario);
        // verificacion
        assertEquals(1, horarioDao.listarTodos().size());
        
    }
    
}
