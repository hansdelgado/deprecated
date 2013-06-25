package pe.edu.cibertec.gch.web.servlets.programa.action;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.modelo.Programa;

/**
 *
 * @author DanJoas
 */
public class Eliminar extends ActionSupport {

    private String codigo;
    private String mensaje;
    private String titulo;

    @Override
    public String execute() throws Exception {
        Programa programa = FactoryDao.getInstance().getProgramaDao().consultarPorCodigo(getCodigo());
        if (programa == null) {
            setMensaje(getText("validar_programa_no_existe"));
        } else {
            FactoryDao.getInstance().getProgramaDao().eliminarPorCodigo(getCodigo());
            setTitulo(programa.getTitulo());
            setMensaje(getText("mensaje_eliminar"));
        }
        return SUCCESS;
    }

    // Metodos de acceso de los JavaBeans.
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
