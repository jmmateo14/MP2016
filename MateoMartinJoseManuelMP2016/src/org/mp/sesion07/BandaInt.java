package org.mp.sesion07;

public class BandaInt {

	private String nombreBanda;
	private int [][]datos;
	
	/**
	 * Constructor BandaInt. Instance a BandaInt passed as parameter the
	 * name of the banda, number of columns and number of lines.
	 * 
	 * @param nombre
	 *            name of the banda.
	 * @param y
	 *            number of columns.
	 * @param x
	 *            number of lines.
	 */
	public BandaInt (String nombre, int x, int y){
		nombreBanda = nombre;
		datos = new int [y][x];
	}
	
	/**
	 * Constructor BandaInt. Instance a BandaInt passed as parameter the 
	 * nambe of the banda and a matrix int with data.
	 * 
	 * @param nombre
	 *            name of the banda.
	 * @param datos
	 *            matrix int with data of the banda.
	 */
	public BandaInt (String nombre, int [][]datos){
		nombreBanda = nombre;
		this.datos = datos;
	}
	
	/**
	 * Method getter of the name of the banda.
	 * 
	 * @return name of the banda.
	 */
	public String getNombreBanda(){
		return nombreBanda;
	}
	
	/**
	 * Method setter of the name of the banda.
	 * 
	 * @param nombreBanda
	 *            name of the banda.
	 */
	public void setNombreBanda(String nombreBanda){
		this.nombreBanda = nombreBanda;
	}
	
	/**
	 * Method getter of the data of the banda.
	 * 
	 * @return int[][] with data of the banda.
	 */
	public int [][]getDatos(){
		return datos;
	}
	
	/**
	 * Method setter of tha data of the banda.
	 * 
	 * @param datos
	 *            int[][] with data of the banda.
	 */
	public void setDatos (int [][]datos){
		this.datos = datos;
	}
	
	/**
	 * Method getter of a datum (x,y) of the banda.
	 * 
	 * @param x
	 *            number of line.
	 * @param y
	 *            number of column.
	 * @return datum (x,y) of the banda.
	 */
	public int getDatosXY (int x, int y){
		return datos[y][x];
	}
	
	/**
	 * Method setter of a datum (x,y) of the banda.
	 * 
	 * @param dato
	 *            datum to add to the banda.
	 * @param x
	 *            number of line of the banda.
	 * @param y
	 *            number of column of the banda.
	 * @param antes 
	 * 			  datos[x][y] with the data of the banda.
	 * @return antes 
	 */
	public int setDatoXY (int dato, int x, int y){
		int antes = datos[y][x];
		datos[y][x] = dato;
		return antes;
	}
	

	/**
	 * Method toString of BandaInt. Returns the name of the bandas
	 * and the data of the banda one below the other.
	 * 
	 *  @return cadena.
	 */
	public String toString(){
		String cadena = nombreBanda + "\n";
		for (int i = 0; i < datos.length; i++){
			for (int j = 0; j < datos[i].length; j++){
				cadena = cadena + datos[i][j] + " ";
			}
			cadena = cadena + "\n";
		}
		return cadena;
	}
}
