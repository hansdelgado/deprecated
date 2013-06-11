/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.laboratorio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Admin
 */
public class RegistroLaboratorioServletTest {
    private RegistroLaboratorioServlet registroLaboratorioServlet;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    
    
    public RegistroLaboratorioServletTest() {
    }

    
    @Before
    public void setUp() {
        registroLaboratorioServlet=mock(RegistroLaboratorioServlet.class);
        req=mock(HttpServletRequest.class);
        resp=mock(HttpServletResponse.class);
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void testRegistrar () throws Exception{
        llenarRegistro(req);
        registroLaboratorioServlet.doPost(req, resp);
    }
    
    private void llenarRegistro(HttpServletRequest req){
        when(req.getParameter("codigo")).thenReturn("0001");
        when(req.getParameter("nombre")).thenReturn("lab_01");
        when(req.getParameter("descripcion")).thenReturn("laboratorio de fisica");
        when(req.getParameter("local")).thenReturn("miraflores");
        when(req.getParameter("pabellon")).thenReturn("a1");
        when(req.getParameter("salon")).thenReturn("a101");
        when(req.getParameter("capacidad")).thenReturn("50");
    }
}
