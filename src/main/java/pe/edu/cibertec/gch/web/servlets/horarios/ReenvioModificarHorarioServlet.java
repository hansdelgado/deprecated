package pe.edu.cibertec.gch.web.servlets.horarios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.services.HorarioService;

/**
 *
 * @author abedregal
 */
@WebServlet(name = "ReenvioModificarHorario", urlPatterns = {"/irModificarHorario"})
public class ReenvioModificarHorarioServlet extends HttpServlet {
    
    private HorarioService horarioService = new HorarioService();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("horario", horarioService.consultarPorCodigo(req.getParameter("codigo")));
        req.getRequestDispatcher("view/horario/modificar.jsp").forward(req, resp);
    }    
    
}
