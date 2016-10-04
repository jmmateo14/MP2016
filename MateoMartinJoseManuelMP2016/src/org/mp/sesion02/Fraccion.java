package org.mp.sesion02;



public class Fraccion<T> implements Comparable<Object> {

		private int numerador;
		private int denominador;

		public Fraccion() {
			numerador = 0;
			denominador = 1;
		}
//    CORREGIR
		/**
		 * Metodo constructor de la clase Fraccion.
		 * @param numerador
		 * @param denominador
		 */
		public Fraccion(int numerador, int denominador) {
			/*if ((numerador > 0 && denominador < 0) ||(numerador < 0 && denominador < 0 )){
			this.numerador = -numerador;
			this.denominador = -denominador;
			}
			else {
				this.numerador = numerador;
				this.denominador = denominador;
			}
			*/
			// Otra forma
			 this.numerador = ((denominador > 0 ) ? 1 : -1 ) * numerador;
			 this.denominador = Math.abs(denominador);

		}

		/**
		 * Metodo equals, con el que comparamos si dos fracciones son iguales, pero
		 * comparando sus numeradores y denominadores.
		 */
		@Override
		public boolean equals(Object obj) {

			if (!(obj instanceof Fraccion))
				return false;
			Fraccion otro = (Fraccion) obj;
			if (denominador != otro.denominador)
				return false;
			if (numerador != otro.numerador)
				return false;
			return true;
		}

		public int getNumerador() {
			return numerador;
		}



		public int getDenominador() {
			return denominador;
		}

		/**
		 * Metodo toString que devuelve una cadena
		 */
		@Override
		public String toString() {
			return numerador + "/" + denominador;
		}
	/* otro toString
	 * @Override
		public String toString() {
			if (den == 1)
				return num + "";
		    else
				return num + "/" + den;
		}
	 *
	 *
	 */
		/**
		 * Método de clase que permite sumar dos fracciones
		 * @param b
		 * @return
		 */
		public Fraccion sumar(Fraccion b){
			int num = numerador * b.getDenominador() + denominador * b.getNumerador();
			int den = denominador * b.getDenominador();
			return new Fraccion(num, den);

		}

	/*	public static Fraccion sumar(Fraccion a, Fraccion b) {
			Fraccion c = new Fraccion();
			c.num = a.num * b.den + b.num * a.den;
			c.den = a.den * b.den;
			return c;
		}
	*/
		/**
		 * Método de clase que permite sumar dos fracciones
		 * @param a
		 * @param b
		 * @return suma a + b
		 */
		public static Fraccion sumar(Fraccion a, Fraccion b) {
			int num = a.getNumerador() * b.getDenominador() + b.getNumerador() * a.getDenominador();
			int den = a.getDenominador() * b.getDenominador();
			return new Fraccion(num, den);
		}

		/**
		 * Método de clase que permite restar dos fracciones
		 * @param b
		 * @return
		 */
		public  Fraccion restar(Fraccion b) {
			int num = numerador * b.getDenominador() - denominador * b.getNumerador();
			int den = denominador * b.getDenominador();
			return new Fraccion(num, den);
		}

		/**
		 * Metodo de clase que permite multiplicar dos fracciones
		 * @param b
		 * @return
		 */
		public  Fraccion multiplicar( Fraccion b) {
			return new Fraccion(numerador * b.getNumerador(), denominador * b.getDenominador());
		}


		/**
		 * Metodo de clase que permite dividir dos fracciones
		 * @param b
		 * @return
		 */
		public  Fraccion dividir( Fraccion b) {
			return new Fraccion(numerador * b.getDenominador(), denominador *b.getNumerador());
		}

		/**
		 * Metodo Maximo Comun Divior
		 * @param u
		 * @param v
		 * @return
		 */
		private static int mcd(int u, int v) {
			u = Math.abs(u);
			v = Math.abs(v);
			if (v == 0) {
				return u;
			}
			int r;
			while (v != 0) {
				r = u % v;
				u = v;
				v = r;
			}
			return u;
		}


		/**
		 * Metodo con el que simplificamos una fraccion ej 25/25 = 1
		 * @return
		 */
		public Fraccion simplificar() {
			int dividir = mcd(numerador, denominador);
			numerador /= dividir;
			denominador /= dividir;
			return this;
		}

		/**
		 * Metodo compareTo, con el cual podemos comparar dos fracciones, por su solucion
		 * no por numerador y denominado, es decir, 3/2 tiene la misma solucion que 6/4
		 */
		public int compareTo(Object o){

			Fraccion otro = (Fraccion)o;

			double valorFraccion = (double)numerador / denominador;
			double valorOtro = (double)otro.getNumerador() / otro.getDenominador();

			if (valorFraccion > valorOtro)
			return 1;
			else if (valorFraccion < valorOtro)
				return -1;
			else
				return 0;

		}

		/* otro compareTo
		public int compareTo(Object o){
			Fraccion b = (Fraccion)o;
			if ((this.restar(b)).getNumerador() > 0)
			return 1;
			else if ((this.restar(b)).getNumerador() < 0)
				return -1;
			else
				return 0;

		}
		*/





	}


