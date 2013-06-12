/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

/**
 *
 * @author JAVA_MJ
 */
@WebFilter(filterName = "CursoInputValidadorFilter", urlPatterns = {"/registrarCurso"})
public class CursoInputValidadorFilter implements Filter {
    
    private static final boolean debug = true;
    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public CursoInputValidadorFilter() {
    }    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HashMap<String, String> errores = validadorFilterCurso(request);

        if (errores.size() > 0) {
            // envimos de regreso los errores y los datos ingresados.
            System.out.println("----------"+errores);
            request.setAttribute("errores", errores.values());

            for (String name : request.getParameterMap().keySet()) {
                request.setAttribute(name, request.getParameter(name));
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/curso/registro.jsp");
            requestDispatcher.forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
    
    private HashMap<String,String> validadorFilterCurso (ServletRequest req){
    
        HashMap<String,String> errorIngreso = new HashMap<>();
       
        
        final String codigo = req.getParameter("codigo"),
               nombre = req.getParameter("nombre"),
               descripcion = req.getParameter("descripcion"),
               objetivos = req.getParameter("objetivos"),
               requisitos = req.getParameter("requisitos"),
               referencia = req.getParameter("referencia"),
               estado = req.getParameter("estado"),
               duracion = req.getParameter("duracion");
        
        try {
            Integer.parseInt(codigo);
        } catch (Exception e) {
            errorIngreso.put("codigo", "Ingresar sólo numeros en el Códido");
        }
        try {
            Integer.parseInt(duracion);
        } catch (Exception e) {
            errorIngreso.put("duracion", "Ingresar sólo numeros en la duración");
        }
         if(codigo.length()>10){
            errorIngreso.put("codigo","Longitud Máxima del Campo codigo: 10");
        }
        if(nombre.length()>10){
            errorIngreso.put("nombre","Longitud Máxima del Campo Nombre: 10");
        }
        if(descripcion.length()>12){
            errorIngreso.put("descripcion","Longitud Máxima del Campo Descripcion: 12");
        }
        if(objetivos.length()>10){
            errorIngreso.put("objetivos","Longitud Máxima del Campo objetivos: 10");
        }
        if(requisitos.length()>12){
            errorIngreso.put("requisitos","Longitud Máxima del Campo requisitos: 12");
        }
         if(referencia.length()>10){
            errorIngreso.put("requisitos","Longitud Máxima del Campo requisitos: 10");
        }
          if(estado.length()>10){
            errorIngreso.put("estado","Longitud Máxima del Campo estado: 10");
        }
          
        if(!(estado.equalsIgnoreCase("obsoleto"))&&(!(estado.equalsIgnoreCase("Valido")))){
            errorIngreso.put("estado","Valor válido de estado es : OBSOLETO O VALIDO ");
        }
        
        if(codigo.isEmpty()){
            errorIngreso.put("codigo","El código no debe estar vacio");
        }
        
        if(nombre.isEmpty()){
            errorIngreso.put("nombre","El nombre no debe estar vacio");
        }
        
        if(descripcion.isEmpty()){
            errorIngreso.put("descripcion","La descripcion no debe estar vacio");
        }
        
        if(objetivos.isEmpty()){
            errorIngreso.put("objetivos","El objetivo no debe estar vacio");
        }
        
        if(requisitos.isEmpty()){
            errorIngreso.put("requisitos","El requisito no debe estar vacio");
        }
        
        if(referencia.isEmpty()){
            errorIngreso.put("referencia","La referencia no debe estar vacia");
        }
        
        if(estado.isEmpty()){
            errorIngreso.put("estado","El estado no debe estar vacio");
        }
        
        if(duracion.isEmpty()){
            errorIngreso.put("duracion","La duracion no debe estar vacia");
        }
        
        return errorIngreso;
    }
    
    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
}
