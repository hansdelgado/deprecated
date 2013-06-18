/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.gch.web.servlets.programa.convertidor;

import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;
import pe.edu.cibertec.gch.modelo.Moneda;

/**
 *
 * @author DanJoas
 */
public class MonedaConverter extends StrutsTypeConverter {

    @Override
    public Object convertFromString(Map map, String[] strings, Class type) {
        if (strings[0].isEmpty()) {
            return "";
        }
        return strings[0].equals("NS") ? Moneda.NuevosSoles : Moneda.DolaresUS;
    }

    @Override
    public String convertToString(Map map, Object valor) {

        if (valor == Moneda.NuevosSoles) {
            return "NS";
        }
        if (valor == Moneda.DolaresUS) {
            return "D";
        }
        return "";
    }
}
