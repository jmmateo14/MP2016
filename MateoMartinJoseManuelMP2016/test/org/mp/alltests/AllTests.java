package org.mp.alltests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import  org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

	org.mp.sesion01.TestBaraja.class,
	org.mp.sesion01.TestMayor.class,

	org.mp.sesion02.TestBusqueda.class,
	org.mp.sesion02.TestEstudianteEmpleado.class,
	org.mp.sesion02.TestIteradorPrimos.class,
	org.mp.sesion02.TestOctogono.class,


	org.mp.sesion03.TestArrayList1.class,
	org.mp.sesion03.TestLinkedList1.class,

	org.mp.sesion04.TestEvaluador.class,
	org.mp.sesion04.TestPilaPrimos.class,
	org.mp.sesion04.TestSortedLinkedList.class,

	org.mp.sesion05.OrdenacionTestA.class,
	org.mp.sesion05.SolucionesBusquedaTestA.class,
	org.mp.sesion05.BarajaTestA.class,
	org.mp.sesion05.BarajaTestB.class,
	org.mp.sesion05.AccionesTestA.class,

	org.mp.sesion06.UtilidadArchivosTestA.class,
	org.mp.sesion06.ConjuntoDatosTestA.class,
	org.mp.sesion06.EstadisticaTestA.class,

	org.mp.sesion07.ImagenTestA.class,
	org.mp.sesion07.ResidenciaTestA.class,
	org.mp.sesion07.ResidenciaTestB.class,
	org.mp.sesion07.ResidenciaTestSER.class,
	org.mp.sesion07.ResidenciaTestXML.class,

	org.mp.sesion08.Sesion08TestA.class,
	org.mp.sesion09.Sesion09TestA.class,


})

public class AllTests {

}
