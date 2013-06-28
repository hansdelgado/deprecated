package pe.edu.cibertec.gch.programa.validador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class ClaveSeguraValidation extends FieldValidatorSupport {

    private String caracteres;
    static Pattern patronDigito = Pattern.compile("[0-9]");
    static Pattern patronLetra = Pattern.compile("[a-zA-Z]");

    @Override
    public void validate(Object object) throws ValidationException {

        String campo = getFieldName();
        String clave = (String) getFieldValue(campo, object);

        clave = clave.trim(); // retiramos expacion en blanco
        
        // creamos el patron personalizado
        Pattern patronCarateres = Pattern.compile("[" + getCaracteres() + "]");
        
        //  preparamos la evaluacion
        Matcher tieneDigito = patronDigito.matcher(clave);
        Matcher tieneLetra = patronLetra.matcher(clave);      
        Matcher tieneCaracteres = patronCarateres.matcher(clave);
        
        // evaluamos 
        if (!tieneDigito.find()) {
            addFieldError(campo, object);
        } else if (!tieneLetra.find()) {
            addFieldError(campo, object);
        } else if (!tieneCaracteres.find()) {
            addFieldError(campo, object);
        }
    }

    /* Metodos de acceso  del parametro  : caracteres
     * <param name="caracteres">@#</param>  
     */
    
    public String getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(String caracteres) {
        this.caracteres = caracteres;
    }
}
