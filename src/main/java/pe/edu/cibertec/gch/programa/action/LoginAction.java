package pe.edu.cibertec.gch.programa.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author DanJoas
 */
public class LoginAction extends ActionSupport {

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
}
