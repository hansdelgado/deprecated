package pe.edu.cibertec.gch.web.servlets.programa.convertidor;

import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;
import pe.edu.cibertec.gch.helper.GCH;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 *
 * @author DanJoas
 */
public class TipoBusquedaConverter extends StrutsTypeConverter {

    @Override
    public Object convertFromString(Map map, String[] strings, Class type) {

        if (strings[0].isEmpty()) {
            return 2;
        }
        return TipoBusqueda.obtenerPorCodigo(Integer.parseInt(strings[0]));
    }

    @Override
    public String convertToString(Map map, Object valor) {
        if (valor == TipoBusqueda.Completa) {
            return "0";
        }
        if (valor == TipoBusqueda.Parcial) {
            return "1";
        }
        return "2"; // TipoBusqueda.NoDefinido
    }
}
