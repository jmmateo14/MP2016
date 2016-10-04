package org.mp.sesion04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mp.sesion04.GenericStack;

public class TestPilaPrimos {

	private PilaPrimos pilaPrimos = new PilaPrimos(1);
	private PilaPrimos pilaPrimos1 = new PilaPrimos(19);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetLimite() {

		assertEquals(1,pilaPrimos.getLimite());
		assertEquals(19,pilaPrimos1.getLimite());
	}

	@Test
	public void testEsPrimo() {

		assertFalse(PilaPrimos.esPrimo(4));
		assertFalse(PilaPrimos.esPrimo(9));
		assertFalse(PilaPrimos.esPrimo(25));

		assertTrue(PilaPrimos.esPrimo(2));
		assertTrue(PilaPrimos.esPrimo(3));
		assertTrue(PilaPrimos.esPrimo(13));

	}

	@Test
	public void testObtenerPilaPrimos() {

		GenericStack<Integer> pilaObtenida  = pilaPrimos.obtenerPilaPrimos();
		GenericStack<Integer> pilaObtenida1 = pilaPrimos1.obtenerPilaPrimos();


		int [] array = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67};

		//Construimos las pilas para compararlas con las que se deben obtener

		GenericStack<Integer> pilaCalculada = new GenericStack<>();
		GenericStack<Integer> pilaCalculada1 = new GenericStack<>();

		pilaCalculada.push(2); // esta pila contiene  un solo primo, por tanto 2
		for (int i = 0; i < 19; i++) {
			pilaCalculada1.push(array[i]); // esta pila contiene los primos del array
		}

		assertEquals(pilaCalculada.toString(), pilaObtenida.toString());
		assertEquals(pilaCalculada1.toString(), pilaObtenida1.toString());


	}


	@Test
	public void testMostrarPrimos() {

		String actual =pilaPrimos.mostrarPrimos(pilaPrimos.obtenerPilaPrimos());
		String actual1 =pilaPrimos1.mostrarPrimos(pilaPrimos1.obtenerPilaPrimos());

		String esperada = "\t" + 2;
		String esperada1 = "\t" + 67 + "\t" + 61 + "\t" + 59 + "\t" + 53 + "\t" + 47 + "\t"
				+ 43 + "\t" + 41 + "\t" + 37 + "\t" + 31 + "\t" + 29 + "\n"
				+ "\t" + 23 + "\t" + 19 + "\t" + 17 + "\t" + 13 + "\t" + 11
				+ "\t" + 7 + "\t" + 5 + "\t" + 3 + "\t" + 2;

		assertEquals(esperada, actual);
		assertEquals(esperada1, actual1);


	}



}
