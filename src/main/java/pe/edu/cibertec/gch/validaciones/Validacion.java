package pe.edu.cibertec.gch.validaciones;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public abstract class Validacion {

    protected Map<String, String> errores = new HashMap<>();
    private String paginaReenvio;

    public void setPaginaReenvio(String paginaReenvio) {
        this.paginaReenvio = paginaReenvio;
    }

    public Map<String, String> getErrores() {
        return Collections.unmodifiableMap(errores);
    }

    public String getPaginaReenvio() {
        return paginaReenvio;
    }

    public abstract void validar(HttpServletRequest req);
}
