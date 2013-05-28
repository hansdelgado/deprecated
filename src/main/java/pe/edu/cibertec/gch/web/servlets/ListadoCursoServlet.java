package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para listar cursos.
 */
@WebServlet(name = "ListadoCursoServlet", urlPatterns = {"/listarCursos"})
public class ListadoCursoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GchServletUtils.reenviarAModulo("curso", req, resp);
    }

}
