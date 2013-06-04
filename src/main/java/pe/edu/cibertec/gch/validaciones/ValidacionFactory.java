package pe.edu.cibertec.gch.validaciones;

import javax.servlet.http.HttpServletRequest;

/**
 * Determina el objeto que va a efectuar la validacion
 */
public class ValidacionFactory {
    
    public Validacion obtenerSegun(HttpServletRequest req) {
        if(req.getServletPath().contains("Profesor")) {
            return new ValidacionProfesor();
        }
        return null;
    }
}
