package pe.edu.cibertec.gch.programa.action;

import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionSupport;
import static junit.framework.Assert.assertEquals;
import org.apache.struts2.StrutsTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.mock.web.MockHttpServletRequest;
import pe.edu.cibertec.gch.logica.GestorPrograma;
import pe.edu.cibertec.gch.modelo.Programa;

/**
 *
 * @author DanJoas
 */
public class RegistrarActionTest extends StrutsTestCase {

    private GestorPrograma gestorPrograma;

    public RegistrarActionTest() {
        gestorPrograma = new GestorPrograma();
    }

    private MockHttpServletRequest getRequestConProgramaCargado() {
        request.setParameter("programa.codigo", "3");
        request.setParameter("programa.titulo", "TECNICOS INDUSTRIALES");
        request.setParameter("programa.descripcion", "Orientado al sector de manufactura masiva");
        request.setParameter("programa.objetivos", "Conocimiento electronica y electricida");
        request.setParameter("programa.requisitos", "Ninguno");
        request.setParameter("programa.moneda", "NuevosSoles");
        request.setParameter("programa.precio", "3700");
        request.setParameter("programa.duracion", "140");
        request.setParameter("programa.fechaInicial", "2013-06-11");
        return request;
    }

    @Test
    public void testRegistrarProgramaConExito() throws Exception {
        request = getRequestConProgramaCargado();
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna SUCCESS", ActionSupport.SUCCESS, TIPO_RESULTADO);

        assertTrue("deberia estar vacio : true", registrarAction.getFieldErrors().isEmpty());
    }

    @Test
    public void testNoRegistraProgramaPorqueFaltaCodigo() throws Exception {
        gestorPrograma.borrarTodos();
        request = getRequestConProgramaCargado();
        request.setParameter("programa.codigo", "");
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertEquals("deberia existir un solo error", registrarAction.getFieldErrors().size(), 1);
        assertTrue("no está presente el error : programa.codigo", registrarAction.getFieldErrors().containsKey("programa.codigo"));
    }
    
    @Test
    public void testNoRegistraProgramaPorqueTieneCodigoDuplicado() throws Exception {
        gestorPrograma.borrarTodos();
        gestorPrograma.registrar(new Programa("6"));
        request = getRequestConProgramaCargado();
        request.setParameter("programa.codigo", "6");
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertEquals("deberia existir un solo error", registrarAction.getFieldErrors().size(), 1);
        assertTrue("no está presente el error : programa.codigo", registrarAction.getFieldErrors().containsKey("programa.codigo"));
    }

    @Test
    public void testNoRegistraProgramaPorqueFaltaTitulo() throws Exception {
        gestorPrograma.borrarTodos();
        request = getRequestConProgramaCargado();
        request.setParameter("programa.titulo", "");
        
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertEquals("deberia existir un solo error", registrarAction.getFieldErrors().size(), 1);
        assertTrue("no está presente el error : programa.titulo", registrarAction.getFieldErrors().containsKey("programa.titulo"));
    }

    @Test
    public void testNoRegistraProgramaPorqueFaltaDescripcion() throws Exception {
        gestorPrograma.borrarTodos();
        request = getRequestConProgramaCargado();
        request.setParameter("programa.descripcion", "");
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertEquals("deberia existir un solo error", registrarAction.getFieldErrors().size(), 1);
        assertTrue("no está presente el error : programa.descripcion", registrarAction.getFieldErrors().containsKey("programa.descripcion"));
    }

    @Test
    public void testNoRegistraProgramaPorqueFaltaObjetivos() throws Exception {
        gestorPrograma.borrarTodos();
        request = getRequestConProgramaCargado();
        request.setParameter("programa.objetivos", "");
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertEquals("deberia existir un solo error", registrarAction.getFieldErrors().size(), 1);
        assertTrue("no está presente el error : programa.objetivos", registrarAction.getFieldErrors().containsKey("programa.objetivos"));
    }

    @Test
    public void testNoRegistraProgramaPorqueFaltaRequisitos() throws Exception {
        gestorPrograma.borrarTodos();
        request = getRequestConProgramaCargado();
        request.setParameter("programa.requisitos", "");
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertEquals("deberia existir un solo error", registrarAction.getFieldErrors().size(), 1);
        assertTrue("no está presente el error : programa.requisitos", registrarAction.getFieldErrors().containsKey("programa.requisitos"));
    }

    @Test
    public void testNoRegistraProgramaPorqueFaltaTipoMoneda() throws Exception {
        gestorPrograma.borrarTodos();
        request = getRequestConProgramaCargado();
        request.setParameter("programa.moneda", "");
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertEquals("deberia existir un solo error", registrarAction.getFieldErrors().size(), 1);
        assertTrue("no está presente el error : programa.moneda", registrarAction.getFieldErrors().containsKey("programa.moneda"));
    }

    @Test
    public void testNoRegistraProgramaPorqueFaltaPrecio() throws Exception {
        gestorPrograma.borrarTodos();
        request = getRequestConProgramaCargado();
        request.setParameter("programa.precio", "");
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertEquals("deberia existir un solo error", registrarAction.getFieldErrors().size(), 1);
        assertTrue("no está presente el error : programa.precio", registrarAction.getFieldErrors().containsKey("programa.precio"));
    }

    @Test
    public void testNoRegistraProgramaPorqueFaltaDuracion() throws Exception {
        gestorPrograma.borrarTodos();
        request = getRequestConProgramaCargado();
        request.setParameter("programa.duracion", "");
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertEquals("deberia existir un solo error", registrarAction.getFieldErrors().size(), 1);
        assertTrue("no está presente el error : programa.duracion", registrarAction.getFieldErrors().containsKey("programa.duracion"));
    }
    
    @Test
    public void testNoRegistraProgramaPorqueSuperaLaMaximaDuracion() throws Exception {
        gestorPrograma.borrarTodos();
        request = getRequestConProgramaCargado();
        request.setParameter("programa.duracion", "151");
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertEquals("deberia existir un solo error", registrarAction.getFieldErrors().size(), 1);
        assertTrue("no está presente el error : programa.duracion", registrarAction.getFieldErrors().containsKey("programa.duracion"));
    }
    @Test
    public void testNoRegistraProgramaPorqueEsMenorQueLaMinimaDuracion() throws Exception {
        gestorPrograma.borrarTodos();
        request = getRequestConProgramaCargado();
        request.setParameter("programa.duracion", "9");
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertEquals("deberia existir un solo error", registrarAction.getFieldErrors().size(), 1);
        assertTrue("no está presente el error : programa.duracion", registrarAction.getFieldErrors().containsKey("programa.duracion"));
    }

    @Test
    public void testNoRegistraProgramaPorqueFaltaFechaInicial() throws Exception {
        gestorPrograma.borrarTodos();
        request = getRequestConProgramaCargado();
        request.setParameter("programa.fechaInicial", "");
        ActionProxy actionProxy = getActionProxy("/programa/registrar.html");

        RegistrarAction registrarAction = (RegistrarAction) actionProxy.getAction();
        assertNotNull("la accion no debe ser null", registrarAction);

        String TIPO_RESULTADO = actionProxy.execute();
        assertEquals("el metodo NO retorna INPUT", ActionSupport.INPUT, TIPO_RESULTADO);
        assertEquals("deberia existir un solo error", registrarAction.getFieldErrors().size(), 1);
        assertTrue("no está presente el error : programa.fechaInicial", registrarAction.getFieldErrors().containsKey("programa.fechaInicial"));
    }
}