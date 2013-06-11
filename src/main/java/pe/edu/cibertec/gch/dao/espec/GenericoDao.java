package pe.edu.cibertec.gch.dao.espec;

import java.util.List;

/**
 *
 * @author abedregal
 */
public interface GenericoDao<T> {
    
    void registrar(T entidad);
    void modificar(T entidad);
    void eliminarPorCodigo(final String codigo);
    T consultarPorCodigo(final String codigo);
    List<T> listarTodos();
    
}
