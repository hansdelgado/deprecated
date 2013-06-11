/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.laboratorio;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import pe.edu.cibertec.gch.logica.GestorLaboratorio;
import pe.edu.cibertec.gch.modelo.Laboratorio;

/**
 *
 * @author Admin
 */
public class ListadoLaboratorioServletTest {
    private GestorLaboratorio gestorLaboratorio;
    private RegistroLaboratorioServlet registroLaboratorioServlet;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    
    public ListadoLaboratorioServletTest() {
        
    }

    
    @Before
    public void setUp() {
        gestorLaboratorio = new GestorLaboratorio();
        registroLaboratorioServlet=mock(RegistroLaboratorioServlet.class);
        req=mock(HttpServletRequest.class);
        resp=mock(HttpServletResponse.class);
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testDoGet() throws Exception {
  
        List<Laboratorio> laboratorios = gestorLaboratorio.listarTodos();
        verify(req).setAttribute("laboratorios", laboratorios);

    }
}
