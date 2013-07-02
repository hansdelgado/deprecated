package pe.edu.cibertec.gch.actions;

import com.opensymphony.xwork2.ActionContext;
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

    public String guardar() {
        HorarioService horarioService = new HorarioService();
        if ("1".equals(horarioSeleccionado)) {
            horario.setEstado(EstadoActividad.Valido);
        } else {
            horario.setEstado(EstadoActividad.Obsoleto);
        }
        if ( horarioService.consultarPorCodigo(horario.getCodigo()) == null ) {
            horarioService.registrar(horario);
        } else {
            horarioService.modificar(horario);
        }
        return SUCCESS;
    }
    
    public String listar() {
        horarios = new HorarioService().listarTodos();
        tiposBusqueda = new HashMap();
        int i = 0;
        for (TipoBusqueda tipoBusqueda : TipoBusqueda.values()) {
            tiposBusqueda.put(String.valueOf(i), tipoBusqueda);
            i++;
        }
        ActionContext.getContext().getSession().put("tiposBusqueda", tiposBusqueda);
        return SUCCESS;
    }
    
    public String inicializarRegistro() {
        estados = new HashMap();
        int i = 1;
        for (EstadoActividad ea : EstadoActividad.values()) {
            estados.put(String.valueOf(i), ea);
            i++;
        }
        ActionContext.getContext().getSession().put("estados", estados);
        return SUCCESS;
    }
    
    public String buscar() {
        TipoBusqueda tipoBusquedaEnum = TipoBusqueda.obtenerPorCodigo(Integer.parseInt(tipoBusquedaSeleccionado));
        horarios = new HorarioService().obtenerSegun(horario.getDescripcion(), tipoBusquedaEnum);
        return SUCCESS;
    }
    
    public String inicializarModificar() {
        horario = new HorarioService().consultarPorCodigo(horario.getCodigo());
        horarioSeleccionado = (horario.getEstado() == EstadoActividad.Valido ? "1" : "2");
        return SUCCESS;
    }
    
    public String eliminar() {
        new HorarioService().eliminarPorCodigo(horario.getCodigo());
        return SUCCESS;
    }    
    
}
