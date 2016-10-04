package org.mp.sesion07;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ResidenciaXML extends ResidenciaDAOFactory 
						implements DataAccessObject {

	private XStream xstream;
	
	/**
	 * Instance a ResidenciaXML.
	 * 
	 * @param nombreArchivo
	 * 				name of the file through the which himself will read/write
	 * 				a residence.
	 */
	public ResidenciaXML (String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
		xstream = new XStream (new DomDriver());
		xstream.alias("residencia", Residencia.class);
		xstream.alias("habitacion", Habitacion.class);
		xstream.alias("residente", Residente.class);
		xstream.alias("reserva", Reserva.class);
	}
	
	/**
	 * Writes the object passed as a parameter to a file XML in disk.
	 * 
	 * @param object
	 *            object to write in disk in file XML.
	 */
	@Override
	public void escribir(Object object) throws IOException {
		Residencia residencia = (Residencia) object;
		String cadena = xstream.toXML(object);
		System.out.println(cadena);
		PrintWriter pw = new PrintWriter (new FileWriter (nombreArchivo));
		pw.write(cadena);
		pw.close();
	}

	/**
	 * Reads all the archive, saves the archive in a string, reconstructs and returns.
	 * 
	 * @return residence reconstructed as of file XML.
	 */
	@Override
	public Object leer() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader (nombreArchivo));		
		String cadenaXml = "";
		String linea = f.readLine();
		while(linea != null){
			cadenaXml = cadenaXml + linea;
			linea = f.readLine();
		}
		Residencia residencia = (Residencia) xstream.fromXML(cadenaXml);
		f.close();
		return residencia;
	}

}
