package org.mp.sesion07;

public class ResidenciaDAOFactory {
	
	protected String nombreArchivo;

	/**
	 * Static method that returns a object type ResidenciaSER or ResidenciaXML.
	 * 
	 * @param nombreArchivo
	 * 				name and file path where they are stored data of the
	 * 				residence to reconstruct.
	 * @param tipo
	 * 				type of reconstruct that himself will be do, Serializable or XML.
	 * @return instance ResidenciaSER or ResidenciaXML ready to
	 *         reconstruct or save residences in archive.

	 */
	public static DataAccessObject createResidenciaDAOFactory (String nombreArchivo, String tipo) {
		
		DataAccessObject dao = null;
		if (tipo.equals("ser")){
			dao = new ResidenciaSER(nombreArchivo);
		}
 
		if (tipo.equals("xml")){
			dao = new ResidenciaXML(nombreArchivo);
		}
		return dao;
	}

	/**
	 * Method getter of the name of the file.
	 * 
	 * @return name od the archive.
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * Method setter of the name of the file.
	 * 
	 * @param nombreArchivo
	 *            name of the file.
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
}

