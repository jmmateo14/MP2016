package org.mp.sesion07;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Residencia implements Serializable {
	
	private String nombre;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Residente> residentes;
	private ArrayList<Reserva> reservas;

	/**
	 * Instance a new residence.
	 * @param nombre
	 * 			name of the residence.
	 * @param habitaciones
	 * 			rooms of the residence.
	 */
	public Residencia(String nombre, Habitacion[] habitaciones) {
		this.nombre = nombre;
		this.habitaciones = new ArrayList<Habitacion> ();
		for (int i=0; i<habitaciones.length; i++) {
			if (habitaciones[i] != null)
				this.habitaciones.add(habitaciones[i]);
		}
		this.residentes = new ArrayList<Residente> ();
		this.reservas = new ArrayList<Reserva> ();
	}

	public int getNHabitaciones() {
		return habitaciones.size();
	}

	/**
	 * Add room
	 * @param habitacion
	 * 			room to add.
	 */
	public void insertarHabitacion(Habitacion habitacion) {
		if (buscarHabitacion(habitacion.getNumero()) == null)
			habitaciones.add(habitacion);
	}

	/**
	 * Search rooom.
	 * @param numero
	 * 			String with the number of room.
	 * @return
	 * 		Return the room, if it fonds the room otherwise return null
	 */
	public Habitacion buscarHabitacion(String numero) {
		for (int i=0; i<habitaciones.size(); i++) {
			if (habitaciones.get(i).getNumero().equals(numero))
				return habitaciones.get(i);
		}
		return null;
	}

	/**
	 * Delete room.
	 * @param habitacion
	 * 			room that delete.
	 */
	public void eliminarHabitacion(Habitacion habitacion) {
		for (int i=0; i<habitaciones.size(); i++) {
			if (habitaciones.get(i).getNumero().equals(habitacion.getNumero())) {
				habitaciones.remove(i);
				return;
			}
		}
	}

	/**
	 * New entry.
	 * @param residente
	 * 			resident that asks the reserve.
	 * @param habitacion
	 * 			room that reserve.
	 * @param fechaEntrada
	 * 			entry date.
	 * @param fechaSalida
	 * 			departure date.
	 */
	public void ingreso(Residente residente, Habitacion habitacion,
			Date fechaEntrada, Date fechaSalida) {
		if(fechaSalida.before(fechaEntrada))
			return;
		if (isHabitacionOcupada(habitacion, fechaEntrada))
			return;
		insertarResidente(residente);
		insertarHabitacion (habitacion);
		Reserva reserva = new Reserva (residente, habitacion, 
				fechaEntrada, fechaSalida);
		insertarReserva (reserva);
	}
	
	/**
	 * Entry the resident.
	 * @param residente
	 * 			new resident.
	 */
	private void insertarResidente(Residente residente) {
		for (int i=0; i<residentes.size(); i++) {
			if (residentes.get(i).getDni().equals(residente.getDni()))
				return;
		}
		residentes.add(residente);
	}

	/**
	 * New reserve.
	 */
	private void insertarReserva(Reserva reserva) {
		reservas.add(reserva);
	}

	public int getNReservas () {
		return reservas.size();
	}
	
	
	public int getNResidentes () {
		return residentes.size();
	}
	
	/**
	 * Output of resident.
	 * @return
	 * 		output of date.
	 */
	public void salida(Residente residente, Date fechaSalida) {
		eliminarResidente (residente);
		for (int i=reservas.size()-1; i>=0; i--) {
			if (reservas.get(i).getResidente().getDni().equals
					(residente.getDni())) {
				reservas.get(i).setFechaSalida(fechaSalida);
				return;
			}
		}
	}

	private void eliminarResidente(Residente residente) {
		for (int i=0; i<residentes.size(); i++) {
			if (residentes.get(i).getDni().equals(residente.getDni())) {
				residentes.remove(i);
				return;
			}
		}
	}

	public void cambiarHabitacion(Residente residente, 
			Habitacion habitacion, Date fechaCambio, 
			Date fechaSalida) {
		salida (residente, fechaCambio);
		ingreso (residente, habitacion, fechaCambio, fechaSalida);
	}

	public Habitacion[] getHabitaciones() {
		Habitacion[]vHabitacion = new Habitacion [habitaciones.size()];
		for (int i=0; i<habitaciones.size(); i++)
			vHabitacion[i] = habitaciones.get(i);
		return vHabitacion;
	}

	public Reserva[] getReservas() {
		Reserva[] vReserva = new Reserva[reservas.size()];
		for (int i=0; i<reservas.size(); i++)
			vReserva[i] = reservas.get(i);
		return vReserva;
	}

	/**
	 * Check whether a room is occupied on a date determined
	 * 
	 * @param habitacion
	 * 			room to check
	 * @param fecha
	 * 			true whether room is occupied, false if not. 
	 * @return
	 */
	public boolean isHabitacionOcupada(Habitacion habitacion, Date fecha) {
		for (int i=0; i<reservas.size(); i++) {
			if (reservas.get(i).getHabitacion().getNumero().equals
					(habitacion.getNumero())) {
				if ((reservas.get(i).getFechaEntrada().before(fecha) ||
						reservas.get(i).getFechaEntrada().equals(fecha)) &&
						(reservas.get(i).getFechaSalida().after(fecha) ||
						reservas.get(i).getFechaSalida().equals(fecha)))
					return true;
			}
		}
		return false;
	}

	/**
	 * Free rooms list.
	 * @return String with free rooms.
	 */
	public String listadoHabitacionesLibres(Date fecha) {
		String cadena = ""; 
		
		for (int i=0; i<habitaciones.size(); i++) {
			if ( ! isHabitacionOcupada(habitaciones.get(i), fecha))
				cadena = cadena + habitaciones.get(i).getNumero()+"\n";
		}
		return cadena;
	}

	public String listadoResidentesHabitaciones(Date fecha) {
		String cadena = "";
		ArrayList<String> listaResidentes = new ArrayList<String> ();
		
		for (int i=0; i<reservas.size(); i++) {
			if ((reservas.get(i).getFechaEntrada().before(fecha) ||
					reservas.get(i).getFechaEntrada().equals(fecha)) &&
					reservas.get(i).getFechaSalida().after(fecha))
				listaResidentes.add(reservas.get(i).getResidente().getNombre());
		}
		Collections.sort(listaResidentes);
		for (int i=0; i<listaResidentes.size(); i++) {
			cadena = cadena + listaResidentes.get(i)+"\n";
		}
		return cadena;
	}

	/**
	 * List of average age by sex.
	 * @param fecha
	 * 			date to get the data.
	 * @return sex of residents
	 * 
	 */
	public String listadoEdadMediaPorSexo(Date fecha) {
		String cadena = "";
		int sumaV, sumaM, contV, contM;
		float mediaV, mediaM;
		
		sumaV = 0;
		contV = 0;
		sumaM = 0;
		contM = 0;
		for (int i=0; i<residentes.size(); i++) {
			if (residentes.get(i).getSexo() == 'V') {
				sumaV = sumaV + residentes.get(i).getEdad(fecha);
				contV = contV + 1;
			}
			else {
				sumaM = sumaM + residentes.get(i).getEdad(fecha);
				contM = contM + 1;
			}
		}
		if (contV == 0)
			mediaV = 0;
		else
			mediaV = (float)sumaV / contV;
		if (contM == 0)
			mediaM = 0;
		else
			mediaM = (float)sumaM / contM;
		cadena = "\nMedia de varones: "+mediaV+"\nMedia de mujeres: "+
				mediaM;
		return cadena;
	}
	
	public String getNombre(){
		return nombre;
	}
}

