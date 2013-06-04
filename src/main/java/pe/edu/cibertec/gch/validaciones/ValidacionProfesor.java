package pe.edu.cibertec.gch.validaciones;

import java.util.Calendar;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class ValidacionProfesor extends Validacion {

    private static final Logger LOG = Logger.getLogger(ValidacionProfesor.class.getName());

    @Override
    public void validar(HttpServletRequest req) {

        if (req.getServletPath().startsWith("buscarProfesor", 1)) {
            // Si se intenta buscar profesores

            // recuperar input de listado de profesores
            String textoBusquedaProfesorNombres = req.getParameter("nombres"),
                    textoBusquedaProfesorApellidoPaterno = req.getParameter("apellidoPaterno"),
                    textoBusquedaProfesorApellidoMaterno = req.getParameter("apellidoMaterno"),
                    textoBusquedaProfesorTipoBusqueda = req.getParameter("tipoBusqueda");
            validarBusqueda(textoBusquedaProfesorNombres, textoBusquedaProfesorApellidoPaterno, textoBusquedaProfesorApellidoMaterno, textoBusquedaProfesorTipoBusqueda);

            setPaginaReenvio("view/profesor/index.jsp");

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
            validarRegistro(textoRegistroProfesorCodigo, errores, textoRegistroProfesorNombres, textoRegistroProfesorApellidoPaterno, textoRegistroProfesorApellidoMaterno, textoRegistroProfesorDireccion, textoRegistroProfesorReferencia, textoRegistroProfesorFechaNacimiento, textoRegistroProfesorSexo, textoRegistroProfesorEstadoProfesor);

            setPaginaReenvio("view/profesor/registro.jsp");
        }
    }

    private void validarBusqueda(String textoBusquedaProfesorNombres, String textoBusquedaProfesorApellidoPaterno, String textoBusquedaProfesorApellidoMaterno, String textoBusquedaProfesorTipoBusqueda) {
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
    }

    private void validarRegistro(String textoRegistroProfesorCodigo, Map<String, String> errores, String textoRegistroProfesorNombres, String textoRegistroProfesorApellidoPaterno, String textoRegistroProfesorApellidoMaterno, String textoRegistroProfesorDireccion, String textoRegistroProfesorReferencia, String textoRegistroProfesorFechaNacimiento, String textoRegistroProfesorSexo, String textoRegistroProfesorEstadoProfesor) {
        // por cada parametro, validar
        if (textoRegistroProfesorCodigo.isEmpty() || !textoRegistroProfesorCodigo.matches("\\w{5,8}")) {
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
    }
}
