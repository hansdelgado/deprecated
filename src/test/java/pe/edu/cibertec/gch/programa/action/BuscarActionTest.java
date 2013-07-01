package pe.edu.cibertec.gch.programa.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.StrutsTestCase;
import org.junit.Test;
import pe.edu.cibertec.gch.helper.GCH;

/**
 *
 * @author DanJoas
 */
public class BuscarActionTest extends StrutsTestCase {

    private Map mockSession() {
        Map session = new HashMap<String, Object>();
        session.put(GCH.SESION_USUARIO, "danjoas");
        session.put(GCH.SESION_CLAVE, "123");
        return session;
    }

    @Test
    public void testBusquedaCompletaFallaSinTituloNiDescripcion() throws Exception {
        
        request.setParameter("titulo", "");
        request.setParameter("descripcion", "");
        request.setParameter("tipoBusqueda", "0"); // 0 == Completa

        ActionProxy actionProxy = getActionProxy("/programa/buscar.html");
        ActionContext actionContext = actionProxy.getInvocation().getInvocationContext();
        actionContext.setSession(mockSession());
        
        BuscarAction buscarAction = (BuscarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", buscarAction);
        
        actionProxy.setExecuteResult(false); // no ejecutamos la accion (problemas con tiles)
        String TIPO_RESULTADO = actionProxy.execute();

        assertEquals("el metodo deberia retornar INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertTrue("deberia haber 2 errores presentes", buscarAction.getFieldErrors().size() == 2);
        assertTrue("el error de titulo deberia estar presente", buscarAction.getFieldErrors().containsKey("titulo"));
        assertTrue("el error de descripcion deberia estar presente", buscarAction.getFieldErrors().containsKey("descripcion"));
    }

    @Test
    public void testBusquedaParcialFallaSinTituloNiDescripcion() throws Exception {

        request.setParameter("titulo", "");
        request.setParameter("descripcion", "");
        request.setParameter("tipoBusqueda", "1"); // 1 == Parcial
        
        ActionProxy actionProxy = getActionProxy("/programa/buscar.html");
        ActionContext actionContext = actionProxy.getInvocation().getInvocationContext();
        actionContext.setSession(mockSession());

        BuscarAction buscarAction = (BuscarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser nula", buscarAction);
        actionProxy.setExecuteResult(false);
        String TIPO_RESULTADO = actionProxy.execute();

        assertEquals("el metodo deberia retornar " + ActionSupport.INPUT, ActionSupport.INPUT, TIPO_RESULTADO);
        assertTrue("No hubo problemas de validacion pero deberia haber 1 error presente", buscarAction.getFieldErrors().size() == 1);
        assertTrue("el error 'ambos' deberia estar presente", buscarAction.getFieldErrors().containsKey("ambos"));
    }
}