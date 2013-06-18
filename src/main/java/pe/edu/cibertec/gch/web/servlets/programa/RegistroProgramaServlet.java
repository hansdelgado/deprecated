package pe.edu.cibertec.gch.web.servlets.programa;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.ProgramaDao;
import pe.edu.cibertec.gch.helper.GCH;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Moneda;
import pe.edu.cibertec.gch.modelo.Programa;

/**
 * Servlet para registrar un nuevo programa.
 */
//@WebServlet(name = "RegistroProgramaServlet", urlPatterns = {"/registrarPrograma"})
public class RegistroProgramaServlet extends HttpServlet {

    private ProgramaDao programaDao = FactoryDao.getInstance().getProgramaDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String moneda = req.getParameter("moneda");

        Programa nuevoPrograma = new Programa();
        nuevoPrograma.setCodigo(req.getParameter("codigo"));
        nuevoPrograma.setTitulo(req.getParameter("titulo").toUpperCase());
        nuevoPrograma.setDescripcion(req.getParameter("descripcion"));
        nuevoPrograma.setObjetivos(req.getParameter("objetivos"));
        nuevoPrograma.setRequisitos(req.getParameter("requisitos"));
        nuevoPrograma.setMoneda(moneda.equals("NS") ? Moneda.NuevosSoles : Moneda.DolaresUS);
        nuevoPrograma.setPrecio(Double.parseDouble(req.getParameter("precio")));
        nuevoPrograma.setEstado(EstadoActividad.Valido);
        nuevoPrograma.setFechaInicial(GCH.fechaToDate(req.getParameter("fecha")));
        nuevoPrograma.setDuracion(Integer.parseInt(req.getParameter("duracion")));
                
        programaDao.registrar(nuevoPrograma);
        req.setAttribute("mensaje", "Su nuevo programa '" + nuevoPrograma.getTitulo() + "' fué agregado con éxito");
        ListadoProgramaServlet listadoProgramaServlet = new ListadoProgramaServlet();
        listadoProgramaServlet.doGet(req, resp);
    }

 
}
