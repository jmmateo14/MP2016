package org.mp.sesion05;

import java.util.Random;

public class Baraja {

	private String nombreBaraja;
	private Carta[] cartas;

	/**
	 * Constructor method for objects of type Baraja
	 * @param nombreBaraja value assigned a la propiedad nombreBaraja
	 * @param cartas vector de cartas que se asigna to the feature cartas
	 */
	public Baraja(String nombreBaraja, Carta[] cartas) {
		this.nombreBaraja = nombreBaraja;
		this.cartas = cartas;
	}
	/**
	 * Gets the cartas.
	 *
	 * @return the cartas
	 */
	public Carta[] getCartas() {
		return cartas;
	}
	
	
}
