package pe.edu.cibertec.gch.programa.action;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.cibertec.gch.logica.GestorPrograma;
import pe.edu.cibertec.gch.modelo.Programa;

/**
 *
 * @author DanJoas
 */
public class EliminarAction extends ActionSupport {
    
    private GestorPrograma gestorPrograma = new GestorPrograma();
    private String codigo;
    private String mensaje;

    @Override
    public String execute() throws Exception {
        Programa programa = gestorPrograma.consultarPorCodigo(getCodigo());
        if (programa == null) {
            setMensaje(getText("validar.programa.no.existe"));
        } else {
            gestorPrograma.eliminarPorCodigo(getCodigo());
            setMensaje(getText("mensaje.eliminar"));
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
}
