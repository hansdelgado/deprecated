package pe.edu.cibertec.gch.web.servlets.programa;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import pe.edu.cibertec.gch.modelo.Programa;

/**
 *
 * @author DanJoas
 */
public class BuscarProgramaServletTest {

    private BuscarProgramaServlet buscarProgramaServlet;
    private HttpServletRequest req;
    private HttpServletResponse resp;
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp() {

        buscarProgramaServlet = new BuscarProgramaServlet();
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        requestDispatcher = mock(RequestDispatcher.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDoGet() throws Exception {

        llenarRequest(req);
        buscarProgramaServlet.doGet(req, resp);
        List<Programa> programas = new ArrayList<Programa>();
        verify(req).setAttribute("programa", programas);
    }

    private void llenarRequest(HttpServletRequest req) {
        when(req.getParameter("titulo")).thenReturn("Java");
        when(req.getParameter("descripcion")).thenReturn("Niguno");
        when(req.getParameter("tipoBusqueda")).thenReturn("0");
        when(req.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
    }
}
