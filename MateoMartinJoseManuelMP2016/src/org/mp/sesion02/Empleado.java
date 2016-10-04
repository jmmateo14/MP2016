package org.mp.sesion02;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Empleado extends Persona{

	private String despacho;
	private int salario;
	private GregorianCalendar fecha;

	/**
	 * Constructor de la clase Empleado
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param email
	 * @param despacho
	 * @param salario
	 * @param fecha
	 */
	public Empleado(String nombre, String direccion, String telefono, String email,String despacho, int salario, GregorianCalendar fecha){
		super(nombre, direccion, telefono, email);
		this.despacho = despacho;
		this.salario = salario;
		this.fecha = fecha;
	}

	/**
	 * Metodo toString de la clase Empleado que nos devuelve una cadena de caracteres
	 */
	public String toString(){
		String cadena = super.toString() + "\n" + "Despacho = " + despacho + ", salario = "
				+ salario + ", Fecha de contratación = " +  fecha.get(Calendar.DAY_OF_MONTH) + "/" + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);
		return cadena;
	}
}
