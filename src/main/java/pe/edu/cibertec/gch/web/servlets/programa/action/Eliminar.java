package pe.edu.cibertec.gch.web.servlets.programa.action;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.cibertec.gch.dao.FactoryDao;

/**
 *
 * @author DanJoas
 */
public class Eliminar extends ActionSupport {

    private String codigo;
    private String mensaje;

    @Override
    public String execute() throws Exception {
        String titulo = FactoryDao.getInstance().getProgramaDao().consultarPorCodigo(codigo).getTitulo();
        FactoryDao.getInstance().getProgramaDao().eliminarPorCodigo(codigo);

        setMensaje("el programa '" + titulo + "' se elimino correctamente");
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
}
