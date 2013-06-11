package pe.edu.cibertec.gch.filters;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author abedregal
 */
@WebFilter(filterName = "ValidacionModificarHorario", urlPatterns = {"/modificarHorario"})
public class ValidacionModificarHorario implements Filter {
    
private static final boolean debug = true;
    private FilterConfig filterConfig = null;
    
    public ValidacionModificarHorario() {
    }    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        if (debug) {
            log("ValidacionModificarHorario:doFilter()");
        }
        request.removeAttribute("errores");
        Map<String, String> errores = new HashMap<>();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String descripcion = request.getParameter("descripcion");
        String inicio = request.getParameter("inicio");
        String fin = request.getParameter("fin");
        String estado = request.getParameter("estado");
        
        if(descripcion == null || descripcion.length() < 5) {
            errores.put("Error en la descripción", "La descripción debe ser de al menos 5 caracteres.");
        }
        if(inicio == null || !inicio.matches("\\d{1,2}")) {
            errores.put("Error en el momento de inicio", "El momento de inicio debe ser un número.");
        }
        if(fin == null || !fin.matches("\\d{1,2}")) {
            errores.put("Error en el momento de fin", "El momento de fin debe ser un número.");
        }
        if(estado == null || estado.isEmpty()) {
            errores.put("Error en el estado", "Debe elegir un estado de la lista desplegable..");
        }
        if (errores.isEmpty()){
            chain.doFilter(request, response);
        } else {
            request.setAttribute("mensaje", "Han ocurrido errores al intentar modificar el horario.");
            request.setAttribute("errores", errores);
            request.getRequestDispatcher("view/horario/modificar.jsp").forward(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("ValidacionModificarHorario:Initializing filter");
            }
        }
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }

    @Override
    public void destroy() {
    }
    
}
