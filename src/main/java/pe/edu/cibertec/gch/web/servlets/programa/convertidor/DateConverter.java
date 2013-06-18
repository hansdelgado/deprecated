package pe.edu.cibertec.gch.web.servlets.programa.convertidor;

import java.util.Date;
import java.util.Map;
import org.apache.struts2.util.StrutsTypeConverter;
import pe.edu.cibertec.gch.helper.GCH;


/*
 * Permite a Struts manipuliar un Date a cadena y viceversa.
 */

public class DateConverter extends StrutsTypeConverter {

    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        // formato : yyyy-MM-dd
        return GCH.fechaToDate(values[0]);
    }

    @Override
    public String convertToString(Map context, Object o) {
        return GCH.dateToFecha( (Date) o);
    }
}
