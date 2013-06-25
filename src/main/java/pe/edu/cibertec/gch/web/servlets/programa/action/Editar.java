package pe.edu.cibertec.gch.web.servlets.programa.action;

import com.opensymphony.xwork2.ActionSupport;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.helper.GCH;
import pe.edu.cibertec.gch.logica.GestorPrograma;

/**
 *
 * @author DanJoas
 */
public class Editar extends ActionSupport {
    private GestorPrograma gestorPrograma = new GestorPrograma();
    private String codigo;
    private Programa programa;
    private String mensaje;

    @Override
    public String execute() throws Exception {

        gestorPrograma.modificarPorCodigo(getPrograma());
        GCH.dump("listando programa", programa);
        setMensaje(getText("mensaje.editar"));
        return SUCCESS;
    }

    public String mostrar() throws Exception {
        programa = gestorPrograma.consultarPorCodigo(getCodigo());
        if (programa == null) {
            setMensaje(getText("validar.programa.no.existe"));
            return "listado";
        }
        GCH.dump("listando programa", programa);
        return SUCCESS;
    }

    // Metodos de acceso de los JavaBeans.
    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
