package pe.edu.cibertec.gch.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import pe.edu.cibertec.gch.dao.services.HorarioService;
import pe.edu.cibertec.gch.modelo.Horario;

/**
 *
 * @author abedregal
 */
public class HorarioAction extends ActionSupport {
    
    private Horario horario;
    private List<Horario> horarios;

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
    
    public String registrar() {
        new HorarioService().registrar(horario);
        return SUCCESS;
    }
    
    public String listar() {
        horarios = new HorarioService().listarTodos();
        return SUCCESS;
    }
    
}
