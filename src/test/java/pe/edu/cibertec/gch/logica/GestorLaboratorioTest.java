/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.logica;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.edu.cibertec.gch.modelo.Laboratorio;

/**
 *
 * @author JAVA_MJ
 */
public class GestorLaboratorioTest {
    
    private GestorLaboratorio gestorLaboratorio;
    
   @Before
    public void prepararPruebas() {
        // preparacion primaria de pruebas
        gestorLaboratorio = new GestorLaboratorio();
    }
   
   @After
    public void limpiar() {
        // limpieza posterior a todas las pruebas
        gestorLaboratorio.borrarTodos();
    }
   
   @Test
    public void cuandoBuscaExitosamente() {
        // preparacion adicional
        Laboratorio laboratorio = new Laboratorio() {
            {
                setNombre("eddy");
                setDescripcion("lab de quimica");
                setLocal("Miraflores");
              
            }
        };
        gestorLaboratorio.borrarTodos();
        // ejecucion
        gestorLaboratorio.registrar(laboratorio);
        // verificacion
        assertEquals(1, gestorLaboratorio.listarTodos().size());
        
    }
   
}
