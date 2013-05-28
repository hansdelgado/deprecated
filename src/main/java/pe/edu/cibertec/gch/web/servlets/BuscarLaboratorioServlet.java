/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorLaboratorio;
import pe.edu.cibertec.gch.modelo.Laboratorio;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author JAVA_MJ
 */
@WebServlet(name = "BuscarLaboratorioServlet", urlPatterns = {"/buscarLaboratorio"})
public class BuscarLaboratorioServlet extends HttpServlet {

   private GestorLaboratorio gestorLaboratorio = new GestorLaboratorio();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String nombre = req.getParameter("nombre"),
                descripcion = req.getParameter("descripcion"),
                local = req.getParameter("local"),
                tipoBusqueda = req.getParameter("tipoBusqueda");
        
        //Segun el codigo de tipo de busqueda obtener el valor del enum.
        TipoBusqueda tipoBusquedaEnum = TipoBusqueda.obtenerPorCodigo(Integer.parseInt(tipoBusqueda));
        
        List<Laboratorio> laboratorios = gestorLaboratorio.listarSegun(nombre, 
                descripcion, local, tipoBusquedaEnum);
        req.setAttribute("laboratorios", laboratorios);
        // pinta los datos en el listado
        GchServletUtils.reenviarAModulo("laboratorio", req, resp);
    }

}
