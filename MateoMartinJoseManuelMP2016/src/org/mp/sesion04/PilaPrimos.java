package org.mp.sesion04;

public class PilaPrimos {
	private int limite;
	private GenericStack<Integer> pila;

	/**
	 * Constructor de la clase PilaPrimos
	 * @param limite
	 */
	public PilaPrimos(int limite) {
		this.limite = limite;
		pila = new GenericStack<Integer>();

	}

	public int getLimite() {
		return limite;
	}

	public GenericStack<Integer> obtenerPilaPrimos() {
		int n = 2;
		int cont = 0;
		while (cont < limite) {
			if (esPrimo(n)) {
				pila.push(n);
				cont++;
			}
			n++;
		}
		return pila;
	}

	/**
	 * Metodo que muestra los numeros primos
	 * @param pilaPrimos
	 * @return
	 */
	public String mostrarPrimos(GenericStack<Integer> pilaPrimos) {
		String cadena = "";
		int cont = 0;
		while ( !pila.isEmpty()){
			int n = pila.pop();
			cadena= cadena +"\t"+n;
			cont++;
			if (cont % 10 == 0)
				cadena=cadena + "\n";
		}
		return cadena;
	}

	/**
	 * Metodo que nos indica si el numero que le pasamos en primo o no
	 * @param numero
	 * @return
	 */
	public static boolean esPrimo(int numero) {
		for (int i = 2; i <= numero / 2; i++) {
			if (numero % i == 0)
				return false;
		}
		return true;
	}
}
