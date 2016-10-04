package org.mp.sesion02;

public class Persona {

	private String nombre;
	private String direccion;
	private String telefono;
	private String email;

	/**
	 * Constructor de la clase Persona
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param email
	 */
	public Persona (String nombre, String direccion, String telefono, String email){
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	/**
	 * Metodo toString de la clase Persona que nos devuelve una cadena de caracteres
	 */
	public String toString(){
		String cadena = "Nombre = " + nombre + ", Direccion = " + direccion + ", Teléfono = " + telefono + ", email = " + email;
		return cadena;
	}
}
