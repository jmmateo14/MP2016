package org.mp.sesion01;

import java.util.Random;

public class Baraja {

	private String nombreBaraja;
	private Carta[] cartas;

	// ToDo ...

	/**
	 * Contructor de la clase Baraja.
	 * @param nombreBaraja
	 * @param carta
	 */
	public Baraja (String nombreBaraja, Carta[] carta){
		this.nombreBaraja = nombreBaraja;
		cartas = new Carta[carta.length];
		for(int i = 0; i < cartas.length; i++){
			cartas[i] = carta[i].clone();
		}
	}

	/**
	 * Metodo get del nombre de la baraja
	 * @return nombreBaraja
	 */
	public String getNombreBaraja() {
		return nombreBaraja;
	}

	/**
	 * Metodo get de las cartas.
	 * @return
	 */
	public Carta[] getCartas() {
		return cartas;
	}

	/**
	 * Metodo to String de la clase Baraja
	 */
	public String toString(){
		String cadena = "";
		for(int i = 0; i < cartas.length; i++){
			cadena = cadena + cartas[i] + "\n";
		}
		return cadena;
	}


}

