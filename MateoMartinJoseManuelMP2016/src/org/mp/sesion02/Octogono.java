package org.mp.sesion02;

public class Octogono extends ObjetoGeometrico implements Comparable, Cloneable, DeColor{
	protected double lado;

	/**
	 * contructor de la clase Octogono
	 * @param color
	 * @param relleno
	 * @param lado
	 */
	protected Octogono(String color, boolean relleno, double lado){
		super(color, relleno);
		this.lado = lado;
	}

	/**
	 * Constructor vacio
	 */
	protected Octogono(){

	}

	/**
	 * Metodo get que devuelve el lado del octogono
	 * @return
	 */
	public double getLado() {
		return lado;
	}

	/**
	 * Metodo set del parametro lado
	 * @param lado
	 */
	public void setLado(double lado) {
		this.lado = lado;
	}

	/**
	 * Metodo que colorea los lados del octogono
	 */
	public Object comoColorear() {
		// TODO Auto-generated method stub
		String cadena = "Colorear los 8 lados de " + color;
		return cadena;
	}

	/**
	 * Metodo compareTo, con el que comparamos dos octogonos para saber
	 * si son iguales, uno mayor que otro o uno menor que otro.
	 */
	public int compareTo(Object o) {
		ObjetoGeometrico oct = (ObjetoGeometrico) o;
		if(this.getArea() > oct.getArea())
			return 1;
		else if(this.getArea() < oct.getArea())
			return -1;
		else
			return 0;
	}

	/**
	 * Metodo clone, con el que clonamos un octogono.
	 */
	public Octogono clone(){
		 Octogono obj = new Octogono(this.color, this.relleno, this.lado);
		return obj;

	}

	/**
	 * Metodo get que nos devuelve el area del octogono
	 */
	public double getArea(){
		double resultado;
		resultado = ((2 + (4/Math.sqrt(2))) * Math.pow(lado, 2));
		return resultado;
	}

	/**
	 * Metodo get que nos devuelve el perimetro del octogono
	 */
	public double getPerimetro(){
		double perimetro;
		perimetro = 8 * lado;
		return perimetro;
	}

}
