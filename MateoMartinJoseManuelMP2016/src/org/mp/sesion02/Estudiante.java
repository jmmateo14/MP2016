package org.mp.sesion02;

public class Estudiante extends Persona{

	private int nivel;

	/**
	 * Constructor de la clase Estudiante
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param email
	 * @param nivel
	 */
	public Estudiante(String nombre, String direccion, String telefono, String email, int nivel) {
		super(nombre, direccion, telefono, email);
		this.nivel = nivel;
	}

	/**
	 * Metodo toString de la clase Estudiante que nos devuelve una cadena de caracteres
	 */
	public String toString(){
		if(nivel == 1)
			return "Estudiante de Grado\n" + super.toString();
		else if (nivel == 2)
			return "Estudiante de Master\n" + super.toString();
		else
			return "Estudiante de Doctorado\n" + super.toString();
	}
}
