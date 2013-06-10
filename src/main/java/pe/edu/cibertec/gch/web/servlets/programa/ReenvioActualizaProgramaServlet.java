package pe.edu.cibertec.gch.web.servlets.programa;

import java.io.IOException;
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
 * Servlet para reenviar al registro de programa
 */
@WebServlet(name = "ReenvioActualizaPrograma", urlPatterns = {"/irActualizaPrograma"})
public class ReenvioActualizaProgramaServlet extends HttpServlet {
     private ProgramaDao programaDao = FactoryDao.getInstance().getProgramaDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String codigo = req.getParameter("codigo");
        
        Programa progr = programaDao.consultarPorCodigo(codigo);
        req.setAttribute("programa", progr);
        
        GchServletUtils.reenviarAModificar("programa", req, resp);
    }
}
