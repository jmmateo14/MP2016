package org.mp.sesion06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class UtilidadArchivos {
	private ArrayList lista;

	public UtilidadArchivos(){
	lista = new ArrayList();

}

	/**
	 * Static method copiar. Copy the archive origin to the specified destination.
	 *
	 * @param origen
	 *            Origin archive to copy
	 * @param destino
	 *            Route where stored the copy of the archive.
	 * @throws IOException
	 *            Origin archive not found.
	 */
	public static void copiar (File origen, File destino)
	throws IOException {
		//Flujo de entrada y salida
		    InputStream in = new FileInputStream(origen);
		    OutputStream out = new FileOutputStream(destino);

		    // read lee los bytes de buf que como mucho son 1024 y debuelve los bytes leidos
		    //write escribe los bytes de buf empezando en 0 y acabando antes de len, es decir, en len-1
		    byte[] buf = new byte[1024];
		    int len;
		    while ((len = in.read(buf)) > 0) {
		        out.write(buf, 0, len);
		    }
		    in.close();
		    out.close();
		}

	/**
	 * Method listarDirectoriosArchivos. You get the archives/directories of a
	 * address or route by the private method DirectoriosArchivosRec
	 *
	 * @param dir
	 *            File con la direccion para listar sus archivos/directorios
	 * @return All the archive/directories of dir
	 */
	public ArrayList listarDirectoriosArchivos(File dir){
		lista.clear();
		listarDirectoriosArchivosRec(dir);
		return lista;
	}

	/**
	 * Private method that adds a archive/directory to the list, being
	 * directory, the method is implement to add all the element of
	 * already directory of way recurrent.
	 *
	 * @param dir
	 *            File with the direction to list your archives/directories.
	 */
	private void listarDirectoriosArchivosRec(File dir){
		String[] children = dir.list();
		if (children == null) {
		    // Either dir does not exist or is not a directory
		} else {
			String dirActual = dir.getAbsolutePath();

		    for (int i=0; i<children.length; i++) {
		        // Get filename of file or directory
		        String filename = dirActual + File.separator + children[i];
		        File file = new File (filename);
		        lista.add(file);
		        if(file.isDirectory())
		        listarDirectoriosArchivosRec(file);
		    }
		}

	}

	/**
	 * Method to compress a archive, specifying the name of the archive to
	 * compress, the way out and the final name of the archive compressed.
	 *
	 * @param dir
	 *            File or directory to compress.
	 * @param caminoSalida
	 *            Exit route where save the archive compressed.
	 * @param nombreArchivo
	 *            Name of the archive compressed
	 */
	public void zip (File dir, String caminoSalida, String nombreArchivo){
		listarDirectoriosArchivos(dir);
		String outFilename = caminoSalida + File.separator + nombreArchivo;
		try {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFilename));

	    // Compress the files

	    for (int i = 0; i < lista.size(); i++) {

	    	File file = (File) lista.get(i);
	        FileInputStream in = new FileInputStream(file);

	        // Add ZIP entry to output stream.
	        out.putNextEntry(new ZipEntry(file.getName()));

	        // Transfer bytes from the file to the ZIP file
	        byte[] buf = new byte[1024];
	        int len;
	        while ((len = in.read(buf)) > 0) {
	            out.write(buf, 0, len);
	        }

	        // Complete the entry
	        out.closeEntry();
	        in.close();
	    }

	    // Complete the ZIP file
	    out.close();
	}
		catch (IOException e){

	}
}


}
