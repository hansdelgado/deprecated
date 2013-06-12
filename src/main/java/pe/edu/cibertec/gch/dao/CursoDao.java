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

    public List<Curso> listarSegun(String codigo, String nombre,String descripcion,String objetivos, String requisitos, String estado, String duracion, TipoBusqueda tipoBusquedaEnum);
    //codigo,nombre,descripcion,objetivos ,requisitos ,estado , duracion, tipoBusquedaEnum
    
    public void modificarPorCodigo(Curso curso);
    
    public Curso eliminarPorCodigoCurso(String codigo);
}
