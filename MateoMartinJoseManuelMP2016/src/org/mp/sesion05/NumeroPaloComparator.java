package org.mp.sesion05;

import java.util.Comparator;

public class NumeroPaloComparator implements Comparator {

	/**
	 * Public method that compare two object of type Carta
	 * 
	 * @param o1 First card to compare
	 * @param o2 Second card to compare
	 * @return Returns -1 or 1 in case of that carta1 is lower or higher that
	 *         carta2. No retunrs 0 inasmuch as in a baraja there should be two
	 *         card of the same number and suit.
	 */
	@Override
	public int compare(Object o1, Object o2) {
		Carta c1 = (Carta) o1;
		Carta c2 = (Carta) o2; 
		if (c1.getNumero() < c2.getNumero())
			return -1;
		if (c1.getNumero() > c2.getNumero())
			return 1;
		//coinciden los numeros, me fijo en el valor (palo)
		if (c1.getValor() < c2.getValor())
			return -1;
		if (c1.getValor() > c2.getValor())
			return 1;
		return 0;
	}

}
