
package pe.edu.cibertec.gch.web.servlets.programa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author DanJoas
 */
public class RegistroProgramaServletTest {

    private RegistroProgramaServlet registroProgramaServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Before
    public void setUp() {
        registroProgramaServlet = mock(RegistroProgramaServlet.class);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDoPost() throws Exception {
        llenarRequest(request);
        registroProgramaServlet.doPost(request, response);
        //verify(response).sendRedirect("listarProgramas");
    }

    private void llenarRequest(HttpServletRequest request) {
        when(request.getParameter("codigo")).thenReturn("01");
        when(request.getParameter("titulo")).thenReturn("Tecnicos Industriales");
        when(request.getParameter("descripcion")).thenReturn("Ninguna");
        when(request.getParameter("objetivos")).thenReturn("Ninguna");
        when(request.getParameter("requisitos")).thenReturn("POO");
        when(request.getParameter("moneda")).thenReturn("NS");
        when(request.getParameter("fecha")).thenReturn("22/05/2013");
        when(request.getParameter("duracion")).thenReturn("140");
        when(request.getParameter("precio")).thenReturn("3700");
    }
}
