package pe.edu.cibertec.gch.programa.convertidor;

import com.opensymphony.xwork2.conversion.TypeConversionException;
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
        GCH.dump("conversion de tipo", values[0]);
        try {
            Integer.parseInt(values[0].substring(8));
            Integer.parseInt(values[0].substring(5, 7));
            Integer.parseInt(values[0].substring(0, 4));
            return GCH.fechaToDate(values[0]);
        } catch (Exception e) {
            GCH.dump("lanzando excepcion",values[0]);
            throw new TypeConversionException("Formato de fecha incorrecto");
        }
    }

    @Override
    public String convertToString(Map context, Object o) {
        return GCH.dateToFecha((Date) o);
    }
}
