package org.mp.sesion04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEvaluador {

	private String mensaje;
	private Evaluador evaluador;


	@Before
	public void setUp() throws Exception {
		evaluador = new Evaluador();

	}

	@Test
	public void testParser() {
		String expresion= "  22 + 2 ";

		String[] array = evaluador.parser(expresion);

		String salida="";

		for (int i = 0; i < array.length; i++) {
			 salida += array[i];
		}
		mensaje = "Debe quitar los blancos";
		assertEquals(mensaje, "22+2", salida);

		expresion = salida;

		array = evaluador.parser(expresion);

		salida="";

		for (int i = 0; i < array.length; i++) {
			 salida += array[i];
		}
		mensaje = "Debe obtener la misma cadena";
		assertEquals(mensaje, expresion, salida);

		array = evaluador.parser("7   8 9  4");
		salida="";

		for (int i = 0; i < array.length; i++) {
			 salida += array[i];
		}
		assertEquals("7894",salida );


	}

	@Test
	public void testPostfija() throws EmptyStackException {
		String[] expresion1 = {"3","2","+"};

		mensaje = "Resultado debe ser 5";
		assertEquals(mensaje,5, evaluador.postfija(expresion1));

		String[] expresion2 = {"3","3","+","2","/"};

		mensaje = "Resultado debe ser 3";
		assertEquals(mensaje,3, evaluador.postfija(expresion2));

	}
	@Test
	public void testEvaluar() throws Exception {
		assertEquals("7865",evaluador.evaluar("7865"));
		assertEquals("7865",evaluador.evaluar("7 8 6 5"));
		assertEquals("9",evaluador.evaluar("9"));
		assertEquals("13",evaluador.evaluar("10  3  +"));
		assertEquals("7",evaluador.evaluar("10  3  -"));
		assertEquals("30",evaluador.evaluar("10  3  *"));
		assertEquals("Resultado debe ser 3, es división entera","3",evaluador.evaluar("10  3  /"));
		assertEquals("No es posible una división por cero",evaluador.evaluar("10  0  /"));
		assertEquals("14",evaluador.evaluar("5  1 2+ 4*+  3-"));
	


	}





}
