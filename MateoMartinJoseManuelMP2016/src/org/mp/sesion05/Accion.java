package org.mp.sesion05;

public class Accion implements Comparable {

	private String nombre;
	private long volumen;
	
	/**
	 * Constructor of Accion. Instance a new  share.
	 * 
	 * @param n
	 *            name of the share.
	 * @param v
	 *            volume of the share.
	 */
	public Accion(String nombre, long volumen) {
		this.nombre = nombre;
		this.volumen = volumen;
	}

	/**
	 * Returns the name of the share.
	 * 
	 * @return name share.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Assigns a new name of share.
	 * 
	 * @param n
	 *            new name of share.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Returns the volume of the share.
	 * 
	 * @return volume share.
	 */
	public long getVolumen() {
		return volumen;
	}
	
	/**
	 * Assigns a new volume of share.
	 * 
	 * @param n
	 *            new volume of share.
	 */
	public void setVolumen(long volumen) {
		this.volumen = volumen;
	}

	/**
	 * Compares two action to watch if they are equal, the share that calls the method and the 
	 * share that pass to parameter.
	 * 
	 * @return true if they are equal, false in case contrary.
	 */
	public boolean equals (Object obj) {
		if ( ! (obj instanceof Accion))
			return false;
		Accion a = (Accion) obj;
		if (nombre.equals(a.nombre))
			return true;
		return false;
	}
	
	/**
	 * Prints the contents of the share.
	 * 
	 * @return contents of the share.
	 */
	public String toString () {
		return nombre+" "+volumen;
	}

	/**
	 * Compares two share, the share that calls the method and the 
	 * share that pass to parameter.
	 * 
	 * @return -1, 0, or 1 in case of that the share that calls the method is
	 *         lower, equal or higher that the share that pass to parameter.
	 */
	@Override
	public int compareTo(Object o) {
		Accion a = (Accion) o;
		if (nombre.compareTo(a.nombre) < 0)
			return -1;
		if (nombre.compareTo(a.nombre) > 0)
			return 1;
		//cuando coincide el nombre, comparo por volumen
		if (volumen < a.volumen)
			return -1;
		if (volumen > a.volumen)
			return 1;
		return 0;
	}

}
