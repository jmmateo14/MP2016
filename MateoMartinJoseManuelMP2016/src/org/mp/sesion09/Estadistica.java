package org.mp.sesion09;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Estadistica {

	private ConjuntoDatos cd;
	
	public Estadistica (ConjuntoDatos cd) {
		this.cd = cd;
	}
	
	public double media (String columna) {
		double []v = cd.getColumna(columna);
		DescriptiveStatistics ds = new DescriptiveStatistics(v);
		return ds.getMean();
	}
	
	public double max (String columna) {
		double []v = cd.getColumna(columna);
		DescriptiveStatistics ds = new DescriptiveStatistics(v);
		return ds.getMax();
	}
	
	public double min (String columna) {
		double []v = cd.getColumna(columna);
		DescriptiveStatistics ds = new DescriptiveStatistics(v);
		return ds.getMin();
	}
	
	public double suma (String columna) {
		double []v = cd.getColumna(columna);
		DescriptiveStatistics ds = new DescriptiveStatistics(v);
		return ds.getSum();
	}
}
