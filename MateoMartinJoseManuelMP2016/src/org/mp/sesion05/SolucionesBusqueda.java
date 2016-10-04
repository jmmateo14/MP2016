package org.mp.sesion05;

public class SolucionesBusqueda {

	/**
	 * Static method that implements an algorithm of linear search. It called an elements
	 * Busqueda as a parameter. Returns the number sought in
	 * case of finding the number or the exception in case contrary.
	 * @return the number searched.
	 * @throws ElementoNoEncontradoException
	 *             Number not found
	 */
	public static int busquedaLineal(Busqueda busqueda) 
				throws ElementoNoEncontradoException {
		for (int i=0; i<busqueda.getNumElementos(); i++) {
			if (busqueda.getDatos()[i] == busqueda.getNumBuscado())
				return i;
		}
		throw new ElementoNoEncontradoException("No encontrado");
	}

	/**
	 * Static method that implements an algorithm of iterative binary search.
	 * It invoked with an element Busqueda as a parameter. Returns the
	 * number searched in case of finding the number or the exception in case contrary.
	 * @return the number searched.
	 * @throws ElementoNoEncontradoException
	 *             Number not found
	 */
	public static int busquedaBinariaIter(Busqueda busqueda) 
				throws ElementoNoEncontradoException {
		int ini = 0;
		int fin = busqueda.getNumElementos() - 1;
		while (ini <= fin) {
			int med = (ini + fin) / 2;
			if (busqueda.getDatos()[med] == busqueda.getNumBuscado())
				return med;
			else {
				if (busqueda.getDatos()[med] > busqueda.getNumBuscado())
					fin = med - 1;
				else
					ini = med + 1;
			}
		}
		throw new ElementoNoEncontradoException("No encontrado");
	}

	/**
	 * Static method that implements an algorithm of recursive binary search.
	 * It invoked with an element Busqueda as a parameter. Returns the
	 * number searched in case of finding the number or the exception in case contrary.
	 * @return The number searched.
	 * @throws ElementoNoEncontradoException
	 *             Number not found
	 */
	public static int busquedaBinariaRec(Busqueda busqueda) 
				throws ElementoNoEncontradoException {
		return busquedaBinariaRec (busqueda.getDatos(), 
				busqueda.getNumBuscado(), 0, 
				busqueda.getNumElementos() - 1);
	}

	/**
	 * Private static method that is called by the method busquedaBinariaRec.
	 * Performs recursive binary search
	 * @return Returns the elements searched in case of finding
	 * @throws ElementoNoEncontradoException
	 *             In case of not found the element searched, returns
	 *             exception "No encontrado"
	 */
	private static int busquedaBinariaRec(int[] datos, 
			int numBuscado, int ini, int fin) 
			throws ElementoNoEncontradoException {
		if (ini > fin)
			throw new ElementoNoEncontradoException("No encontrado");
		int med = (ini + fin) / 2;
		if (datos[med] == numBuscado)
			return med;
		else {
			if (datos[med] < numBuscado)
				return busquedaBinariaRec (datos, numBuscado, med+1, fin);
			else
				return busquedaBinariaRec (datos, numBuscado, ini, med-1);
		}
	}
	
	

}
