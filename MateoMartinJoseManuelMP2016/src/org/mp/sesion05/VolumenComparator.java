package org.mp.sesion05;

import java.util.Comparator;

public class VolumenComparator implements Comparator {

	/**
	 * Compare two actions past for parameter.
	 * 
	 * @return -1, 1 or 0 in case of that the first accion past for parameter
	 *         is lower, higher or equal that the second.
	 */
	@Override
	public int compare(Object o1, Object o2) {
		Accion a1, a2;
		
		a1 = (Accion) o1;
		a2 = (Accion) o2;
		if (a1.getVolumen() < a2.getVolumen())
			return -1;
		if (a1.getVolumen() > a2.getVolumen())
			return 1;
		//Cuando coincide el volumen comparo por nombre.
		if(a1.getNombre().compareTo(a2.getNombre()) < 0)
			return -1;
		if(a1.getNombre().compareTo(a2.getNombre()) > 0)
			return 1;
		return 0;
	}
	

}
