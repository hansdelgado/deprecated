package pe.edu.cibertec.gch.modelo;

/**
 * Estado de actividad en que se encuentra un curso, programa u horario en 
 * cierto momento.
 */
public enum EstadoActividad {
    /**
     * En el caso de curso/programa, que puede ser dictado. En el caso de 
     * horario, que se puede dictar en este rango horario.
     */
    Valido,
    /**
     * El en el caso de curso/programa, que esta desactualizado o el topico 
     * principal del curso/programa ya no tiene sentido de seguir siendo dictado.
     * En el caso de horario, que ya no aplica este rango horario.
     */
    Obsoleto
}
