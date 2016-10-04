package org.mp.sesion05;

import java.util.LinkedList;
import java.util.List;

public class Acciones {
	
	/**
	 * List of share.
	 */
	 private List acciones;
	 
	 /**
	  * Constructor of Acciones. Instance a LinkedList in the variable acciones.
	  */
	 public Acciones(){
		 acciones = new LinkedList();
	 }
	 
	 /**
	  * Adds a new shares to the list.
	  * 
	  * @param accion.
	  */
	 public void add (Accion accion){
		 acciones.add(accion); 
	 }
	 
	 /**
	  * Returns the list of shares.
	  * 
	  * @return list of shares.
	  */
	 public List getAcciones(){
		 return acciones;
	 }
	 
	 
}
