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

    private List<Programa> programas;

    @Override
    public String execute() throws Exception {

        programas = FactoryDao.getInstance().getProgramaDao().listarTodos();
        return SUCCESS;
    }    

    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    } 
}
