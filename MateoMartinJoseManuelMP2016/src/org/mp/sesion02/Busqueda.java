package org.mp.sesion02;

import java.util.Arrays;

public class Busqueda {

	/**
	 * Metodo Busqueda Binaria que va dividiendo el array y busca el elemento clave o por el subarray derecho
	 * o por el subarray izquierdo.
	 * @param array
	 * @param clave
	 * @return
	 * @throws ExcepcionArrayVacio en caso de arrray vacio
	 */
	public static <E extends Comparable<E>> int busquedaBinaria(E[] array, E clave)
			throws ExcepcionArrayVacio {
		if (array.length == 0)
			throw new ExcepcionArrayVacio("Array vacio");

		int primero = 0;
		int ultimo = array.length - 1;
		int central;
		if (clave.compareTo(array[0]) < 0
				|| clave.compareTo(array[ultimo]) > 0)
			return -1;
		else {
			while (ultimo >= primero) {
				central = (primero + ultimo) / 2;
				if (clave.compareTo(array[central]) < 0)
					ultimo = central - 1;
				else if (clave.compareTo(array[central]) > 0)
					primero = central + 1;
				else
					return central;

			}
			return -1;
		}
	}
}
