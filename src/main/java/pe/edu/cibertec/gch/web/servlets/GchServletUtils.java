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

    private GchServletUtils() {
    }

    public static void reenviarAModulo(String moduloDeseado, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paginaReenvio = String.format(BASE_MODULOS, moduloDeseado);
        req.getRequestDispatcher(paginaReenvio).forward(req, resp);
    }
}
