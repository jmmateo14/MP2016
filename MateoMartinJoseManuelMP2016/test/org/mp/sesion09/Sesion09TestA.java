package org.mp.sesion09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Sesion09TestA {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAnalisisDatos() {
		String[] args = null;
		AnalisisDatos.main(args);

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*
	@Test
	public void testResidencia() {
		String[] args = null;
		Residencia.main(args);

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/

}
