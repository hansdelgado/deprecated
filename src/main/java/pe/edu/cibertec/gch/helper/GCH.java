package pe.edu.cibertec.gch.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author DanJoas
 */
public final class GCH {
    // habilitar mensajes de depuracion.

    final static boolean debug = true;

    public static Date fechaToDate(String yyyyMMdd) {
        // formato fecha : "yyyy-MM-dd"
        int dia = Integer.parseInt(yyyyMMdd.substring(8)),
                mes = Integer.parseInt(yyyyMMdd.substring(5, 7)),
                ano = Integer.parseInt(yyyyMMdd.substring(0, 4));
        final Calendar cal = Calendar.getInstance();
        cal.setLenient(false);
        cal.clear();
        cal.set(ano, mes - 1, dia);

        return cal.getTime();
    }

    public static String dateToFecha(Date fecha) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(fecha);
    }

    public static void dump(String mensaje, Object obj) {
        if (debug) {
            System.out.println(mensaje + " : " + obj);
        }
    }

    public static void dump(String mensaje, String parametro, Object obj) {
        if (debug) {
            System.out.println(mensaje + " -> " + parametro + " : " + obj);
        }
    }
}
