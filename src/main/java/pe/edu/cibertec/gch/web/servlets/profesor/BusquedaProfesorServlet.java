package pe.edu.cibertec.gch.web.servlets.profesor;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorProfesor;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 * Servlet para buscar profesores.
 */
@WebServlet(name = "BusquedaProfesorServlet", urlPatterns = {"/buscarProfesores"})
public class BusquedaProfesorServlet extends HttpServlet {

    private GestorProfesor gestorProfesor = new GestorProfesor();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String textoNombres = req.getParameter("nombres"),
                textoApellidoPaterno = req.getParameter("apellidoPaterno"),
                textoApellidoMaterno = req.getParameter("apellidoMaterno"),
                textoTipoBusqueda = req.getParameter("tipoBusqueda");
        // segun el tipo de codigo obtenemos el tipo de busqueda
        TipoBusqueda tipoBusqueda = TipoBusqueda.obtenerPorCodigo(Integer.parseInt(textoTipoBusqueda));
        // trae los profesores en la fuente de datos
        List<Profesor> profesores = gestorProfesor.listarSegun(textoNombres,
                textoApellidoPaterno, textoApellidoMaterno, tipoBusqueda);
        // almacena resultado en el request
        req.setAttribute("profesores", profesores);
        // pinta los datos en el listado
        GchServletUtils.reenviarAModulo("profesor", req, resp);
    }
}
