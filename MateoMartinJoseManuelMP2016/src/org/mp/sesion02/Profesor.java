package org.mp.sesion02;

import java.util.GregorianCalendar;

public class Profesor extends Empleado{

	private String tutoria;
	private int categoria;


	/**
	 * Constructor de la clase Profesor
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param email
	 * @param despacho
	 * @param salario
	 * @param fecha
	 * @param tutoria
	 * @param categoria
	 */
	public Profesor(String nombre, String direccion, String telefono, String email, String despacho, int salario,
			GregorianCalendar fecha, String tutoria, int categoria) {
		super(nombre, direccion, telefono, email, despacho, salario, fecha);
		this.tutoria = tutoria;
		this.categoria = categoria;
	}

	/**
	 * Metodo toString de la clase Profesor que nos devuelve una cadena de caracteres
	 */
	public String toString(){
		if(categoria == 1)
			return "Profesor Ayudante\n" + super.toString() + "\n" + "Horario = " + tutoria;
		else if(categoria == 2)
			return "Profesor Titular de Universidad\n" + super.toString() + "\n" + "Horario = " + tutoria;
		else
			return "Profesor Catedrático de Universidad\n" + super.toString() + "\n" + "Horario = " + tutoria;
	}

}
