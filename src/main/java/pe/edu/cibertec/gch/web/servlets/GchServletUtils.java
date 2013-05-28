package pe.edu.cibertec.gch.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Utilidades para el servlet de GCH
 */
public final class GchServletUtils {
    private static final String BASE_MODULOS = "view/%s/index.jsp";
     private static final String BASE_REGISTRO = "view/%s/registro.jsp";

    private GchServletUtils() {
    }

    public static void reenviarAModulo(String moduloDeseado, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaRedireccion = String.format(BASE_MODULOS, moduloDeseado);
        System.out.println(paginaRedireccion);
        req.getRequestDispatcher(paginaRedireccion).forward(req, resp);
    }
     public static void reenviarARegistro(String moduloDeseado, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaRedireccion = String.format(BASE_REGISTRO, moduloDeseado);
        System.out.println(paginaRedireccion);
        req.getRequestDispatcher(paginaRedireccion).forward(req, resp);
    }
    
}
