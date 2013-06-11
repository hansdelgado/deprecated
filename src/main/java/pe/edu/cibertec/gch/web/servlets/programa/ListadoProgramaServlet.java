package pe.edu.cibertec.gch.web.servlets.programa;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.ProgramaDao;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 * Servlet para listar programas.
 */
@WebServlet(name = "ListadoProgramaServlet", urlPatterns = {"/listarProgramas"})
public class ListadoProgramaServlet extends HttpServlet {

    private ProgramaDao programaDao = FactoryDao.getInstance().getProgramaDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Programa> programas = programaDao.listarTodos();
        req.setAttribute("programa", programas);
        GchServletUtils.reenviarAModulo("programa", req, resp);

    }
}
