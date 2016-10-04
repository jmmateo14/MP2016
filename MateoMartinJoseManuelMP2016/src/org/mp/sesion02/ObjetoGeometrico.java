package org.mp.sesion02;

import java.util.Calendar;
import java.util.GregorianCalendar;



public  abstract class ObjetoGeometrico{

	protected String color = "blanco";
	protected boolean relleno;
	protected GregorianCalendar fechaCreado = new GregorianCalendar();


	/**
	 * Constructor vacio o por defecto
	 */
	protected ObjetoGeometrico(){

	}

	/**
	 * Constructor de la clase ObjetoGeometrico
	 * @param color
	 * @param relleno
	 */
	protected ObjetoGeometrico(String color, boolean relleno){
		super();
		this.color = color;
		this.relleno = relleno;

	}

	/**
	 * Metodo get que nos devuelve el color
	 * @return
	 */
	public String getColor() {
		return color;
	}

	/**
	 * metodo set del parametro color
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Metodo get del parametro relleno que nos indica si la figura esta rellena o no con true o false
	 * @return
	 */
	public boolean esRelleno() {
		return relleno;
	}

	/**
	 * Metodo set del parametro relleno
	 * @param relleno
	 */
	public void setRelleno(boolean relleno) {
		this.relleno = relleno;
	}

	/**
	 * Metodo get que nos devuelve la fecha de creacion del objeto
	 */
	public GregorianCalendar getFechaCreado() {
		return fechaCreado;
	}

	/**
	 * Metodo toString de la clase para que nos devuelva una cadena de caracteres
	 */
	public String toString(){
		String cadena = "Creado el " + fechaCreado.getTimeZone() + "\ncolor: " + color + "y relleno: " + relleno;
		return cadena;
	}

	/**
	 * Metodo  get abstracto del parametro area, implmentado en la clase Octogono,
	 * nos devuelve el area.
	 * @return
	 */
	public  abstract double getArea();

	/**
	 * Metodo  get abstracto del parametro perimetro, implmentado en la clase Octogono,
	 * nos devuelve el perimetro.
	 * @return
	 */
	public abstract double getPerimetro();




}
