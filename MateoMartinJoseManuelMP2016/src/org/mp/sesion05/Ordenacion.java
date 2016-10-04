package org.mp.sesion05;

import java.util.Arrays;

public class Ordenacion {

	/**
	 * Static method that perform a ordination by insertion. For that calls
	 * the private method ordenacionPorInsercion.
	 */
	public static void ordenacionPorInsercion(Comparable[] a) {
		ordenacionPorInsercion (a, 0, a.length - 1);
	}
	
	
	/**
	 * Private static method that actually performs the ordination by
	 * insertion.
	 */
	private static void ordenacionPorInsercion (Comparable []a,
				int izq, int der) {
		if (izq != der) {
			ordenacionPorInsercion (a, izq, der - 1);
			Comparable aux = a[der];
			int j = der - 1;
			while (j >= 0 && a[j].compareTo(aux) > 0) {
				a[j+1] = a[j]; 
				j--;
			}
			a[j + 1] = aux;
		}
	}

	/**
	 * Method of ordination mergeSort.
	 */
	public static void mergeSort(Comparable[] a) {
		Comparable []vectorTemp = new Comparable[a.length];
		mergeSort(a, vectorTemp, 0, a.length-1);
	}
	

	/**
	 * Private recursive method mergeSort. Divided the set of data in
	 * smaller subset.
	 */
	private static void mergeSort (Comparable []a, Comparable []vectorTemp,
					int izq, int der) {
		if (izq < der) {
			int med = (izq + der) / 2;
			mergeSort (a, vectorTemp, izq, med);
			mergeSort (a, vectorTemp, med + 1, der);
			mezclar (a, vectorTemp, izq, med + 1, der);
		}
	}
	

	/**
	 * Private method that blend of way ordered the
	 * subset that generate the previous method, obtaining one array
	 * ordered
	 */
	private static void mezclar (Comparable []a, Comparable []vectorTemp,
					int posIzq, int posDer, int posFin) {
		int i, j, k;
		
		i = posIzq; //para moverme por la parte izquierda
		j = posDer; //para moverme por la parte derecha
		k = posIzq; //para moverme por el vector de la mezcla
		while (i < posDer && j <= posFin) {
			if (a[i].compareTo(a[j]) < 0) {
				vectorTemp[k] = a[i];
				i++;
				k++;
			}
			else {
				vectorTemp[k] = a[j];
				j++;
				k++;
			}
		}
		//si acaba antes la parte derecha, me queda por meter
		//el resto de la parte izquierda
		while (i < posDer) {
			vectorTemp[k] = a[i];
			i++;
			k++;
		}
		//si acaba antes la parte izquierda, me queda por meter
		//el resto de la parte derecha
		while (j <= posFin) {
			vectorTemp[k] = a[j];
			j++;
			k++;
		}
		//como la mezcla esta en el vectorTemp, ahora lo meto en 
		//las mismas posiciones machacando en el vector a
		for (k = posIzq; k <= posFin; k++) {
			a[k] = vectorTemp[k];
		}
	}

	/**
	 * sorting method by Arrays.sort.
	 */
	public static void sort(Comparable[] a) {
		Arrays.sort(a);
	}

}
