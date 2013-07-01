package pe.edu.cibertec.gch.programa.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import pe.edu.cibertec.gch.helper.GCH;

/**
 *
 * @author DanJoas
 */
public class LoginAction extends ActionSupport implements SessionAware {

    private Map session;
    private String mensaje;
    private String usuario;
    private String clave;
    private String reclave;

    public String nuevo() {
        return SUCCESS;
    }

    public String registrar() {
        setMensaje(getText("gch.login.exito.registrar"));
        return SUCCESS;
    }

    public String acceso() {
        return SUCCESS;
    }

    public String ingresar() {

        if (getUsuario().equals("danjoas") && getClave().equals("123")) {
            session.put(GCH.SESION_USUARIO, getUsuario());
            session.put(GCH.SESION_CLAVE, getClave());
            return SUCCESS;
        }
        addActionError("su usuario o clave es incorrecto");
        return LOGIN;
    }

    public String logout() {
        session.remove(GCH.SESION_USUARIO);
        session.remove(GCH.SESION_CLAVE);
        return SUCCESS;
    }

    // Metodos de acceso de los JavaBeans.
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getReclave() {
        return reclave;
    }

    public void setReclave(String reclave) {
        this.reclave = reclave;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }
}
