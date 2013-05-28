/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAVA_MJ
 */
@WebServlet(name = "ReenvioRegistroLaboratorioServlet", urlPatterns = {"/irRegistroLaboratorio"})
public class ReenvioRegistroLaboratorioServlet extends HttpServlet {


   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/laboratorio/registro.jsp");
        requestDispatcher.forward(req, resp);
    }

   
}
