package pe.edu.cibertec.gch.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.edu.cibertec.gch.dao.services.HorarioService;
import pe.edu.cibertec.gch.modelo.EstadoActividad;
import pe.edu.cibertec.gch.modelo.Horario;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author abedregal
 */
public class HorarioAction extends ActionSupport {
    
    private Horario horario;
    private List<Horario> horarios;
    private Map estados;
    private Map tiposBusqueda;
    private String horarioSeleccionado;
    private String tipoBusquedaSeleccionado;

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

    public Map getEstados() {
        return estados;
    }

    public void setEstados(Map estados) {
        this.estados = estados;
    }

    public Map getTiposBusqueda() {
        return tiposBusqueda;
    }

    public void setTiposBusqueda(Map tiposBusqueda) {
        this.tiposBusqueda = tiposBusqueda;
    }

    public String getHorarioSeleccionado() {
        return horarioSeleccionado;
    }

    public void setHorarioSeleccionado(String horarioSeleccionado) {
        this.horarioSeleccionado = horarioSeleccionado;
    }

    public String getTipoBusquedaSeleccionado() {
        return tipoBusquedaSeleccionado;
    }

    public void setTipoBusquedaSeleccionado(String tipoBusquedaSeleccionado) {
        this.tipoBusquedaSeleccionado = tipoBusquedaSeleccionado;
    }

    public String registrar() {
        if ("1".equals(horarioSeleccionado)) {
            horario.setEstado(EstadoActividad.Valido);
        } else {
            horario.setEstado(EstadoActividad.Obsoleto);
        }
        new HorarioService().registrar(horario);
        return SUCCESS;
    }
    
    public String listar() {
        System.out.println("LISTAR HORARIOS");
        horarios = new HorarioService().listarTodos();
        return SUCCESS;
    }
    
    public String inicializarRegistro() {
        estados = new HashMap();
        int i = 1;
        for (EstadoActividad ea : EstadoActividad.values()) {
            estados.put(String.valueOf(i), ea);
            i++;
        }
        return SUCCESS;
    }
    
    public String modificar() {
        if ("1".equals(horarioSeleccionado)) {
            horario.setEstado(EstadoActividad.Valido);
        } else {
            horario.setEstado(EstadoActividad.Obsoleto);
        }
        new HorarioService().modificar(horario);
        return SUCCESS;
    }
    
    public String buscar() {
        TipoBusqueda tipoBusquedaEnum = TipoBusqueda.obtenerPorCodigo(Integer.parseInt(tipoBusquedaSeleccionado));
        horarios = new HorarioService().obtenerSegun(horario.getDescripcion(), tipoBusquedaEnum);
        return SUCCESS;
    }
    
    public String inicializarIndex() {
        System.out.println("INICIALIZA INDEX ---> HORARIOS: " + horarios);
        tiposBusqueda = new HashMap();
        int i = 0;
        for (TipoBusqueda tipoBusqueda : TipoBusqueda.values()) {
            tiposBusqueda.put(String.valueOf(i), tipoBusqueda);
            i++;
        }
        return SUCCESS;
    }
}
