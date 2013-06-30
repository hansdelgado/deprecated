package pe.edu.cibertec.gch.programa.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 *
 * @author DanJoas
 */
public class AutenticarInterceptor implements Interceptor {


    @Override
    public String intercept(ActionInvocation ai) throws Exception {


        // To Do

        return ai.invoke();
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }
}
