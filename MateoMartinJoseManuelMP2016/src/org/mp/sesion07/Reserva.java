package org.mp.sesion07;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable{

	private static int ultimoNumero = 0;
	private int numeroReserva;
	private Residente residente;
	private Habitacion habitacion;
	private Date fechaEntrada;
	private Date fechaSalida;
	
	/**
	 * Instance a new reserve.
	 * 
	 * @param residente
	 * 				resident that asks the reserve.
	 * @param habitacion
	 * 				room that asks the resident to your reserve.
	 * @param fechaEntrada
	 * 				entry date of the reserve.
	 * @param fechaSalida
	 * 				departure date of the reserve.
	 */
	public Reserva(Residente residente, Habitacion habitacion,
			Date fechaEntrada, Date fechaSalida) {
		ultimoNumero++;
		this.numeroReserva = ultimoNumero;
		this.residente = residente;
		this.habitacion = habitacion;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}

	/**
	 * Method getter of the resident of the reserve.
	 * 
	 * @return residente.
	 */
	public Residente getResidente() {
		return residente;
	}

	public void setResidente(Residente residente) {
		this.residente = residente;
	}

	/**
	 * Method getter of the room of the reserve.
	 * 
	 * @return habitacion.
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	/**
	 * Method getter of the entry date of the reserve.
	 * 
	 * @return fechaEntrada
	 */
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	/**
	 * Method getter of the departure date of the reserve.
	 * 
	 * @return fechaSalida.
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * Method getter of the number of the latest reserve.
	 * 
	 * @return ultimoNumero.
	 */
	public static int getUltimoNumero() {
		return ultimoNumero;
	}

	/**
	 * Method getter of the number of the reserve.
	 * 
	 * @return numeroReserva.
	 */
	public int getNumeroReserva() {
		return numeroReserva;
	}
	
	
}

