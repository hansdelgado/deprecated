package pe.edu.cibertec.gch.programa.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import pe.edu.cibertec.gch.logica.GestorPrograma;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author DanJoas
 */
public class BuscarAction extends ActionSupport {
    private GestorPrograma gestorPrograma = new GestorPrograma();
    private List<Programa> programas;
    private String titulo;
    private String descripcion;
    private int tipoBusqueda;

    @Override
    public String execute() throws Exception {
        TipoBusqueda tipoBusquedaEnum = TipoBusqueda.obtenerPorCodigo(getTipoBusqueda());
        programas = gestorPrograma.listarSegun(getTitulo(), getDescripcion(), tipoBusquedaEnum);
        return SUCCESS;
    }

    @Override
    public void validate() {
        // realizamos algunas validaciones 
        if (TipoBusqueda.Completa == TipoBusqueda.obtenerPorCodigo(getTipoBusqueda())) {
            if (getTitulo() == null || getTitulo().isEmpty()  ) {
                addFieldError("titulo", getText("gch.programa.error.titulo.vacio"));
            }

            if (getDescripcion() == null || getDescripcion().isEmpty()) {
                addFieldError("descripcion", getText("gch.programa.error.descripcion.vacio"));
            }
        } else {
            if (getTitulo() == null || (getTitulo().isEmpty() && getDescripcion().isEmpty())) {
                addFieldError("ambos", getText("gch.programa.error.tituloydescripcion.vacio"));
            }
        }
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

    public int getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(int tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }
}
