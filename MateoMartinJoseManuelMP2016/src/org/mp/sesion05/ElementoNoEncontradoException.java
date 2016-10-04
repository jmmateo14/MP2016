package org.mp.sesion05;

/**
 * Exception for element not found
 */
public class ElementoNoEncontradoException extends Exception {
	/**
	 * Builder for the exception
	 * 
	 * @param s
	 *            It contains the error message
	 */
	public ElementoNoEncontradoException(String s) {
		super(s);
	}
}