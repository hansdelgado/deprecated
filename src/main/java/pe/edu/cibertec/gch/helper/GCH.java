package pe.edu.cibertec.gch.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import pe.edu.cibertec.gch.modelo.Programa;

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
        if(fecha == null){
            fecha = new Date();
        }
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

    public static void dump(String mensaje, Programa programa) {
        System.out.println("==========" + mensaje + "============");
        dump("titulo", programa.getTitulo());
        dump("descripcion", programa.getDescripcion());
        dump("objetivo", programa.getObjetivos());
        dump("requisito", programa.getRequisitos());
        dump("modena", programa.getMoneda());
        dump("precio", programa.getPrecio());
        dump("duracion", programa.getDuracion());
        dump("fechaIncial", dateToFecha(programa.getFechaInicial()));
        System.out.println("========FIN " + mensaje + "==============");
    }
}
