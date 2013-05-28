package pe.edu.cibertec.gch.modelo;

/**
 * Uno de los rango horarios en que se dictan las clases de una seccion.
 */
public class HorarioDictado {

    private long id;
    private Seccion seccion;
    private Horario horario;
    private Laboratorio laboratorio;
    private Dia dia;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }
}
