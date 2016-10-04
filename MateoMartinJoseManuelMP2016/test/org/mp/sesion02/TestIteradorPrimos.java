package org.mp.sesion02;

import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;


public class TestIteradorPrimos {
	private Iterator<Integer> iteradorPrimos;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPropiedades() {

		iteradorPrimos = new IteradorPrimos(10);
		assertEquals(10, ((IteradorPrimos) iteradorPrimos).getLimite());
		assertEquals(1, ((IteradorPrimos) iteradorPrimos).getActual());
	}


	@Test
	public void testNext() {

		iteradorPrimos = new IteradorPrimos(10);
		Integer actual = iteradorPrimos.next();
		assertEquals(new Integer(1),actual);
		assertNotEquals(new Integer(2), iteradorPrimos.next());

	}

	@Test (timeout = 60) //limita la ejecución a 60 milisegundos
	public void testEsPrimo() {
		assertEquals(true,IteradorPrimos.esPrimo(2));
		assertEquals(true,IteradorPrimos.esPrimo(5));
		assertEquals(false,IteradorPrimos.esPrimo(9));
		assertEquals(false,IteradorPrimos.esPrimo(4));

	}

	@Test
	public void testHasNext() {
		iteradorPrimos = new IteradorPrimos(10);
		assertEquals(true,iteradorPrimos.hasNext());
		assertEquals(true,iteradorPrimos.hasNext());
		assertEquals(true,iteradorPrimos.hasNext());
		assertEquals(true,iteradorPrimos.hasNext());
		assertEquals(false,iteradorPrimos.hasNext());
	}

	@Test
	public void testRemove() {
		iteradorPrimos = new IteradorPrimos(10);

		try {
			iteradorPrimos.remove();
			fail("Debería haber lanzado una excepción");
		} catch (UnsupportedOperationException e) {
			assertEquals(e.getMessage(), "Método no soportado");

		}

	}

	@Test (timeout = 60) //limita la ejecución a 60 milisegundos
	public void testmostrarPrimos() {
		String cadenaGenerada, cadena;

		iteradorPrimos = new IteradorPrimos(1);
		cadenaGenerada = ((IteradorPrimos) iteradorPrimos).mostrarPrimos();
		cadena = "";
		assertEquals(cadenaGenerada, cadena);

		iteradorPrimos = new IteradorPrimos(20);
		cadenaGenerada = ((IteradorPrimos) iteradorPrimos).mostrarPrimos();
		cadena = "\t" + 2 + "\t" + 3 + "\t" + 5 + "\t" + 7 + "\t" + +11 + "\t"
				+ 13 + "\t" + 17 + "\t" + 19;
		assertEquals(cadenaGenerada, cadena);

		iteradorPrimos = new IteradorPrimos(70);
		cadenaGenerada = ((IteradorPrimos) iteradorPrimos).mostrarPrimos();
		cadena = "\t" + 2 + "\t" + 3 + "\t" + 5 + "\t" + 7 + "\t" + 11 + "\t"
				+ 13 + "\t" + 17 + "\t" + 19 + "\t" + 23 + "\t" + 29 + "\n"
				+ "\t" + 31 + "\t" + 37 + "\t" + 41 + "\t" + 43 + "\t" + 47
				+ "\t" + 53 + "\t" + 59 + "\t" + 61 + "\t" + 67;
		assertEquals(cadenaGenerada, cadena);

	}

}
