package pe.edu.cibertec.gch.dao;

import pe.edu.cibertec.gch.dao.espec.ProfesorDao;
import pe.edu.cibertec.gch.dao.espec.HorarioDao;
import pe.edu.cibertec.gch.dao.memoria.MemoriaFactoryDao;

/**
 *
 * @author Student
 */
public abstract class FactoryDao {
    
    private static FactoryDao factory = null;
    
    public static FactoryDao getFactory() {
        if ( factory == null) {
            factory = new MemoriaFactoryDao();
        }
        return factory;
    }
    
    public abstract ProfesorDao getProfesorDao();
    
    public abstract HorarioDao getHorarioDao();
    
}
