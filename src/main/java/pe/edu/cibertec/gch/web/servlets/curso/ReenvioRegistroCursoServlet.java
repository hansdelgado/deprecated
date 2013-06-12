/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.curso;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAVA_MJ
 */
@WebServlet(name = "ReenvioRegistroCursoServlet", urlPatterns = {"/irRegistroCurso"})
public class ReenvioRegistroCursoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GchServletUtils.reenviarARegistro("curso", req, resp);
        //req.getRequestDispatcher(null)
    }

}
