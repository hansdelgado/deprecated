package pe.edu.cibertec.gch.logica;

import java.util.List;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.ProgramaDao;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author JAVA_MJ
 */
public class GestorPrograma implements GestorBase<Programa> {

    private ProgramaDao programaDao = FactoryDao.getInstance().getProgramaDao();

    @Override
    public Programa consultarPorCodigo(String codigo) {
        return programaDao.consultarPorCodigo(codigo);
    }

    @Override
    public void registrar(Programa programa) {
        programaDao.registrar(programa);
    }

    @Override
    public List<Programa> listarTodos() {
        return programaDao.listarTodos();
    }

    @Override
    public void eliminarPorCodigo(String codigo) {
        programaDao.eliminarPorCodigo(codigo);
    }

    protected void borrarTodos() {
        programaDao.borrarTodos();
    }

    public List<Programa> listarSegun(String titulo, String descripcion, TipoBusqueda tipoBusquedaEnum) {
        return programaDao.listarSegun(titulo, descripcion, tipoBusquedaEnum);
    }

    public void modificarPorCodigo(Programa programa) {
        programaDao.modificarPorCodigo(programa);
    }
}
