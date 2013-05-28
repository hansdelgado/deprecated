package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.HorarioDao;
import pe.edu.cibertec.gch.modelo.Horario;

/**
 *
 * @author Student
 */
@WebServlet(name = "RegistroHorarioServlet", urlPatterns = {"/registrarHorario"})
public class RegistroHorarioServlet extends HttpServlet {
    
    private HorarioDao horarioDao = FactoryDao.getInstance().getHorarioDao();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String codigo = req.getParameter("codigo"),
                descripcion = req.getParameter("descripcion");
        
        Horario nuevoHorario = new Horario();
        nuevoHorario.setCodigo(codigo);
        nuevoHorario.setDescripcion(descripcion);

        horarioDao.registrar(nuevoHorario);
        resp.sendRedirect("listarHorarios");
    }
    
}
