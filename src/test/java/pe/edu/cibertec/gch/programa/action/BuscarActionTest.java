package pe.edu.cibertec.gch.programa.action;

import pe.edu.cibertec.gch.programa.action.BuscarAction;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

/**
 *
 * @author DanJoas
 */
public class BuscarActionTest extends StrutsTestCase {

    @Test
    public void testBusquedaCompletaFallaSinTituloNiDescripcion() throws Exception {

        request.setParameter("titulo", "");
        request.setParameter("descripcion", "");
        request.setParameter("tipoBusqueda", "0"); // 0 == Completa

        ActionProxy actionProxy = getActionProxy("/buscarProgramas.html");
        BuscarAction buscarAction = (BuscarAction) actionProxy.getAction();

        assertNotNull("The accion es nula pero no deberia ser nulo.", buscarAction);
        String TIPO_RESULTADO = actionProxy.execute();
        
        assertEquals("el metodo deberia retornar " + ActionSupport.INPUT, ActionSupport.INPUT, TIPO_RESULTADO);  
        assertTrue("No hubo problemas de validacion pero deberia haber 2 errores presentes", buscarAction.getFieldErrors().size() == 2);
        assertTrue("el error de titulo deberia estar presente",buscarAction.getFieldErrors().containsKey("titulo"));
        assertTrue("el error de descripcion deberia estar presente",buscarAction.getFieldErrors().containsKey("descripcion"));
    }

    @Test
    public void testBusquedaParcialFallaSinTituloNiDescripcion() throws Exception {

        request.setParameter("titulo", "");
        request.setParameter("descripcion", "");
        request.setParameter("tipoBusqueda", "1"); // 1 == Parcial

        ActionProxy actionProxy = getActionProxy("/buscarProgramas.html");

        BuscarAction buscarAction = (BuscarAction) actionProxy.getAction();
        assertNotNull("The accion es nula pero no deberia ser nulo.", buscarAction);
        
        String TIPO_RESULTADO = actionProxy.execute();
        
        assertEquals("el metodo deberia retornar " + ActionSupport.INPUT, ActionSupport.INPUT, TIPO_RESULTADO);  
        assertTrue("No hubo problemas de validacion pero deberia haber 1 error presente", buscarAction.getFieldErrors().size() == 1);
        assertTrue("el error 'ambos' deberia estar presente",buscarAction.getFieldErrors().containsKey("ambos"));
    }
}