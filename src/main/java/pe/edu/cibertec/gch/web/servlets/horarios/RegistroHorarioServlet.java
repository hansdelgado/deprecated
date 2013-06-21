package pe.edu.cibertec.gch.web.servlets.horarios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.services.HorarioService;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Horario;

/**
 *
 * @author Student
 */
@WebServlet(name = "RegistroHorarioServlet", urlPatterns = {"/registrarHorario"})
public class RegistroHorarioServlet extends HttpServlet {
    
    private HorarioService horarioService = new HorarioService();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String codigo = req.getParameter("codigo"),
                descripcion = req.getParameter("descripcion"),
                inicio = req.getParameter("inicio"),
                fin = req.getParameter("fin"),
                estado = req.getParameter("estado");
        
        Horario nuevoHorario = new Horario();
        nuevoHorario.setCodigo(codigo);
        nuevoHorario.setDescripcion(descripcion);
        nuevoHorario.setMomentoInicio(Integer.parseInt(inicio));
        nuevoHorario.setMomentoFin(Integer.parseInt(fin));
        nuevoHorario.setEstado(estado.equals("1") ? EstadoActividad.Valido : EstadoActividad.Obsoleto);
        horarioService.registrar(nuevoHorario);
        resp.sendRedirect("listarHorarios");
    }
    
}
