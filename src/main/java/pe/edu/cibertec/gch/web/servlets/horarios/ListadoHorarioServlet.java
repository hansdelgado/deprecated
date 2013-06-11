package pe.edu.cibertec.gch.web.servlets.horarios;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.modelo.Horario;
import pe.edu.cibertec.gch.web.servlets.GchServletUtils;

/**
 * Servlet para listar los horarios.
 */
@WebServlet(name = "ListadoHorarioServlet", urlPatterns = {"/listarHorarios"})
public class ListadoHorarioServlet extends HttpServlet {

    FactoryDao factoryDao = FactoryDao.getFactory();
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // trae los profesores en la fuente de datos
        List<Horario> horarios = factoryDao.getHorarioDao().listarTodos();
        // almacena resultado en el request
        req.setAttribute("horarios", horarios);
        // pinta los datos en el listado
        GchServletUtils.reenviarAModulo("horario", req, resp);
    }

}
