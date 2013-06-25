package pe.edu.cibertec.gch.web.servlets.programa.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.helper.GCH;
import pe.edu.cibertec.gch.logica.GestorPrograma;

/**
 *
 * @author DanJoas
 */
public class Registrar extends ActionSupport {
    private GestorPrograma gestorPrograma = new GestorPrograma();
    private List<Programa> programas;
    private Programa programa;
    private String mensaje;

    @Override
    public String execute() throws Exception {

        GCH.dump("programa", programa);
        gestorPrograma.registrar(programa);
        setMensaje(getText("mensaje.registrar"));
        return SUCCESS;
    }

    @Override
    public void validate() {
        GCH.dump("codigo", programa.getCodigo());
        Programa p = gestorPrograma.consultarPorCodigo(programa.getCodigo());
        if(p != null){ // si ya existe
            addFieldError("programa",getText("validar.codigo.duplicado"));
        }
    }

    // Metodos de acceso de los JavaBeans.
    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
