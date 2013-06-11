package pe.edu.cibertec.gch.dao.memoria;

import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.dao.espec.HorarioDao;
import pe.edu.cibertec.gch.dao.espec.ProfesorDao;

/**
 *
 * @author abedregal
 */
public class MemoriaFactoryDao extends FactoryDao {

    @Override
    public ProfesorDao getProfesorDao() {
        return new ProfesorDaoImplMemoria();
    }

    @Override
    public HorarioDao getHorarioDao() {
        return new HorarioDaoImplMemoria();
    }
    
}
