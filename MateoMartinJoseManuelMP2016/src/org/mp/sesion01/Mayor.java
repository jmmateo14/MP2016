package org.mp.sesion01;

public class Mayor {


	/**
	 * Metodo estatico que nos indica cual es el elemento mayor de un array
	 * el cual le pasamos como parametro.
	 * Si el array está vacío devuelve una excepcion "Array vacío"
	 * @param a
	 * @return elemento mayor del array
	 */
	public static int elEnteroMayor(int[] a) {

		int max = Integer.MIN_VALUE;
		if(a.length == 0)
			throw new RuntimeException("Array vacio");


		for (int indice = 0; indice < a.length ; indice++) {
			if (a[indice] > max) {
				max = a[indice];
			}
		}
		return max;
	}

}

