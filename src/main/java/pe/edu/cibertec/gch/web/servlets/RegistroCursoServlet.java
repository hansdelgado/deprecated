/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import pe.edu.cibertec.gch.dao.CursoDao;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.logica.GestorCurso;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.modelo.EstadoActividad;


/**
 *
 * @author JAVA_MJ
 */
@WebServlet(name = "RegistroCursoServlet", urlPatterns = {"/registrarCurso"})
public class RegistroCursoServlet extends HttpServlet {
    private GestorCurso gestorCurso = new GestorCurso();
    
    private CursoDao cursoDao = FactoryDao.getInstance().getCursoDao();
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        final String codigo = req.getParameter("codigo"),
                nombre = req.getParameter("nombre"),
                 descripcion = req.getParameter("descripcion"),
                 objetivos = req.getParameter("objetivos"),
                 requisitos = req.getParameter("requisitos"),
                estado = req.getParameter("estado");
        int duracion = Integer.parseInt(req.getParameter("duracion"));
        
        System.out.println("Cadena:"+nombre+"-"+descripcion+"-"+objetivos+"-"+requisitos);
        
        Curso nuevoCurso = new Curso();
        nuevoCurso.setCodigo(codigo);
        nuevoCurso.setNombre(nombre);
        nuevoCurso.setDescripcion(descripcion);
        nuevoCurso.setObjetivos(objetivos);
        nuevoCurso.setRequisitos(requisitos);
        nuevoCurso.setDuracion(duracion);
        nuevoCurso.setEstado(EstadoActividad.Valido);
        
        //gestorCurso.registrar(nuevoCurso);
        cursoDao.registrar(nuevoCurso);
        resp.sendRedirect("listarCursos");
    }
}
