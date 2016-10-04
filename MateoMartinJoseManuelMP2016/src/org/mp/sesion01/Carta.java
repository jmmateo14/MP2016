package org.mp.sesion01;

public class Carta implements Comparable {

	private String palo;
	private int numero;
	private int valor;

	// ToDo....

	/**
	 * Constructor de la clase Carta
	 * @param palo
	 * @param numero
	 */
	public Carta (String palo, int numero){
		this.palo = palo;
		this.numero = numero;

		if(palo.equals("O"))
			valor = numero;
		else if(palo.equals("C"))
			valor = numero * 100;
		else if(palo.equals("E"))
			valor = numero * 10000;
		else if(palo.equals("B"))
			valor = numero * 1000000;

	}

	/**
	 * Metodo get que devuelve el palo de la carta
	 * @return palo
	 */
	public String getPalo() {
		return palo;
	}

	/**
	 * Metodo get que devuelve el numero de la carta
	 * @return numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Metodo get que devuelve el valor de la carta
	 * @return valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Metodo que clona una carta
	 * @return new Carta
	 */
	public Carta clone(){
		return new Carta(palo, numero);
	}

	/**
	 *Metodo equals que compara dos cartas por palo y numero
	 * @param c
	 * @return true en caso de ser la misma carta, false en caso contrario
	 */
	public boolean equals(Carta c){
		if(this.palo.equals(c.palo) && this.numero == c.numero)
			return true;
		else
			return false;
	}

	/**
	 * Metodo toString de la clase Carta wue nos devuelve una cadena de caracteres
	 */
	@Override
	public String toString(){
		return "Inf carta:\n"+numero+"de "+palo+"\nValor: "+valor;
	}

	/**
	 * Metodo compareTo, para compara cartas por valor
	 */
	public int compareTo(Object o){
		Carta carta = (Carta) o;
		if(this.valor == carta.valor)
			return 0;
		else if(this.valor > carta.valor)
			return 1;
		else
			return -1;
	}




}
