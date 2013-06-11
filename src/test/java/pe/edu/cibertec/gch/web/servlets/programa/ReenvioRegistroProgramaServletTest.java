package pe.edu.cibertec.gch.web.servlets.programa;

import javax.servlet.RequestDispatcher;
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
public class ReenvioRegistroProgramaServletTest {

    ReenvioRegistroProgramaServlet reenvioRegistroProgramaServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDistpatDispatcher;

    @Before
    public void setUp() {

        reenvioRegistroProgramaServlet = new ReenvioRegistroProgramaServlet();
        requestDistpatDispatcher = mock(RequestDispatcher.class);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testDoGet() throws Exception {
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDistpatDispatcher);
        reenvioRegistroProgramaServlet.doGet(request, response);
    }
}
