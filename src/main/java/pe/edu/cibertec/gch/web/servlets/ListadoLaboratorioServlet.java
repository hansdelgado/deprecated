package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorFactory;
import pe.edu.cibertec.gch.modelo.Laboratorio;


/**
 * Servlet para listar laboratorios.
 */
@WebServlet(name = "ListadoLaboratorioServlet", urlPatterns = {"/listarLaboratorios"})
public class ListadoLaboratorioServlet extends HttpServlet {

    @Override
   
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trae los profesores en la fuente de datos
        List<Laboratorio> laboratorios = GestorFactory.getGestorLaboratorio().listarTodos();
             
        // almacena resultado en el request
        req.setAttribute("laboratorios", laboratorios);
        // pinta los datos en el listado
        GchServletUtils.reenviarAModulo("laboratorio", req, resp);
    }

}
