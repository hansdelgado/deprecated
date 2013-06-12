/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.curso;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorCurso;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author JAVA_MJ
 */
@WebServlet(name = "BuscarCursoServlet", urlPatterns = {"/buscarCurso"})
public class BuscarCursoServlet extends HttpServlet {
    
    private GestorCurso gestorCurso = new GestorCurso();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String codigo = req.getParameter("codigo"),
                nombre = req.getParameter("nombre"),
                descripcion = req.getParameter("descripcion"),
                objetivos   = req.getParameter("objetivos"),
                requisitos = req.getParameter("requisitos"),
                estado = req.getParameter("estado"),
                tipoBusqueda = req.getParameter("tipoBusqueda");
        String duracion = req.getParameter("duracion");
        
        //Segun el codigo de tipo de busqueda obtener el valor del enum.
        TipoBusqueda tipoBusquedaEnum = TipoBusqueda.obtenerPorCodigo(Integer.parseInt(tipoBusqueda));
        
        List<Curso> cursos = gestorCurso.listarSegun(codigo,nombre,descripcion,objetivos ,requisitos ,estado , duracion, tipoBusquedaEnum);
        
        req.setAttribute("cursos", cursos);
        // pinta los datos en el listado
        //GchServletUtils.reenviarAModulo("curso", req, resp);
    }
    
}
