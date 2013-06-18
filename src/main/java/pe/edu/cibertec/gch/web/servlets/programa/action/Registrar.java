package pe.edu.cibertec.gch.web.servlets.programa.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import pe.edu.cibertec.gch.dao.FactoryDao;
import pe.edu.cibertec.gch.modelo.Programa;
import pe.edu.cibertec.gch.helper.GCH;

/**
 *
 * @author DanJoas
 */
public class Registrar extends ActionSupport {

    private List<Programa> programas;
    private Programa programa;

    @Override
    public String execute() throws Exception {


        /*  GCH.dump("titulo", programa.getTitulo());
         GCH.dump("descripcion", programa.getDescripcion());
         GCH.dump("objetivo", programa.getObjetivos());
         GCH.dump("requisito", programa.getRequisitos());
         GCH.dump("modena", programa.getMonedaStr());
         GCH.dump("precio", programa.getPrecio());
         GCH.dump("duracion", programa.getDuracion());
         GCH.dump("fechaIncial", GCH.dateToFecha(programa.getFechaInicial()));
         */

        FactoryDao.getInstance().getProgramaDao().registrar(programa);
        programas = FactoryDao.getInstance().getProgramaDao().listarTodos();
        return SUCCESS;
    }

    @Override
    public void validate() {
        // realizamos algunas validaciones 


        try {
            Integer.parseInt(programa.getCodigo());
        } catch (NumberFormatException nfe) {
            addFieldError("codigo", "el codigo debe contener solo numeros");
        }

        try {
            if (programa.getDuracion() > 140) {
                addFieldError("duracion", "la duracion maxima es de 140");
            }
        } catch (NumberFormatException nfe) {
            addFieldError("duracion", "la duracion debe contener solo numeros");
        }

        try {
            if (programa.getPrecio() > 5000) {
                addFieldError("precio", "el precio maximo es 5000 soles");
            }
        } catch (NumberFormatException nfe) {
            addFieldError("precio", "el precio debe contener solo numeros");
        }

        if (programa.getTitulo().length() > 45) {
            addFieldError("titulo", "el titulo no debe ser mayor a 45 caracteres");
        }
        if (programa.getDescripcion().length() > 45) {
            addFieldError("descripcion", "el descripcion no debe ser mayor a 45 caracteres");
        }
        if (programa.getObjetivos().length() > 45) {
            addFieldError("objetivos", "objetivos puede tener hasta 45 caracteres");
        }
        if (programa.getRequisitos().length() > 45) {
            addFieldError("requisitos", "requisitos puede tener hasta 45 caracteres");
        }

        if (programa.getTitulo().isEmpty()) {
            addFieldError("titulo", "el titulo no debe estar vacio");
        }
        if (programa.getDescripcion().isEmpty()) {
            addFieldError("descripcion", "descripcion no debe estar vacio");
        }
        if (programa.getObjetivos().isEmpty()) {
            addFieldError("objetivos", "los objetivos no debe estar vacio");
        }
        if (programa.getRequisitos().isEmpty()) {
            addFieldError("requisitos", "requisitos no debe estar vacio");
        }

        if (programa.getMonedaStr().isEmpty()) {
            addFieldError("moneda", "debe seleccionar su tipo de moneda");
        }

        if (!GCH.dateToFecha(programa.getFechaInicial()).matches("\\d{1,4}[/-]\\d{1,2}[/-]\\d{1,4}")) {
            addFieldError("requisitos", "la fecha ingresada no cumple con el formato. (ejemplo 12/05/2013) ");
        }

        if (programa.getTitulo().isEmpty()) {
            addFieldError("titulo", "el titulo no debe estar vacio");
        }
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }
    
    
}
