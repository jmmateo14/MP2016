package org.mp.sesion07;

import java.io.IOException;

public interface DataAccessObject {

	/**
	 * Write object in disk.
	 * @param object object to write in disk.
	 * @throws IOException
	 */
	public void escribir (Object object) throws IOException;
	
	/**
	 * Read a object in disk and returns.
	 * @return object read in disk.
	 * @throws IOException
	 */
	public Object leer () throws IOException;
		

}
