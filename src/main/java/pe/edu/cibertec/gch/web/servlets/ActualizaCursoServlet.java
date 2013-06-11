package pe.edu.cibertec.gch.web.servlets.programa;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.CursoDao;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.modelo.Moneda;

/**
 * Servlet para modificar un nuevo programa.
 */
@WebServlet(name = "ActualizaCursoServlet", urlPatterns = {"/actualizarCurso"})
public class ActualizaCursoServlet extends HttpServlet {

    private CursoDao cursoDao = FactoryDao.getInstance().getCursoDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Curso modiCurso = new Curso();
        modiCurso.setCodigo(req.getParameter("codigo"));
        modiCurso.setNombre(req.getParameter("nombre"));
        modiCurso.setDescripcion(req.getParameter("descripcion"));
        modiCurso.setObjetivos(req.getParameter("objetivos"));
        modiCurso.setRequisitos(req.getParameter("requisitos"));
        if((req.getParameter("estado")).equalsIgnoreCase("valido")){
             modiCurso.setEstado(EstadoActividad.Valido);
        }else{
             modiCurso.setEstado(EstadoActividad.Obsoleto);
        }
        modiCurso.setDuracion(Integer.parseInt(req.getParameter("duracion")));
       
        cursoDao.modificarPorCodigo(modiCurso);
        resp.sendRedirect("listarCursos");
    }

}
