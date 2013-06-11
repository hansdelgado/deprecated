package pe.edu.cibertec.gch.dao.espec;

import java.util.List;
import pe.edu.cibertec.gch.modelo.Horario;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author Student
 */
public interface HorarioDao extends GenericoDao<Horario> {

    void borrarTodos();
    List<Horario> obtenerSegun(String descripcion, TipoBusqueda tipoBusqueda);
    
}
