package org.mp.sesion02;

import java.util.GregorianCalendar;

public class Administrativo extends Empleado{

	private String funcion;

	/**
	 * Constructor de la clase Administrador
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param email
	 * @param despacho
	 * @param salario
	 * @param fecha
	 * @param funcion
	 */
	public Administrativo(String nombre, String direccion, String telefono, String email, String despacho, int salario,
			GregorianCalendar fecha, String funcion) {
		super(nombre, direccion, telefono, email, despacho, salario, fecha);
		this.funcion = funcion;
	}


	/**
	 * Metodo toString de la clase Administrador que nos devuelve una cadena de caracteres
	 */
	public String toString(){
		String cadena = "Administrativo\n" + super.toString() + "\n" + "Destinado en la unidad " + funcion;
		return cadena;
	}
}
