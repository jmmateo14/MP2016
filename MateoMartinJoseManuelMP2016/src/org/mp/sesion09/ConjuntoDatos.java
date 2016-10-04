package org.mp.sesion09;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
	
	public ConjuntoDatos (File archivoTexto, String separador, 
						Locale locale) throws Exception {
		this.archivoTexto = archivoTexto;
		this.separador = separador;
		this.locale = locale;
		cabecera = cabecera (archivoTexto);
		numeroLineas = numLineas (archivoTexto);
		numeroColumnas = numColumnas (archivoTexto);
		datos = leerDatos (archivoTexto, numeroLineas, numeroColumnas);
	}
	
	private List cabecera (File archivoTexto) throws Exception {
		cabecera = new ArrayList();
		Scanner f = new Scanner (archivoTexto);
		//leo la primera linea
		String cadena = f.nextLine();
		//la divido en trozos, metiendo cada trozo en la lista
		Scanner sc = new Scanner (cadena);
		sc.useDelimiter(separador);
		while (sc.hasNext()) {
			String trozo = sc.next();
			cabecera.add(trozo);
		}
		return cabecera;
	}
	
	private int numLineas (File archivoTexto) throws Exception {
		Scanner f = new Scanner (archivoTexto);
		//cuento todas las lineas del fichero
		int cont = 0;
		while (f.hasNextLine()) {
			f.nextLine();
			cont++;
		}
		//pero como la primera linea es la de cabecera, le resto 1
		return cont-1;
	}
	
	private int numColumnas (File archivoTexto) {
		//tengo tantas columnas como elementos tengo en la cabecera
		return cabecera.size();
	}
	
	private double [][]leerDatos (File archivoTexto, int filas,
						int columnas) throws Exception {
		Scanner f = new Scanner (archivoTexto);
		datos = new double [numeroLineas][numeroColumnas];
		//salto la primera linea
		f.nextLine();
		//leo las demas lineas
		for (int i=0; i<numeroLineas; i++) {
			String cadena = f.nextLine();
			//dividiendolas en trozos 
			Scanner sc = new Scanner (cadena);
			sc.useDelimiter(separador);
			sc.useLocale(locale);
			for (int j=0; j<numeroColumnas; j++) {
				//y guardando cada trozo en la tabla 
				datos[i][j] = sc.nextDouble();
			}
		}
		return datos;
	}
	
	public double []getColumna (int columna) {
		double []v = new double [numeroLineas];
		for (int i=0; i<numeroLineas; i++)
			v[i] = datos[i][columna];
		return v;
	}
	
	public double []getColumna (String columna) {
		int col = cabecera.indexOf(columna);
		return getColumna (col);
	}
	
	public List getCabecera () {
		return cabecera;
	}
	
	public String getSeparador () {
		return separador;
	}
	
	public Locale getLocale () {
		return locale;
	}
	
	public int getNumeroLineas () {
		return numeroLineas;
	}
	
	public int getNumeroColumnas () {
		return numeroColumnas;
	}
	
	public double [][] getDatos () {
		return datos;
	}
	
	public File getArchivoTexto () {
		return archivoTexto;
	}
	
	public void exportar (String []cabecera, String archivoTexto,
					String separador) throws Exception {
		//en primer lugar me creo la tabla con las columnas
		//indicadas en este vector cabecera
		double [][]dat = new double [numeroLineas][cabecera.length];
		for (int j=0; j<cabecera.length; j++) {
			double []v = getColumna (cabecera[j]);
			for (int i=0; i<numeroLineas; i++) {
				dat[i][j] = v[i];
			}
		}
		PrintWriter fichero = new PrintWriter (new BufferedWriter
					(new FileWriter (archivoTexto)));
		//escribo en el fichero la linea de cabecera
		for (int i=0; i<cabecera.length; i++) {
			fichero.write(cabecera[i]);
			if (i < cabecera.length-1)
				fichero.write(separador);
		}
		fichero.println();
		//ahora escribo todos los datos
		for (int i=0; i<numeroLineas; i++) {
			for (int j=0; j<cabecera.length; j++) {
				fichero.print(dat[i][j]);
				if (j < cabecera.length - 1)
					fichero.write(separador);
			}
			fichero.println();
		}
		fichero.close();
	}
	
	public ConjuntoDatos conjuntoDatos (String []cabecera,
					String archivoTexto, String separador,
					Locale locale) throws Exception {
		exportar (cabecera, archivoTexto, separador);
		File f = new File (archivoTexto);
		ConjuntoDatos nuevo = new ConjuntoDatos (f, separador, locale);
		return nuevo;
	}
}
