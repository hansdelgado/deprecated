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

/**
 *
 * @author Paolo
 */
@WebFilter(filterName = "ValidacionInputFilter", urlPatterns = {"/*"})
public class ValidacionInputFilter implements Filter {

    private static final Logger LOG = Logger.getLogger(ValidacionInputFilter.class.getName());
    private FilterConfig filterConfig = null;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        Map<String, String> errores = new HashMap<>();
        req.removeAttribute("errores");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        if (req.getServletPath().startsWith("buscarProfesor", 1)) {
            // Si se intenta buscar profesores
            
            // recuperar input de listado de profesores
            String textoBusquedaProfesorNombres = req.getParameter("nombres"),
                    textoBusquedaProfesorApellidoPaterno = req.getParameter("apellidoPaterno"),
                    textoBusquedaProfesorApellidoMaterno = req.getParameter("apellidoMaterno"),
                    textoBusquedaProfesorTipoBusqueda = req.getParameter("tipoBusqueda");

            // por cada parametro, validar
            if (textoBusquedaProfesorNombres.length() > 50) {
                errores.put("nombres", "La longitud del nombre no debe exceder los 100 caracteres");
            }
            if (textoBusquedaProfesorApellidoPaterno.length() > 50) {
                errores.put("apellidoPaterno", "La longitud del apellido paterno no debe exceder los 50 caracteres");
            }
            if (textoBusquedaProfesorApellidoMaterno.length() > 50) {
                errores.put("apellidoMaterno", "La longitud del apellido materno no debe exceder los 50 caracteres");
            }
            if (!textoBusquedaProfesorTipoBusqueda.matches("1|2")) {
                errores.put("tipoBusqueda", "Se debe seleccionar un tipo de b&uacute;squeda v&aacute;lido");
            }

            // determinacion del lugar a donde debe ir el request
            if (errores.isEmpty()) {
                chain.doFilter(request, response);
            } else {
                req.setAttribute("errores", errores);
                req.getRequestDispatcher("view/profesor/index.jsp").forward(request, response);
            }
        } else if (req.getServletPath().startsWith("registrarProfesor", 1)) { 
            // Si se intenta registrar un profesor

            // recuperar input de listado de profesores
            String textoRegistroProfesorCodigo = req.getParameter("codigo"),
                    textoRegistroProfesorNombres = req.getParameter("nombres"),
                    textoRegistroProfesorApellidoPaterno = req.getParameter("apellidoPaterno"),
                    textoRegistroProfesorApellidoMaterno = req.getParameter("apellidoMaterno"),
                    textoRegistroProfesorDireccion = req.getParameter("direccion"),
                    textoRegistroProfesorReferencia = req.getParameter("referencia"),
                    textoRegistroProfesorFechaNacimiento = req.getParameter("fechaNacimiento"),
                    textoRegistroProfesorSexo = req.getParameter("sexo"),
                    textoRegistroProfesorEstadoProfesor = req.getParameter("estado");

            // por cada parametro, validar
            if (textoRegistroProfesorCodigo.isEmpty() || !textoRegistroProfesorCodigo.matches("\\w{5,6}")) {
                errores.put("codigo", "El codigo es obligatorio y debe tener cinco o seis caracteres");
            }
            if (textoRegistroProfesorNombres.isEmpty() || textoRegistroProfesorNombres.length() > 50) {
                errores.put("nombres", "Los nombres son obligatorios y se permite hasta 50 caracteres");
            }
            if (textoRegistroProfesorApellidoPaterno.isEmpty() || textoRegistroProfesorApellidoPaterno.length() > 50) {
                errores.put("apellidoPaterno", "El apellido paterno es obligatorio y se permite hasta 50 caracteres");
            }
            if (!textoRegistroProfesorApellidoMaterno.isEmpty() && textoRegistroProfesorNombres.length() > 50) {
                errores.put("apellidoMaterno", "El apellido materno puede tener hasta 50 caracteres");
            }
            if (!textoRegistroProfesorDireccion.isEmpty() && textoRegistroProfesorDireccion.length() > 400) {
                errores.put("direccion", "La direcci&oacute;n puede tener hasta 400 caracteres");
            }
            if (!textoRegistroProfesorReferencia.isEmpty() && textoRegistroProfesorReferencia.length() > 400) {
                errores.put("referencia", "La referencia puede tener hasta 400 caracteres");
            }
            if (!textoRegistroProfesorFechaNacimiento.isEmpty() && !textoRegistroProfesorFechaNacimiento.matches("\\d{1,4}[/-]\\d{1,2}[/-]\\d{1,4}")) {
                try {
                    int dia = Integer.parseInt(textoRegistroProfesorFechaNacimiento.substring(8)),
                            mes = Integer.parseInt(textoRegistroProfesorFechaNacimiento.substring(5, 7)),
                            ano = Integer.parseInt(textoRegistroProfesorFechaNacimiento.substring(0, 4));
                    Calendar cal = Calendar.getInstance();
                    cal.setLenient(false);
                    cal.clear();
                    cal.set(ano, mes - 1, dia);
                } catch (Exception e) {
                    LOG.warning("Error al convertir la fecha de nacimiento del profesor");
                    errores.put("fechaNacimiento", "La fecha de nacimiento no es v&aacute;lida");
                }
            }
            if (null != textoRegistroProfesorSexo && !textoRegistroProfesorSexo.isEmpty() && !textoRegistroProfesorSexo.matches("m|f")) {
                errores.put("sexo", "El g&eacute;nero indicado no es v&aacute;lido");
            }
            if (!textoRegistroProfesorEstadoProfesor.isEmpty() && !textoRegistroProfesorEstadoProfesor.matches("[1-4]")) {
                errores.put("estado", "El estado indicado no es v&aacute;lido");
            }
            // determinacion del lugar a donde debe ir el request
            if (errores.isEmpty()) {
                chain.doFilter(request, response);
            } else {
                req.setAttribute("errores", errores);
                req.getRequestDispatcher("view/profesor/registro.jsp").forward(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {
    }
}
