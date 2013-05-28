package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet para reenviar al registro de programa
 */
@WebServlet(name = "ReenvioRegistroPrograma", urlPatterns = {"/irRegistroPrograma"})
public class ReenvioRegistroProgramaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GchServletUtils.reenviarARegistro("programa", req, resp);
    }
}
