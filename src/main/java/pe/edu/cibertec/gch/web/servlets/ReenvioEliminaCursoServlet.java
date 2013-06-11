package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.CursoDao;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.CursoDao;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 * Servlet para reenviar al registro de programa
 */
@WebServlet(name = "ReenvioEliminaCursoServlet", urlPatterns = {"/irEliminarCurso"})
public class ReenvioEliminaCursoServlet extends HttpServlet {
     private CursoDao cursoDao = FactoryDao.getInstance().getCursoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
             String codigo = req.getParameter("codigo");
             Curso curso = cursoDao.eliminarPorCodigoCurso(codigo);
             //req.setAttribute("curso", curso);
             resp.sendRedirect("listarCursos");
        
             GchServletUtils.reenviarAEliminar("curso", req, resp);
        } catch (Exception e) {
            System.out.println("error"+e);
        }
        
    }
}
