package org.mp.sesion07;

import java.io.Serializable;

public class Habitacion implements Serializable{

	private String numero;
	
	/**
	 * Instance a new room.
	 * 
	 * @param numero
	 *            number of the room.
	 */
	public Habitacion(String numero) {
		// TODO Auto-generated constructor stub
		this.numero = numero;
	}
	
	/**
	 * Method getter of the number of room.
	 * 
	 * @return number of room
	 */
	public String getNumero() {
		return numero;
	}
	
	/**
	 * Method setter of the number of room.
	 * @param numero
	 * 			  number of room.
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
