package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorCurso;
import pe.edu.cibertec.gch.modelo.Curso;

/**
 * Servlet para listar cursos.
 */
@WebServlet(name = "ListadoCursoServlet", urlPatterns = {"/listarCursos"})
public class ListadoCursoServlet extends HttpServlet {

   /* private static String codigo;
    static {
      codigo = "1";
    }*/
    
    private GestorCurso gestorCurso= new GestorCurso();

    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
       // String codigo = req.getParameter("codigo");
        
        //List<Curso> cursos = new ArrayList<Curso>();
       List<Curso> cursos = gestorCurso.listarTodos();
        //cursos.add(gestorCurso.consultarPorCodigo(this.codigo));
        //cursos.add(gestorCurso.consultarPorCodigo(codigo));
        //Curso cursos =  gestorCurso.consultarPorCodigo(codigo);
        // almacena resultado en el request
        req.setAttribute("cursos", cursos);
        // pinta los datos en el listado
        GchServletUtils.reenviarAModulo("curso", req, resp);
        
        //DFDF
    }

}
