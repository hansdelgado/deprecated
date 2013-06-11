package pe.edu.cibertec.gch.web.servlets.horarios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.FactoryDao;

/**
 *
 * @author abedregal
 */
@WebServlet(name = "EliminarHorario", urlPatterns = {"/eliminarHorario"})
public class EliminarHorarioServlet extends HttpServlet {
    
private FactoryDao factoryDao = FactoryDao.getFactory();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String codigo = req.getParameter("codigo");
        factoryDao.getHorarioDao().eliminarPorCodigo(codigo);
        resp.sendRedirect("listarHorarios");
    }
    
}
