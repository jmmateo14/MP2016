package org.mp.sesion06;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Estadistica {
	
	private ConjuntoDatos cd;
	
	/**
	 * Constructor Estadistica. Instantiates a object of the class Estadistica
	 * by assigning a ConjuntoDatos as a parameter.
	 */
	public Estadistica (ConjuntoDatos cd){
		this.cd = cd;
	}
	
	/**
	 * Method media. Returns the mean of all the data of a column passed
	 * as parameter.
	 */
	public double media (String columna){
		double []datos = cd.getColumna(columna);
		DescriptiveStatistics ds = new DescriptiveStatistics(datos);
		return ds.getMean();
	}
	
	/**
	 * Method max. Returns the highest all the data of a column passed
	 * as parameter.
	 */
	public double max (String columna){
		double []datos = cd.getColumna(columna);
		DescriptiveStatistics ds = new DescriptiveStatistics(datos);
		return ds.getMax();
	}
	
	/**
	 * Method min. Returns the minimum all the data of a column passed
	 * as parameter.
	 */
	public double min (String columna){
		double []datos = cd.getColumna(columna);
		DescriptiveStatistics ds = new DescriptiveStatistics(datos);
		return ds.getMin();
	}
	
	/**
	 * Method suma. Returns the sum all the data of a column passed
	 * as parameter.
	 */
	public double suma (String columna){
		double []datos = cd.getColumna(columna);
		DescriptiveStatistics ds = new DescriptiveStatistics(datos);
		return ds.getSum();
	}
}
