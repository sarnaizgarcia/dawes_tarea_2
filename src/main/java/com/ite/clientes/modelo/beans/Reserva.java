package com.ite.clientes.modelo.beans;

import java.io.Serializable;

public class Reserva implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	static private int serie = 1;
	
	private int idReserva;
	private int idEvento;
	private int idUsuario;
	private double precioReserva;
	private String observaciones;
	private Integer cantidad;
	
	public Reserva() {
		super();
		this.idReserva = serie++;
	}

	public Reserva(int idEvento, int idUsuario, double precioReserva, String observaciones,
			Integer cantidad) {
		super();
		this.idReserva = serie++;
		this.idEvento = idEvento;
		this.idUsuario = idUsuario;
		this.precioReserva = precioReserva;
		this.observaciones = observaciones;
		this.cantidad = cantidad;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public double getPrecioReserva() {
		return precioReserva;
	}

	public void setPrecioReserva(double precioReserva) {
		this.precioReserva = precioReserva;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + idEvento;
		result = prime * result + idReserva;
		result = prime * result + idUsuario;
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precioReserva);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Reserva))
			return false;
		Reserva other = (Reserva) obj;
		if (cantidad != other.cantidad)
			return false;
		if (idEvento != other.idEvento)
			return false;
		if (idReserva != other.idReserva)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (Double.doubleToLongBits(precioReserva) != Double.doubleToLongBits(other.precioReserva))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", idEvento=" + idEvento + ", idUsuario=" + idUsuario
				+ ", precioReserva=" + precioReserva + ", observaciones=" + observaciones + ", cantidad=" + cantidad
				+ "]";
	}


}
