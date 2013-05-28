package pe.edu.cibertec.gch.modelo;

/**
 * Indica la situacion en que se encuentra un laboratorio.
 */
public enum EstadoLaboratorio {

    /**
     * Que tiene todo lo necesario para que las clases se dicten con normalidad.
     */
    Implementado,
    /**
     * Que tiene pendiente algunas mejoras para que las clases se puedan dictar
     * con normalidad.
     */
    PendienteImplementacion,
    /**
     * Que tiene problemas que requieren una solucion importante para poder
     * dictar clases.
     */
    ConProblemas,
    /**
     * El local ha declarado el salon no podra ser usado para clases.
     */
    Deshabilitado,
    /**
     * El laboratorio tiene otros planes para el laboratorio.
     */
    NoDisponible
}
