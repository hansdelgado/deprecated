package pe.edu.cibertec.gch.filters;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import pe.edu.cibertec.gch.validaciones.Validacion;
import pe.edu.cibertec.gch.validaciones.ValidacionFactory;

/**
 * Intercepta los requests a los servlets de mi aplicacion y asegura que los
 * parametros sean validos para ser consumidos por los servlets.
 */
@WebFilter(filterName = "ValidacionInputFilter", urlPatterns = {"/*"})
public class ValidacionInputFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(ValidacionInputFilter.class.getName());
    private FilterConfig filterConfig = null;
    
  private void doBeforeProcessing(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        req.removeAttribute("errores");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        ValidacionFactory factory = new ValidacionFactory();
        Validacion validacion = factory.obtenerSegun(req);
        if(validacion != null) {
           validacion.validar(req);
           hacerReenvioA(validacion.getErrores(), chain, request, response, req, validacion.getPaginaReenvio());
        }
    }        

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        doBeforeProcessing(request, response, chain);
        chain.doFilter(request, response);
        //doAfterProcessing(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }

    private static void hacerReenvioA(Map<String, String> errores, FilterChain chain, ServletRequest request, ServletResponse response, HttpServletRequest req, String paginaReenvio) throws IOException, ServletException {
        // determinacion del lugar a donde debe ir el request
        if (errores.isEmpty()) {
            chain.doFilter(request, response);
        } else {
            req.setAttribute("errores", errores);
            req.getRequestDispatcher(paginaReenvio).forward(request, response);
        }
    }
}
