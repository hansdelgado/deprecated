package pe.edu.cibertec.gch.web.servlets.programa.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.modelo.Programa;

/**
 *
 * @author DanJoas
 */
public class Listar extends ActionSupport {
    //private Map<String, Object> session;
    private List<Programa> programas;
    private String mensaje; // si se usa chain no es necesario declaralo

    @Override
    public String execute() throws Exception {       
        programas = FactoryDao.getInstance().getProgramaDao().listarTodos();
        return SUCCESS;
    }

    // Metodos de acceso de los JavaBeans.
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
