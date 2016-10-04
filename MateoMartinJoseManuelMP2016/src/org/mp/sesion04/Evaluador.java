package org.mp.sesion04;


public class Evaluador {

	private final char SUMAR = '+';

	private final char RESTAR = '-';

	private final char MULTIPLICAR = '*';

	private final char DIVIDIR = '/';

	private GenericStack<Integer> pila;

	/**
	 * constructor de la clase
	 */
	public Evaluador() {
		pila = new GenericStack<Integer>();
	}


	public String evaluar(String expresion) {
		String[] a = parser(expresion);
		boolean soloNumeros = true;
		for (int i = 0; i < a.length; i++) {
			if (esOperador(a[i]))
				soloNumeros = false;
		}
		if (soloNumeros == true) {
			String cadena = "";
			for (int i = 0; i < a.length; i++)
				cadena = cadena + a[i];
			a = new String[1];
			a[0] = cadena;
		}
		try {
			int resultado = postfija(a);
			return resultado + "";
		} catch (RuntimeException e) {

			return e.getMessage();
		}
	}


	public String[] parser(String expresion) {
		String nueva = "";
		for (int i = 0; i < expresion.length(); i++) {
			String valor = expresion.substring(i, i + 1);
			if (esOperador(valor))
				nueva = nueva + " " + valor + " ";
			else
				nueva = nueva + valor;
		}
		expresion = nueva;
		expresion = expresion.trim();
		while (expresion.contains("  ")) {
			expresion = expresion.replace("  ", " ");
		}
		String[] a = expresion.split(" ");
		return a;

	}


	public int postfija(String[] expresion) {
		for (int i = 0; i < expresion.length; i++) {
			if (soloDigitos(expresion[i]))
				pila.push(Integer.parseInt(expresion[i]));
			else {
				if (esOperador(expresion[i])) {
					int op2 = pila.pop();
					int op1 = pila.pop();
					char operacion = expresion[i].charAt(0);
					int resul = evaluarOperacion(operacion, op1, op2);
					pila.push(resul);
				}
			}
		}
		return pila.pop();
	}

	/**
	 * Metodo que evalua las operaciones
	 * @param operacion
	 * @param op1
	 * @param op2
	 * @return
	 */
	private int evaluarOperacion(char operacion, int op1, int op2) {
		int resul = 0;
		switch (operacion) {
		case SUMAR:
			resul = op1 + op2;
			break;
		case RESTAR:
			resul = op1 - op2;
			break;
		case MULTIPLICAR:
			resul = op1 * op2;
			break;
		case DIVIDIR:
			if (op2 == 0)
				throw new RuntimeException("No es posible una división por cero");
			resul = op1 / op2;
			break;
		}
		return resul;
	}

	/**
	 * Metodo que nos indica si es un operador devuelve true o false
	 * @param token
	 * @return
	 */
	private boolean esOperador(String token) {
		if (token.charAt(0) == SUMAR || token.charAt(0) == RESTAR || token.charAt(0) == MULTIPLICAR
				|| token.charAt(0) == DIVIDIR)
			return true;
		return false;
	}


	private boolean soloDigitos(String expresion) {
		for (int i = 0; i < expresion.length(); i++) {
			if (!Character.isDigit(expresion.charAt(i)))
				return false;
		}
		return true;

	}
}
