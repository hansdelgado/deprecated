package pe.edu.cibertec.gch.web.servlets.programa;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.ProgramaDao;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.Moneda;

/**
 * Servlet para modificar un nuevo programa.
 */
@WebServlet(name = "ActualizaProgramaServlet", urlPatterns = {"/actualizarPrograma"})
public class ActualizaProgramaServlet extends HttpServlet {

    private ProgramaDao programaDao = FactoryDao.getInstance().getProgramaDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String moneda = req.getParameter("moneda");
        
        Programa modiPrograma = new Programa();
        modiPrograma.setCodigo(req.getParameter("codigo"));
        modiPrograma.setTitulo(req.getParameter("titulo").toUpperCase());
        modiPrograma.setDescripcion(req.getParameter("descripcion"));
        modiPrograma.setObjetivos(req.getParameter("objetivos"));
        modiPrograma.setRequisitos(req.getParameter("requisitos"));
        modiPrograma.setMoneda(moneda.equals("NS") ? Moneda.NuevosSoles : Moneda.DolaresUS);
        modiPrograma.setPrecio(Double.parseDouble(req.getParameter("precio")));
        modiPrograma.setEstado(EstadoActividad.Valido);
   //     modiPrograma.setFechaInicial(fechaToDate(req.getParameter("fecha")));
        modiPrograma.setDuracion(Integer.parseInt(req.getParameter("duracion")));
       
        programaDao.modificarPorCodigo(modiPrograma);
        req.setAttribute("mensaje", "Su programa fué modificado con éxito");
        ListadoProgramaServlet listadoProgramaServlet = new ListadoProgramaServlet();
        listadoProgramaServlet.doGet(req, resp);
    }

    
    private Date fechaToDate(String fecha) {

        int dia = Integer.parseInt(fecha.substring(8)),
                mes = Integer.parseInt(fecha.substring(5, 7)),
                ano = Integer.parseInt(fecha.substring(0, 4));
        final Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.clear();
        cal.set(ano, mes - 1, dia);

        return cal.getTime();
    }
}
