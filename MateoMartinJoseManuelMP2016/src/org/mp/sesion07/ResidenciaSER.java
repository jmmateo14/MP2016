package org.mp.sesion07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ResidenciaSER extends ResidenciaDAOFactory 
						implements DataAccessObject {

	/**
	 * Instance a new ResidenciaSER.
	 * 
	 * @param nombreArchivo
	 * 				name of the file where himself will save 
	 * 				or will read a residence.
	 */
	public ResidenciaSER (String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	/**
	 * Serializes the object passed as a parameter to a file in disk
	 */
	@Override
	public void escribir(Object residencia) throws IOException {
		/*File f = new File (nombreArchivo);
		FileOutputStream fos = new FileOutputStream (f);
		ObjectOutputStream oos = new ObjectOutputStream (fos);*/
		ObjectOutputStream oos = new ObjectOutputStream 
				(new FileOutputStream(new File (nombreArchivo)));
		oos.writeObject(residencia);
		oos.close();
	}

	/**
	 * Reads a residence of the archive,reconstructs the archive and returns.
	 */
	@Override
	public Object leer() throws IOException {
		ObjectInputStream ois = new ObjectInputStream 
				(new FileInputStream(new File (nombreArchivo)));
		Object object = null;
		try {
			object = ois.readObject();
		}
		catch (ClassNotFoundException e) {
		}
		ois.close();
		return object;
	}
	
}

