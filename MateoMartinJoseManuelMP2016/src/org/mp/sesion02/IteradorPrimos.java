package org.mp.sesion02;

import java.util.Iterator;
import java.util.*;

public class IteradorPrimos implements Iterator<Integer> {


	private Integer limite;
	private Integer actual = 1;

	/**
	 * Constructor de la clase IteradorPrimo
	 * @param maximo
	 */
	public IteradorPrimos(int maximo) {
		limite = new Integer(maximo);
	}

	/**
	 * Metodo get que devuelve la variable limite
	 * @return limite
	 */
	public int getLimite() {
		return limite.intValue();
	}

	/**
	 * Metodo get que devuelve el elemento actual
	 * @return actual
	 */
	public int getActual() {
		return actual.intValue();
	}


	/**
	 * Metodo hasNext que comprueba si hay elemento siguiente
	 * y tambien se encarga de pasar al elemento siguiente.
	 */
	@Override
	public boolean hasNext() {
		for(int num = (actual.intValue() + 1); num <= limite.intValue(); num++){
            if((boolean) IteradorPrimos.esPrimo(num)){
                actual = new Integer(num);
                return true;
            }
        }
        return false;

	}

	/**
	 * Metodo next que solo devuelve el actual, hace lo mismo que el getActual.
	 */
	@Override
	public Integer next() {
		return actual;

	}

	/**
	 * Metodo remove, manda una excepcion.
	 */
	public void remove(){
		throw new UnsupportedOperationException("Método no soportado");
	}

	/**
	 * Metodo que nos dice si un numero es primo o no
	 * @param numero
	 * @return true si el numero es primo, false en caso contrario
	 */
	public static Object esPrimo(int numero) {
		int divisor = 2;
        boolean primo = true;
        if(numero % divisor != 0){
            divisor++;
            while(primo && divisor < numero){
                if(numero % divisor == 0){
                    primo = false;
                }
            divisor += 2;
            }
        }else{
            primo = false;
        }
        if (numero == 2){
            primo = true;
        }
        return primo;
	}

	/**
	 * Metodo que muestra los n primos hasta alcanzar el limite y 10 por linea.
	 * @return
	 */
	public String mostrarPrimos() {
		int contador = 0;
        StringBuffer sb = new StringBuffer();
        for(int num = 2; num <= limite.intValue(); num++){
            if((boolean) IteradorPrimos.esPrimo(num)){
                sb.append("\t"+ num);
                contador++;
                if(contador % 10 == 0)
                    sb.append("\n");
            }
        }
        String cadena = new String(sb);
        return cadena;
	}


}

