package pe.edu.cibertec.gch.programa.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;
import pe.edu.cibertec.gch.helper.GCH;

/**
 *
 * @author DanJoas
 */
public class AutenticadorInterceptor implements Interceptor {

    @Override
    public String intercept(ActionInvocation ai) throws Exception {

        Map session = ai.getInvocationContext().getSession();

        String usuario = (String) session.get(GCH.SESION_USUARIO);
        String clave = (String) session.get(GCH.SESION_CLAVE);

        if (usuario == null || clave == null) {
            return Action.LOGIN;
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
