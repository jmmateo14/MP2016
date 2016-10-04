package org.mp.sesion06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConjuntoDatos {

	private File archivoTexto;
	private String separador;
	private Locale locale;
	private List cabecera;
	private int numeroLineas;
	private int numeroColumnas;
	private double [][]datos;
	
	/**
	 * Instance a ConjuntoDatos, receives as a parameter a archive, the
	 * separator of the data and a locale. Creates the header in case necessary,
	 * sets the number of lines, columns and the data of the archive.
	 */
	public ConjuntoDatos (File archivoTexto, String separador,
				Locale locale) {
		this.archivoTexto = archivoTexto;
		this.separador = separador;
		this.locale = locale;
		cabecera = cabecera (this.archivoTexto);
		numeroLineas = numLineas (this.archivoTexto);
		numeroColumnas = numColumnas (this.archivoTexto);
		datos = leerDatos (this.archivoTexto, numeroLineas, numeroColumnas);
	}
	
	/**
	 * Private method cabecera, processed the archive to get your header,
	 * add to List cabecera and returns.
	 * 
	 * @param archivoTexto
	 *            archive can have header.
	 * @return a List with the head.
	 */
	private List cabecera (File archivoTexto) {
		cabecera = new ArrayList ();
		
		try {
			//FileReader fr = new FileReader (archivoTexto);
			//BufferedReader br = new BufferedReader (fr);
			BufferedReader br = new BufferedReader (new FileReader
										(archivoTexto));
			String linea = br.readLine();
			Scanner entrada = new Scanner (linea);
			entrada.useDelimiter(separador);
			while (entrada.hasNext()) {
				cabecera.add(entrada.next());
			}
			br.close();
			//fr.close();
		}
		catch (IOException e) {
			System.out.println("Error de lectura");
		}
		return cabecera;
	}
	
	/**
	 * Private method that returns the number of lines of a past archive for
	 * parameter.
	 * 
	 * @param archivoTexto
	 *            archive of the that is counted and returns the lines.
	 * @return number of lines oof the archive.
	 */
	private int numLineas (File archivoTexto) {
		numeroLineas = 0;
		try {
			//FileReader fr = new FileReader (archivoTexto);
			//BufferedReader br = new BufferedReader (fr);
			BufferedReader br = new BufferedReader (new FileReader
										(archivoTexto));
			String linea = br.readLine();
			while (linea != null) {
				numeroLineas++;
				linea = br.readLine();
			}
			br.close();
			//fr.close();
		}
		catch (IOException e) {
			System.out.println("Error de lectura");
		}
		return numeroLineas - 1;
	}
	
	/**
	 * Private method numColumnas, returns the numbers of columns of a archive
	 * of text.
	 */
	private int numColumnas (File archivoTexto) {
		return cabecera.size();
	}
	
	/**
	 * Metodo privado leerDatos, processes the data of a archive of text pass
	 * for parameter together with the number of lines and columns. Read the data of the
	 * arhive and returns in form of  matrix double.
	 * 
	 * @return all the data of the archive of text.
	 */
	private double [][]leerDatos (File archivoTexto, int filas,
						int columnas) {
		datos = new double [filas][columnas];
		try {
			//FileReader fr = new FileReader (archivoTexto);
			//BufferedReader br = new BufferedReader (fr);
			BufferedReader br = new BufferedReader (new FileReader
										(archivoTexto));
			//leo la cabecera y paso de ella
			String linea = br.readLine();
			for (int i=0; i<filas; i++) {
				linea = br.readLine();
				Scanner entrada = new Scanner (linea);
				entrada.useDelimiter(separador);
				entrada.useLocale(locale);
				for (int j=0; j<numeroColumnas; j++) 
					datos[i][j] = entrada.nextDouble();				
			}
			br.close();
			//fr.close();
		}
		catch (IOException e) {
			System.out.println("Error de lectura");
		}
		return datos;
	}
	
	/**
	 * Returns the data of a column pass for parameter,
	 *  stored in a vector double.
	 * 
	 * @return all the lines of the culumn.
	 */
	public double [] getColumna (int columna) {
		double []datosColumna = new double [numeroLineas];
		for (int i=0; i<numeroLineas; i++)
			datosColumna[i] = datos[i][columna];
		return datosColumna;
	}
	
	/**
	 * Returns the data of a column pass for parameter,
	 *  stored in a vector double.
	 * 
	 * @return all the lines of the culumn.
	 */
	public double [] getColumna (String columna) {
		int posColumna = cabecera.indexOf(columna);
		return getColumna(posColumna);
	}
	
	/**
	 * Returns a List with the header.
	 * 
	 * @return header stored in a List.
	 */

	public List getCabecera () {
		return cabecera;
	}
	
	/**
	 * Returns the separator.
	 * 
	 * @return separador
	 */
	public String getSeparador () {
		return separador;
	}
	
	public Locale getLocale () {
		return locale;
	}
	
	/**
	 * Returns the number of lines.
	 * 
	 * @return number of lines.
	 */
	public int getNumeroLineas () {
		return numeroLineas;
	}
	
	/**
	 * Returns the number of columns.
	 * 
	 * @return number of columns.
	 */
	public int getNumeroColumnas () {
		return numeroColumnas;
	}
	
	/**
	 * Returns a matrix with the data.
	 * 
	 * @return datos.
	 */
	public double[][] getDatos(){
		return datos;
	}
	
	/**
	 * Returns the archive of text.
	 * 
	 * @return archive of text.
	 */
	public File getArchivoTexto(){
		return archivoTexto;
	}
	
	/**
	 * Method public exportar, exports all the dates of the CojuntoDatos whose
	 * header agree with the header pass by parameter. These dates
	 * are stored in in the route delimited
	 * by separator.
	 */

	public void exportar(String[] cabecera, String archivoTexto, 
			String separador){
		try {
			PrintWriter pw = new PrintWriter (new FileWriter
									(archivoTexto));
			//crear la cadena de la cabecera
			String cadena = "";
			for (int i=0; i<cabecera.length; i++) {
				cadena = cadena + cabecera[i];
				if (i < cabecera.length-1)
					cadena = cadena + separador;
			}
			pw.println(cadena);
			//ahora meto el resto de lineas con datos
			for (int i=0; i<numeroLineas; i++) {
				cadena = "";
				for (int j=0; j<cabecera.length; j++) {
					double []datosColumna = getColumna (cabecera[j]);
					cadena = cadena + datosColumna[i];
					if (j < cabecera.length-1)
						cadena = cadena + separador;
				}
				pw.println(cadena);
			}
			pw.close();
		}
		catch (IOException e) {
			System.out.println("Error de escritura");
		}
	}
	/**
	 * Method public, call the exportar method with the header 
	 * pass by parameter, the separator and the locale, and then instance and
	 * returns a new ConjuntoDatos from then archivoTexto created by
	 * exportar.
	 * 
	 * @return returns conjuntoDatos with the dates pass for parameter.
	 */
	public ConjuntoDatos conjuntoDatos(String[] cabecera, String archivoTexto, String separador, Locale locale){
		exportar (cabecera, archivoTexto, separador);
		File f = new File(archivoTexto);
		return new ConjuntoDatos(f, separador, locale);
	}
}
