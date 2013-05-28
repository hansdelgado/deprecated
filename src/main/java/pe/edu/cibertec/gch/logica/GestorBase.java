package pe.edu.cibertec.gch.logica;

import java.util.List;

/**
 *
 * @author hans delgado
 */
public interface GestorBase<T> {
    public List<T> listarTodos();
    void eliminarPorCodigo(final String codigo);
    T consultarPorCodigo(final String codigo);
    void registrar(T entidad);
}
