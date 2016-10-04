package org.mp.sesion05;

public class Carta implements Comparable {

	private String palo;
	private int numero;
	private int valor;

	/**
	 * Class constructor method carta that gives value to the
	 * object properties
	 * the property valor stores a number of card having  
	 * into account the natural sort (golds, cups, spades and 
	 * clubs) for that be ascending numbers in that order
	 * @param suit series to save in the property palo
	 * @param whole numbers to save in the property numero
	 */
	public Carta(String palo, int numero) {
		this.palo = palo;
		this.numero = numero;
		switch (palo) {
		case "O": this.valor = this.numero; break;
		case "C": this.valor = 12 + this.numero; break;
		case "E": this.valor = 24 + this.numero; break;
		case "B": this.valor = 36 + this.numero; break;
		}
	}
	

	/**
	 * Method comparable, that compare between the values of the cards
	 */
	public int compareTo (Object o) {
		Carta c = (Carta) o;
		if (this.valor < c.valor)
			return -1;
		if (this.valor > c.valor)
			return +1;
		return 0;
	}

	public String getPalo() {
		return palo;
	}

	public int getNumero() {
		return numero;
	}
	
	public int getValor () {
		return valor;
	}
	
	/**
	 * Method that compare between the values of the cards
	 * @return false if the values the cards is different
	 * @return true if the values the cards is equal
	 */
	public boolean equals (Object o) {
		if ( ! (o instanceof Carta))
			return false;
		Carta c = (Carta) o;
		if (valor == c.valor)
			return true;
		return false;
	}
}
