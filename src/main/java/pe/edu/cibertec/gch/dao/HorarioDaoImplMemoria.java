package pe.edu.cibertec.gch.dao;

import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.Horario;

/**
 *
 * @author Student
 */
public class HorarioDaoImplMemoria implements HorarioDao {

    private static ArrayList<Horario> horarios = new ArrayList<Horario>();
    
    
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
        horario.setDescripcion("NocheI");
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
    
    protected void borrarTodos() {
        horarios.clear();
    }
}
