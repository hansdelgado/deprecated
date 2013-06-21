package pe.edu.cibertec.gch.dao.services;

import java.util.List;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.espec.HorarioDao;
import pe.edu.cibertec.gch.modelo.Horario;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author JAVA_MJ
 */
public class HorarioService {
    
    private HorarioDao dao;

    public HorarioService() {
        dao = FactoryDao.getFactory().getHorarioDao();
    }

    public void registrar(Horario horario) {
        dao.registrar(horario);
    }
    
    public void modificar(Horario horario) {
        dao.modificar(horario);
    }
    
    public void eliminarPorCodigo(String codigo) {
        dao.eliminarPorCodigo(codigo);
    }
    
    public void borrarTodos() {
        dao.borrarTodos();
    }
    
    public Horario consultarPorCodigo(String codigo){
        return dao.consultarPorCodigo(codigo);
    }
    
    public List<Horario> listarTodos() {
        return dao.listarTodos();
    }
    
    public List<Horario> obtenerSegun(String descripcion, TipoBusqueda tipoBusqueda) {
        return dao.obtenerSegun(descripcion, tipoBusqueda);
    }
    
}
