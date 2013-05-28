package pe.edu.cibertec.gch.gestores;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import pe.edu.cibertec.gch.modelo.EstadoProfesor;
import pe.edu.cibertec.gch.modelo.Profesor;
import pe.edu.cibertec.gch.modelo.TipoBusqueda;

/**
 * Realiza operaciones relacionadas al profesor.
 */
public class GestorProfesor {

    private static final List<Profesor> profesores = new ArrayList<>();

    public void registrar(Profesor profesor) {
        profesores.add(profesor);
        try {
            sendMail("paolo.carrasco@gmail.com", "llega mi correo desde la aplicacion", "wohoo!! lo hicimos!!");
        } catch (NamingException | MessagingException ex) {
            Logger.getLogger(GestorProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(Profesor profesor) {
        profesores.set(profesores.indexOf(profesor), profesor);
    }

    public void eliminar(Profesor profesor) {
        profesores.remove(profesor);
    }

    public List<Profesor> listarSegun(String nombres,
            String apellidoPaterno, String apellidoMaterno, TipoBusqueda tipoBusqueda) {
        List<Profesor> encontrados = new LinkedList<>();
        for (Profesor profesor : profesores) {
            switch (tipoBusqueda) {
                case Completa:
                    if (apellidoPaterno.equalsIgnoreCase(profesor.getApellidoPaterno())
                            || apellidoMaterno.equalsIgnoreCase(profesor.getApellidoMaterno())
                            || nombres.equalsIgnoreCase(profesor.getNombres())) {
                        encontrados.add(profesor);
                    }
                    break;
                case Parcial:
                    if ((!apellidoPaterno.isEmpty() && profesor.getApellidoPaterno().contains(apellidoPaterno))
                            || (!apellidoMaterno.isEmpty() && profesor.getApellidoMaterno().contains(apellidoMaterno))
                            || (!nombres.isEmpty() && profesor.getNombres().contains(nombres))) {
                        encontrados.add(profesor);
                    }
                    break;
                default:
                    break;
            }
        }
        return encontrados;
    }

    public List<Profesor> listarTodos() {
        return profesores;
    }

    protected void borrarTodos() {
        profesores.clear();
    }

    public void eliminarSegun(String codigo) {
        Profesor profesorAEliminar = consultarSegun(codigo);
        profesorAEliminar.setEstado(EstadoProfesor.Inactivo);

    }

    public Profesor consultarSegun(final String codigo) {
        Profesor profesorBuscado = new Profesor() {
            {
                setCodigo(codigo);
            }
        };
        return profesores.get(profesores.indexOf(profesorBuscado));
    }

    private Session getSesionEmail() throws NamingException {
        Context c = new InitialContext();
        return (Session) c.lookup("java:comp/env/sesionEmail");
    }

    private void sendMail(String email, String subject, String body) throws NamingException, MessagingException {
        Session sesionEmail = getSesionEmail();
        MimeMessage message = new MimeMessage(sesionEmail);
        message.setSubject(subject);
        message.setRecipients(RecipientType.TO, InternetAddress.parse(email, false));
        message.setText(body);
        Transport.send(message);
    }
}
