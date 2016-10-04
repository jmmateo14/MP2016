package org.mp.sesion07;

import java.io.Serializable;
import java.util.Date;

public class Residente implements Serializable{

	private String nombre;
	private String dni;
	private char sexo;
	private Date fechaNacimiento;
	
	/**
	 * Instance a new resident.
	 * @param nombre
	 * 			name of the resident.
	 * @param dni
	 * 			dni of the resident.
	 * @param sexo
	 * 			sex of the resident.
	 * @param fechaNacimiento
	 * 			date of birth of the resident.
	 */
	public Residente(String nombre, String dni, char sexo, 
			Date fechaNacimiento) {
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Method getter of the name of resident.
	 *
	 * @return name resident.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Method setter of the name of the resident.
	 *
	 * @param nombre 
	 * 			name od the resident.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Method getter of the dni of the resident.
	 *
	 * @return dni resident.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Method setter of the dni of the resident.
	 *
	 * @param dni dni to assign to resident.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Method getter of the sex of the resident.
	 *
	 * @return sex of the resident.
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * Method setter of the sex of the resident
	 *
	 * @param sexo
	 * 			 sex resident to assign.
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * Method getter of the date of birth of the resident.
	 *
	 * @return date of birth resident.
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Method setter of the date of birth of resident.
	 *
	 * @param fechaNacimiento resident.
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Method getter of the age of the resident.
	 *
	 * @return age of the resident.
	 */
	public int getEdad(Date fechaActual) {
		int edad = fechaActual.getYear() - fechaNacimiento.getYear();
		if (fechaActual.getMonth() < fechaNacimiento.getMonth())
			edad--;
		else {
			if (fechaActual.getMonth() == fechaNacimiento.getMonth() &&
					fechaActual.getDate() < fechaNacimiento.getDate())
				edad--;
		}
		return edad;
	}
	
	

}


