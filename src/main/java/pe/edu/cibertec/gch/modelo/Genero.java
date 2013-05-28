package pe.edu.cibertec.gch.modelo;

/**
 * Representa al genero de una persona
 */
public enum Genero {
    Masculino, Femenino, Indeterminado;

    public static Genero obtenerSegun(String sexo) {
        switch(sexo) {
            case "m":
                return Masculino;
            case "f":
                return Femenino;
            default:
                return Indeterminado;
        }
    }
}
