package pe.edu.cibertec.gch.dao;

import java.util.List;
import pe.edu.cibertec.gch.logica.GestorBase;
import pe.edu.cibertec.gch.modelo.Horario;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author Student
 */
public interface HorarioDao extends GestorBase<Horario> {
    
    void borrarTodos();
    List<Horario> obtenerSegun(String descripcion, TipoBusqueda tipoBusqueda);
    
}
