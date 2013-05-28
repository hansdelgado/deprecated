/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author JAVA_MJ
 */
@WebServlet(name = "BuscarProgramasServlet", urlPatterns = {"/buscarProgramas"})
public class BuscarProgramaServlet extends HttpServlet {
    
    private GestorPrograma gestorPrograma = new GestorPrograma();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String titulo = req.getParameter("titulo"),
                descripcion = req.getParameter("descripcion"),
                tipoBusqueda = req.getParameter("tipoBusqueda");
        
        //Segun el codigo de tipo de busqueda obtener el valor del enum.
        TipoBusqueda tipoBusquedaEnum = TipoBusqueda.obtenerPorCodigo(Integer.parseInt(tipoBusqueda));
        
        List<Programa> programas = gestorPrograma.listarSegun(titulo, descripcion, tipoBusquedaEnum);
        req.setAttribute("programa", programas);
        // pinta los datos en el listado
        GchServletUtils.reenviarAModulo("programa", req, resp);
    }
    
}
