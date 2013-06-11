package pe.edu.cibertec.gch.web.servlets.programa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.ProgramaDao;

/**
 *
 * @author LENOVO
 */
@WebServlet(name = "EliminarProgramaServlet", urlPatterns = {"/irEliminarPrograma"})
public class EliminarProgramaServlet extends HttpServlet {

    private ProgramaDao programaDao = FactoryDao.getInstance().getProgramaDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        String codigo = req.getParameter("codigo");
        programaDao.eliminarPorCodigo(codigo);
        
        req.setAttribute("mensaje", "Su programa fué eliminado con éxito");
        ListadoProgramaServlet listadoProgramaServlet = new ListadoProgramaServlet();
        listadoProgramaServlet.doGet(req, response);
    }
}
