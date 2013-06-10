package pe.edu.cibertec.gch.dao;

import java.util.List;
import pe.edu.cibertec.gch.logica.GestorBase;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author grupoPrograma
 */
public interface ProgramaDao extends GestorBase<Programa> {

    public List<Programa> listarSegun(String titulo, String descripcion, TipoBusqueda tipoBusquedaEnum);
    
    public void modificarPorCodigo(Programa pro);
}
