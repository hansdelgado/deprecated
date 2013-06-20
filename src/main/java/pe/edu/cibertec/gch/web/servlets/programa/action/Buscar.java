package pe.edu.cibertec.gch.web.servlets.programa.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author DanJoas
 */
public class Buscar extends ActionSupport {

    private List<Programa> programas;
    private String titulo;
    private String descripcion;
    private String tipoBusqueda;

    @Override
    public String execute() throws Exception {
        TipoBusqueda tipoBusquedaEnum = TipoBusqueda.obtenerPorCodigo(Integer.parseInt(getTipoBusqueda()));
        programas = FactoryDao.getInstance().getProgramaDao().listarSegun(getTitulo(), getDescripcion(),tipoBusquedaEnum );
        return SUCCESS;
    }

    // Metodos de acceso de los JavaBeans.
    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(String tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }
}