/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.laboratorio;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
