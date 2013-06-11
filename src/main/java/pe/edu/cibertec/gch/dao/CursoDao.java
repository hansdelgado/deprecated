package pe.edu.cibertec.gch.dao;

import java.util.List;
import pe.edu.cibertec.gch.logica.GestorBase;
import pe.edu.cibertec.gch.modelo.Curso;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author grupoPrograma
 */
public interface CursoDao extends GestorBase<Curso> {

    public List<Curso> listarSegun(String nombre, String descripcion, TipoBusqueda tipoBusquedaEnum);
    
    public void modificarPorCodigo(Curso curso);
}
