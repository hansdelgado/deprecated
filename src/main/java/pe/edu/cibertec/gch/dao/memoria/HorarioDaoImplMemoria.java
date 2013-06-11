package pe.edu.cibertec.gch.dao.memoria;

import pe.edu.cibertec.gch.dao.espec.HorarioDao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.Horario;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author Student
 */
public class HorarioDaoImplMemoria implements HorarioDao {

    private static ArrayList<Horario> horarios = new ArrayList<>();

    @Override
    public void registrar(Horario entidad) {
        horarios.add(entidad);
    }
    
    @Override
    public void modificar(Horario entidad) {
        Horario horario = consultarPorCodigo(entidad.getCodigo());
        eliminarPorCodigo(entidad.getCodigo());
        horario.setDescripcion(entidad.getDescripcion());
        horario.setEstado(entidad.getEstado());
        horario.setMomentoFin(entidad.getMomentoFin());
        horario.setMomentoInicio(entidad.getMomentoInicio());
        registrar(horario);
    }
    
    @Override
    public void eliminarPorCodigo(String codigo) {
        int buscarIndicePorCodigo = buscarIndicePorCodigo(codigo);
        if (buscarIndicePorCodigo > -1 && buscarIndicePorCodigo < horarios.size()) {
            horarios.remove(buscarIndicePorCodigo(codigo));
        }
    }
    
    @Override
    public Horario consultarPorCodigo(String codigo) {
        Horario horarioBuscado = null;
        for (Iterator<Horario> it = horarios.iterator(); it.hasNext();) {
            Horario horario = it.next();
            if (horario.getCodigo().equals(codigo)) {
                horarioBuscado = horario;
                break;
            }
        }
        return horarioBuscado;
    }    
    
    @Override
    public List<Horario> listarTodos() {
        return horarios;
    }

    @Override
    public void borrarTodos() {
        horarios.clear();
    }

    @Override
    public List<Horario> obtenerSegun(String descripcion, TipoBusqueda tipoBusqueda) {
        List<Horario> listaHorarios;
        if (tipoBusqueda.equals(TipoBusqueda.Completa)) {
            listaHorarios = listarTodos();
        } else {
            listaHorarios = obtenerSegun(descripcion);
        }
        return listaHorarios;
    }
    
    private List<Horario> obtenerSegun(String descripcion) {
        List<Horario> listaHorarios = new LinkedList<>();
        for (Horario horario : horarios) {
            if (horario.getDescripcion().contains(descripcion)) {
                listaHorarios.add(horario);
            }
        }
        return listaHorarios;
    }

    /**
     * Devuelve la ubicación del objeto Horario en la lista horarios.
     * @param codigo
     * @return La ubicación del objeto Horario en la lista horarios.
     */
    private int buscarIndicePorCodigo(String codigo) {
        int indice = -1;
        for (int i  = 0; i < horarios.size(); i++) {
            if (horarios.get(i).getCodigo().equals(codigo)) {
                indice = i;
                break;
            }
        }
        return indice;
    }


}
