package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorPrograma;
import pe.edu.cibertec.gch.modelo.Programa;

/**
 * Servlet para listar programas.
 */
@WebServlet(name = "ListadoProgramaServlet", urlPatterns = {"/listarProgramas"})
public class ListadoProgramaServlet extends HttpServlet {
    
    private GestorPrograma gestorPrograma = new GestorPrograma();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
             
        List<Programa> programas = gestorPrograma.listarTodos();
       
        req.setAttribute("programa", programas);
      
        GchServletUtils.reenviarAModulo("programa", req, resp);
        
    }

   
   

}
