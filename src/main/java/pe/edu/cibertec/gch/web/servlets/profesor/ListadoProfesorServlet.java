package pe.edu.cibertec.gch.web.servlets.profesor;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.gestores.GestorProfesor;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 * Servlet para listar profesores.
 */
@WebServlet(name = "ListadoProfesorServlet", urlPatterns = {"/listarProfesores"})
public class ListadoProfesorServlet extends HttpServlet {

    private GestorProfesor gestorProfesor = new GestorProfesor();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trae los profesores en la fuente de datos
        List<Profesor> profesores = gestorProfesor.listarTodos();
        // almacena resultado en el request
        req.setAttribute("profesores", profesores);
        // pinta los datos en el listado
        GchServletUtils.reenviarAModulo("profesor", req, resp);
    }
}
