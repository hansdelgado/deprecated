package pe.edu.cibertec.gch.programa.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.HashMap;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;
import pe.edu.cibertec.gch.programa.action.BuscarAction;

/**
 *
 * @author DanJoas
 */
public class BuscarInterceptor implements Interceptor {
    
    
    /* Prueba de Concepto : BuscarInterceptor
     * es posible acceder llegar a los javabeans del action
     * pero al parecer no es posible retornar valores ( ejem un HashMap ) 
     * 
     */
    
    @Override
    public String intercept(ActionInvocation ai) throws Exception {

        BuscarAction action = (BuscarAction) ai.getAction();

        HashMap<String, String> errores = new HashMap<>();

        // realizamos algunas validaciones 
        if (action.getTitulo().length() > 10) {
            errores.put("titulo", "el titulo no debe ser mayor a 10 caracteres");
        }
        if (action.getDescripcion().length() > 10) {
            errores.put("descripcion", "el descripcion no debe ser mayor a 10 caracteres");
        }


        if (TipoBusqueda.Completa == TipoBusqueda.obtenerPorCodigo(Integer.parseInt(action.getTipoBusqueda()))) {
            if (action.getTitulo().isEmpty()) {
                errores.put("titulo", "el titulo no debe estar vacio en una busqueda Completa");
            }

            if (action.getDescripcion().isEmpty()) {
                errores.put("descripcion", "descripcion no debe estar vacio en una busqueda Completa");
            }
        } else {
            if (action.getTitulo().isEmpty() && action.getDescripcion().isEmpty()) {
                errores.put("ambos", "por lo menos debe llenar un campo en su busqueda Parcial");
            }
        }

        return ai.invoke();
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }
}
