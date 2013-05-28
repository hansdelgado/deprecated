package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.gch.logica.GestorPrograma;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Moneda;
import pe.edu.cibertec.gch.modelo.Programa;

/**
 * Servlet para registrar un profesor.
 */
@WebServlet(name = "RegistroProgramaServlet", urlPatterns = {"/registrarPrograma"})
public class RegistroProgramaServlet extends HttpServlet {

    private GestorPrograma gestorPrograma = new GestorPrograma();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String codigo = req.getParameter("codigo"),
                titulo = req.getParameter("titulo"),
                descripcion = req.getParameter("descripcion"),
                objetivos = req.getParameter("objetivos"),
                requisitos = req.getParameter("requisitos"),
                moneda = req.getParameter("moneda"),
                fecha = req.getParameter("fecha"),
                duracion = req.getParameter("duracion"),
                precio = req.getParameter("precio");
           int dia = Integer.parseInt(fecha.substring(8)),
                mes = Integer.parseInt(fecha.substring(5, 7)),
                ano = Integer.parseInt(fecha.substring(0, 4));
        final Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.clear();
        cal.set(ano, mes - 1, dia);
     


        Programa nuevoPrograma = new Programa();
        nuevoPrograma.setCodigo(codigo);
        nuevoPrograma.setTitulo(titulo);
        nuevoPrograma.setDescripcion(descripcion);
        nuevoPrograma.setObjetivos(objetivos);
        nuevoPrograma.setRequisitos(requisitos);
        nuevoPrograma.setMoneda(moneda.equals("NS") ? Moneda.NuevosSoles : Moneda.DolaresUS);
        nuevoPrograma.setPrecio(Double.parseDouble(precio));
        nuevoPrograma.setEstado(EstadoActividad.Valido);
        nuevoPrograma.setFechaInicial(new Date());
        nuevoPrograma.setDuracion(Integer.parseInt(duracion));

        

        gestorPrograma.registrar(nuevoPrograma);
        
        resp.sendRedirect("listarProgramas");
    }
}
