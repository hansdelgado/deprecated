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
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 *
 * @author grupoPrograma
 */
@WebFilter(filterName = "ValidacionRegistroProgramaFilter", urlPatterns = {"/registrarPrograma", "/actualizarPrograma"})
public class ValidacionRegistroProgramaFilter implements Filter {

    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    public ValidacionRegistroProgramaFilter() {
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

            String alias = ((HttpServletRequest) request).getServletPath();
            if (alias.equals("/actualizarPrograma")) {
                GchServletUtils.reenviarAModificar("programa", (HttpServletRequest) request, (HttpServletResponse) response);
            }
            GchServletUtils.reenviarARegistro("programa", (HttpServletRequest) request, (HttpServletResponse) response);
        } else {
            // dejamos pasar los datos al servlet
            chain.doFilter(request, response);
        }
    }

    private HashMap<String, String> validarPrograma(ServletRequest request) {

        HashMap<String, String> errores = new HashMap<>();

        final String codigo = request.getParameter("codigo"),
                titulo = request.getParameter("titulo"),
                descripcion = request.getParameter("descripcion"),
                objetivos = request.getParameter("objetivos"),
                requisitos = request.getParameter("requisitos"),
                moneda = request.getParameter("moneda"),
                fecha = request.getParameter("fecha"),
                duracion = request.getParameter("duracion"),
                precio = request.getParameter("precio");

        // realizamos algunas validaciones 
        try {
            Integer.parseInt(codigo);
        } catch (NumberFormatException nfe) {
            errores.put("codigo", "el codigo debe contener solo numeros");
        }

        try {
            if (Integer.parseInt(duracion) > 140) {
                errores.put("duracion", "la duracion maxima es de 140");
            }
        } catch (NumberFormatException nfe) {
            errores.put("duracion", "la duracion debe contener solo numeros");
        }

        try {
            if (Double.parseDouble(precio) > 5000) {
                errores.put("precio", "el precio maximo es 5000 soles");
            }
        } catch (NumberFormatException nfe) {
            errores.put("precio", "el precio debe contener solo numeros");
        }

        if (titulo.length() > 45) {
            errores.put("titulo", "el titulo no debe ser mayor a 45 caracteres");
        }
        if (descripcion.length() > 45) {
            errores.put("descripcion", "el descripcion no debe ser mayor a 45 caracteres");
        }
        if (objetivos.length() > 45) {
            errores.put("objetivos", "objetivos puede tener hasta 45 caracteres");
        }
        if (requisitos.length() > 45) {
            errores.put("requisitos", "requisitos puede tener hasta 45 caracteres");
        }

        if (titulo.isEmpty()) {
            errores.put("titulo", "el titulo no debe estar vacio");
        }
        if (descripcion.isEmpty()) {
            errores.put("descripcion", "descripcion no debe estar vacio");
        }
        if (objetivos.isEmpty()) {
            errores.put("objetivos", "los objetivos no debe estar vacio");
        }
        if (requisitos.isEmpty()) {
            errores.put("requisitos", "requisitos no debe estar vacio");
        }
        
        if (moneda.isEmpty()) {
            errores.put("moneda", "debe seleccionar su tipo de moneda");
        }

        if (!fecha.matches("\\d{1,4}[/-]\\d{1,2}[/-]\\d{1,4}")) {
            errores.put("requisitos", "la fecha ingresada no cumple con el formato. (ejemplo 12/05/2013) ");
        }

        return errores;
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
}
