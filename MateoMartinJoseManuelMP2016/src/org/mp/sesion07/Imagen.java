package org.mp.sesion07;

import java.util.ArrayList;

public class Imagen {
	
	private String formatoImagen;
	private ArrayList<BandaInt> bandas;
	private int lineas;
	private int columnas;
	
	/**
	 * Instance a new imagen.
	 * 
	 * @param lineas
	 *            number of lines of the bandas.
	 * @param columnas
	 *            number of columns of the bandas.
	 * @param formatoImagen
	 *            format of the imagen.
	 */
	public Imagen (int lineas, int columnas, String formatoImagen){
		this.formatoImagen = formatoImagen;
		this.lineas = lineas;
		this.columnas = columnas;
		bandas = new ArrayList<BandaInt> ();
	}
	

	/**
	 * Method getter of the data of a pixel specific.
	 * 
	 * @param x
	 *            index column of the bandas.
	 * @param y
	 *            index line of the bandas.
	 * @return data of a pixel specific of all the bandas.
	 * @throws XYFueraImagenException
	 *             verifies that the points x1,y1 not become out of the rank of
	 *             the bandas of the image.
	 */
	public int[] getDatosPixel (int x, int y)
		throws XYFueraImagenException{
			if (x < 0 || x >= columnas || y < 0 || y >= lineas)
				throw new XYFueraImagenException("Error en getDatosPixel");
		int []p = new int [bandas.size()];
		for(int i = 0; i < bandas.size(); i++){
			p[i] = bandas.get(i).getDatosXY(x, y);
		}
		return p;
	}
	
	/**
	 * Extract the data of the bandas of the image from the points x1,y1 to
	 * x2,y2
	 * 
	 * @param x1
	 *            index initiation of the columns of the bandas to read.
	 * @param y1
	 *            index initiation of the lines of the bandas to read.
	 * @param x2
	 *            index final of the columns of the bandas to read.
	 * @param y2
	 *            index final of the lines of the bandas to read
	 * @return image with all data of the points of the rank [x1,y1;x2,y2]
	 *         of the bandas.
	 * @throws XYFueraImagenException
	 *             verifies that the points x1,y1 and x2,y2 not become out of the rank of
	 *             the bandas of the image.
	 */
	public Imagen extraerImagen (int x1, int y1, int x2, int y2)
		throws XYFueraImagenException{
			if ( ! XYValida(x1, y1, x2, y2))
				throw new XYFueraImagenException("Error en extraer imagen");
			Imagen nueva;
			int nuevasLineas = y2 - y1 + 1;
			int nuevasColumnas = x2 - x1 + 1;
			nueva = new Imagen (nuevasLineas, nuevasColumnas, formatoImagen);
			for (int i = 0; i < bandas.size(); i++){
				BandaInt banda = bandas.get(i);
				BandaInt nuevaBanda = new BandaInt (banda.getNombreBanda(), nuevasColumnas, nuevasLineas);
				
				for (int c = x1; c <= x2; c++){
					for(int f = y1; f <=  y2; f++){
						int x = c - x1;
						int y = f - y1;
						int dato = banda.getDatosXY(c, f);
						nuevaBanda.setDatoXY(dato, x, y);
					}
				}
				nueva.añadirBanda(nuevaBanda);
			}
			
			return nueva;
	}
	
	/**
	 * Add a banda to the image.
	 * 
	 * @param banda
	 *            banda to add.
	 */
	public void añadirBanda(BandaInt banda){
		bandas.add(banda);
	}
	/**
	 * Delete a banda of the image.
	 * 
	 * @param i
	 *            index of the banda to deleter.
	 */
	public void eliminarBanda(int i){
		bandas.remove(i);
	}
	
	/**
	 * Method getter of a banda of the image.
	 * 
	 * @param i
	 *            index of the banda.
	 * @return banda of the image with index i.
	 */
	public BandaInt getBanda(int i){
		return bandas.get(i);
	}
	
	/**
	 * Method getter of all the bandas of the image.
	 * 
	 * @return All the bandas of the image.
	 */
	public ArrayList<BandaInt> getBandas(){
		return bandas;
	}

	/**
	 * Method getter of the number of lines of the bandas of the image.
	 * 
	 * @return number of lines.
	 */
	public int getLineas() {
		return lineas;
	}

	/**
	 * Method getter of the number of columns of the bandas of the image.
	 * 
	 * @return number of columns
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Method getter of the format of the image.
	 * 
	 * @return format of the image.
	 */
	public String getFormatoImagen(){
		return formatoImagen;
	}
	
	/**
	 * Method setter of the format of the image.
	 * 
	 * @param formatoImagen
	 *            format of the image.
	 */
	public void setFormatoImagen (String forrmatoImagen){
		this.formatoImagen = formatoImagen;
	}
	
	/**
	 * Method setter of the bandas of the image.
	 */
	public void setBandas (ArrayList<BandaInt> bandas){
		this.bandas = bandas;
	}
	
	/**
	 * Validates the range of points x1,y1 and x2,y2 of the bandas of the image.
	 * 
	 * @param x1
	 *            index initiation of the columns of the bandas.
	 * @param y1
	 *            index initiation of the lines of the bandas.
	 * @param x2
	 *            index final of the columns of the bandas.
	 * @param y2
	 *            index final of the lines of the bandas.
	 * 
	 * @return true in case of be a correct range , false in case contrary.
	 */
	private boolean XYValida (int x1, int y1, int x2, int y2){
		if(x1 >= 0 && x2 >= x1 && x2 < columnas && y1 >= 0 && y2 >= y1 && y2 < lineas)
			return true;
		else
			return false;
	}

	/**
	 * Method getter of the number of bandas of the image.
	 * 
	 * @return number of bandas
	 */
	public int getNumeroBandas() {
		// TODO Auto-generated method stub
		return bandas.size();
	}
	
	

}
