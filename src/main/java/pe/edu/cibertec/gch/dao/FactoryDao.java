package pe.edu.cibertec.gch.dao;

/**
 *
 * @author Student
 */
public class FactoryDao {
    
    private static FactoryDao instance;
    
    private FactoryDao() {
    }
    
    public static FactoryDao getInstance() {
        if ( instance == null) {
            instance = new FactoryDao();
        }
        return instance;
    }
    
    public ProfesorDao getProfesorDao() {
        return new ProfesorDaoImplMemoria();
    }
    
    public HorarioDao getHorarioDao() {
        return new HorarioDaoImplMemoria();
    }
    
}
