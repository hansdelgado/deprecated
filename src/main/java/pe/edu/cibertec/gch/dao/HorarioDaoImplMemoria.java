package pe.edu.cibertec.gch.dao;

import java.util.ArrayList;
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
    
    static {
        Horario horario = new Horario();
        horario.setCodigo("001");
        horario.setDescripcion("Mañana");
        horarios.add(horario);
        horario = new Horario();
        horario.setCodigo("002");
        horario.setDescripcion("Tarde");
        horarios.add(horario);
        horario = new Horario();
        horario.setCodigo("003");
        horario.setDescripcion("Noche");
        horarios.add(horario);
    }

    @Override
    public List<Horario> listarTodos() {
        return horarios;
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Horario consultarPorCodigo(String codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registrar(Horario entidad) {
        horarios.add(entidad);
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
}
