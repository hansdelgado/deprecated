package pe.edu.cibertec.gch.web.servlets.programa;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pe.edu.cibertec.gch.modelo.Programa;
import static org.mockito.Mockito.*;

/**
 *
 * @author DanJoas
 */
public class ListadoProgramaServletTest {

    private ListadoProgramaServlet listadoProgramaServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDistpatDispatcher;

    @Before
    public void setUp() {

        listadoProgramaServlet = new ListadoProgramaServlet();
        requestDistpatDispatcher = mock(RequestDispatcher.class);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDoGet() throws Exception {
        List<Programa> programas = new ArrayList<Programa>();
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDistpatDispatcher);
        listadoProgramaServlet.doGet(request, response);
        verify(request).setAttribute("programa", programas);

    }
}
