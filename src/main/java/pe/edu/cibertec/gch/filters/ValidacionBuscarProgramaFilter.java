package pe.edu.cibertec.gch.filters;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 *
 * @author grupoPrograma
 */
@WebFilter(filterName = "ValidacionBuscarProgramaFilter", urlPatterns = {"/buscarProgramas"})
public class ValidacionBuscarProgramaFilter implements Filter {

    private FilterConfig filterConfig = null;

    public ValidacionBuscarProgramaFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {


        HashMap<String, String> errores = validarPrograma(request);

        if (errores.size() > 0) {
            // envimos de regreso los errores y los datos ingresados.
            request.setAttribute("errores", errores.values());

            for (String name : request.getParameterMap().keySet()) {
                request.setAttribute(name, request.getParameter(name));
            }
            GchServletUtils.reenviarAModulo("programa", (HttpServletRequest) request, (HttpServletResponse) response);
        } else {
            // dejamos pasar los datos al servlet
            chain.doFilter(request, response);
        }
    }

    private HashMap<String, String> validarPrograma(ServletRequest request) {

        HashMap<String, String> errores = new HashMap<>();

        final String titulo = request.getParameter("titulo"),
                descripcion = request.getParameter("descripcion"),
                tipoBusqueda = request.getParameter("tipoBusqueda");


        // realizamos algunas validaciones 
        if (titulo.length() > 10) {
            errores.put("titulo", "el titulo no debe ser mayor a 10 caracteres");
        }
        if (descripcion.length() > 10) {
            errores.put("descripcion", "el descripcion no debe ser mayor a 10 caracteres");
        }


        if (TipoBusqueda.Completa == TipoBusqueda.obtenerPorCodigo(Integer.parseInt(tipoBusqueda))) {
            if (titulo.isEmpty()) {
                errores.put("titulo", "el titulo no debe estar vacio en una busqueda Completa");
            }

            if (descripcion.isEmpty()) {
                errores.put("descripcion", "descripcion no debe estar vacio en una busqueda Completa");
            }
        } else {
            if (titulo.isEmpty() && descripcion.isEmpty()) {
                errores.put("ambos", "por lo menos debe llenar un campo en su busqueda Parcial");
            }
        }





        return errores;
    }

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;

    }

    @Override
    public void destroy() {
    }
}
