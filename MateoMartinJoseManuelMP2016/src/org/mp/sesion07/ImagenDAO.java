package org.mp.sesion07;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ImagenDAO {

	
	/**
	 * Writes a text file header with the data necessary to image 
	 * processing and call the private method escribirBSQ() to write
	 * the image in disk.
	 * @param nombreArchivo
	 * 				name of file header.
	 * @param imagen
	 * 				image to write in disk.
	 * @throws IOException
	 */
	public static void escribirArchivo (String nombreArchivo, 
				Imagen imagen) throws IOException {
		
		File file = new File (nombreArchivo);
		PrintWriter f = new PrintWriter (new FileWriter(file));
		String nombre = file.getName();
		nombre = nombre.replace(".cabecera", ".dat");
		f.write(nombre + "\r\n");
		f.write(imagen.getFormatoImagen() + "\r\n");
		f.write(imagen.getNumeroBandas() + "\r\n");
		String cadena = "[";
		for(int i = 0; i < imagen.getNumeroBandas(); i++){
			cadena = cadena + imagen.getBanda(i).getNombreBanda();
			if (i < imagen.getNumeroBandas() - 1)
				cadena = cadena + ";";
			else
				cadena = cadena +"]";
		}
		f.write(cadena + "\r\n");
		f.write(imagen.getLineas() + "\r\n");
		f.write(imagen.getColumnas() + "\r\n");
		f.close();
		nombre = file.getParent() + File.separator + nombre;
		escribirBSQ(nombre, imagen);
	}
	
	/**
	 * Private method escribirBSQ, the method write the image in disk in
	 * format binary.
	 * 
	 * @param nombreArchivo
	 *            name and file path where himself will write the image.
	 * @param imagen
	 *            image to write in disk.
	 */
	private static void escribirBSQ (String nombreArchivo, 
				Imagen imagen) throws IOException {
		
		DataOutputStream f = new DataOutputStream 
				(new FileOutputStream (new File (nombreArchivo)));
		for (int i=0; i < imagen.getNumeroBandas(); i++) {
			for (int y=0; y<imagen.getLineas(); y++) {
				for (int x=0; x<imagen.getColumnas(); x++) {
					f.writeInt(imagen.getBanda(i).getDatos()[y][x]);
				}
			}
		}
		f.close();
	}
	
	/**
	 * Reads the file header to get the data and call the private method
	 * leerBSQ() to read the image as of a binary file.
	 * 
	 * @param nombreArchivo
	 *           name of the text file header to read.
	 * @return Image read of the archive.
	 * @throws IOException
	 */
	public static Imagen leerArchivo (String nombreArchivo) 
				throws IOException {
		File file = new File (nombreArchivo);
		BufferedReader f = new BufferedReader (new FileReader
				(file));
		String nombreDatos = f.readLine();
		String formatoImagen = f.readLine();
		int numeroBandas = Integer.parseInt(f.readLine());
		String cadenaBandas = f.readLine();
		cadenaBandas = cadenaBandas.substring(1, cadenaBandas.length()-1);
		String []nbandas = new String [numeroBandas];
		Scanner sc = new Scanner (cadenaBandas);
		sc.useDelimiter(";");
		for (int i=0; i<numeroBandas; i++)
			nbandas[i] = sc.next();
		int lineas = Integer.parseInt(f.readLine());
		int columnas = Integer.parseInt(f.readLine());
		f.close();
		Imagen imagen = new Imagen (lineas, columnas, formatoImagen);
		nombreDatos = file.getParent() + File.separator + nombreDatos;
		imagen = leerBSQ (nombreDatos, imagen, nbandas);
		return imagen;
	}
	
	/**
	 * Private method that reads the image as of a binary file
	 * and returns the image.
	 * 
	 * @param nombreArchivo
	 * 				name of the binary file to read.
	 * @param imagen
	 * 				instantiated image with the number of lines, columns y format
	 * 				of the image to read.
	 * @param nBandas
	 * 				name of the bandas of the image to read.
	 * @return image with all the data and bandas read of file.
	 * @throws IOException
	 */
	private static Imagen leerBSQ (String nombreArchivo, Imagen imagen,
				String []nBandas) throws IOException {
		DataInputStream f = new DataInputStream 
				(new FileInputStream (new File (nombreArchivo)));
		for (int i=0; i<nBandas.length; i++) {
			int [][]datos = new int [imagen.getColumnas()][imagen.getLineas()];
			for (int y=0; y<imagen.getLineas(); y++) {
				for (int x=0; x<imagen.getColumnas(); x++) {
					int dato = f.readInt();
					datos[y][x] = dato;
				}
			}
			BandaInt banda = new BandaInt (nBandas[i], datos);
			imagen.añadirBanda(banda);
		}
		f.close();
		return imagen;
	}
}
