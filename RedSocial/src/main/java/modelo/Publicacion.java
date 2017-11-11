package modelo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

/**
 * Clase encargada de materializar las publicaciones y sus respectivos datos.
 *
 *
 * @since 1.0
 * @version 1.1 Changes done
 */
public class Publicacion {
	String mensaje, compartirCon, username;
	LinkedList<String> adjuntos;
	Date fecha;
	
	//PARA CREAR UNA PUBLICACION NUEVA
	public Publicacion(String user, String m, String cC, LinkedList<String>adj) {
		setUsername(user);
		setMensaje(m);
		setCompartirCon(cC);
		setAdjuntos(adj);
		creaFecha();
	}
	//ESPECIAL: SOLO PARA LECTURA DE PUBLICACIONES DE LA BASE DATOS
	public Publicacion(String user, String m, String cC, LinkedList<String>adj, String f) {
		setUsername(user);
		setMensaje(m);
		setCompartirCon(cC);
		setAdjuntos(adj);
		setFecha(f);
	}
	
		
	protected String getMensaje() {
		return mensaje;
	}
	private void setMensaje(String mensaje) {
		this.mensaje = mensaje;
		creaFecha();
	}
	private String getCompartirCon() {
		return compartirCon;
	}
	private void setCompartirCon(String compartirCon) {
		this.compartirCon = compartirCon;
		creaFecha();
	}
	protected LinkedList<String> getAdjuntos() {
		return adjuntos;
	}
	private void setAdjuntos(LinkedList<String> adjuntos) {
		this.adjuntos = adjuntos;
	}
	private String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
		creaFecha();
	}
	public Date getFecha() {
		return fecha;
	}
	private void setFecha(String fecha) {
		try {
			DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
			this.fecha= format.parse(fecha);
		} catch (ParseException e) {
			String message = "Unexpected settingDate exception";
			logger.log(Level.ERROR, message, e);
		}
	}
	private void creaFecha() {
		this.fecha=new Date();
	}
}
