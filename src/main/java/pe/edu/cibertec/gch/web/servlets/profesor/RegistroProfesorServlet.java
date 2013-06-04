package pe.edu.cibertec.gch.web.servlets.profesor;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorProfesor;
import pe.edu.cibertec.gch.modelo.EstadoProfesor;
import pe.edu.cibertec.gch.modelo.Genero;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 * Servlet para registrar un profesor.
 */
@WebServlet(name = "RegistroProfesorServlet", urlPatterns = {"/registrarProfesor"})
public class RegistroProfesorServlet extends HttpServlet {

    private GestorProfesor gestorProfesor = new GestorProfesor();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String codigo = req.getParameter("codigo"),
                nombres = req.getParameter("nombres"),
                apellidoPaterno = req.getParameter("apellidoPaterno"),
                apellidoMaterno = req.getParameter("apellidoMaterno"),
                direccion = req.getParameter("direccion"),
                referencia = req.getParameter("referencia"),
                fechaNacimiento = req.getParameter("fechaNacimiento"),
                sexo = req.getParameter("sexo");

        Profesor nuevoProfesor = new Profesor().conCodigo(codigo)
                .conNombres(nombres)
                .conApellidoPaterno(apellidoPaterno)
                .conApellidoMaterno(apellidoMaterno)
                .conDireccion(direccion)
                .conReferencia(referencia)
                .conSexo(Genero.obtenerSegun(sexo))
                .conEstado(EstadoProfesor.Activo);
        
        if (!fechaNacimiento.isEmpty()) {
            int dia = Integer.parseInt(fechaNacimiento.substring(8)),
                    mes = Integer.parseInt(fechaNacimiento.substring(5, 7)),
                    ano = Integer.parseInt(fechaNacimiento.substring(0, 4));
            final Calendar cal = Calendar.getInstance();
            cal.setLenient(false);
            cal.clear();
            cal.set(ano, mes - 1, dia);
            nuevoProfesor = nuevoProfesor.conFechaNacimiento(cal.getTime());
        }
        gestorProfesor.registrar(nuevoProfesor);
        resp.sendRedirect("listarProfesores");
    }
}
