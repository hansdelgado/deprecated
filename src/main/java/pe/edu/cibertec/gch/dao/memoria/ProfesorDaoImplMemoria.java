package pe.edu.cibertec.gch.dao.memoria;

import pe.edu.cibertec.gch.dao.espec.ProfesorDao;
import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.gch.modelo.EstadoProfesor;
import pe.edu.cibertec.gch.modelo.Profesor;

/**
 *
 * @author Student
 */
public class ProfesorDaoImplMemoria implements ProfesorDao {

    private static ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    
    @Override
    public void registrar(Profesor profesor) {
        profesores.add(profesor);
    }

    @Override
    public List<Profesor> listarTodos() {
        return profesores;
    }

    @Override
    public void eliminarPorCodigo(final String codigo) {
        // Al eliminar, el estado del profesor 
        // se cambia a inactivo
        Profesor profesor = consultarPorCodigo(codigo);
        profesor.setEstado(EstadoProfesor.Inactivo);
    }

    @Override
    public Profesor consultarPorCodigo(final String codigo) {
        Profesor profesor = new Profesor() {{setCodigo(codigo);}};
        return profesores.get(profesores.indexOf(profesor));
    }

    protected void borrarTodos() {
        profesores.clear();
    }

    @Override
    public void modificar(Profesor entidad) {
        
    }
    
}
