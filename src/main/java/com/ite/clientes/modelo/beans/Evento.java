package com.ite.clientes.modelo.beans;

import java.io.Serializable;
import java.util.Date;

public class Evento implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	private int idEvento;
	private String nombreEvento;
	private String descripcionEvento;
 	private Date fechaEvento;
 	private int duracionEvento;
 	private String direccionEvento;
 	private String estadoEvento;
 	private String destacadoEvento;
 	private int aforoMaximo;
 	private int minimoAsistencia;
	private double precio;
	private TipoEvento tipoEvento;
	
	public Evento(int idEvento, String nombreEvento, String descripcionEvento, Date fechaEvento, int duracionEvento,
			String direccionEvento, String estadoEvento, String destacadoEvento, int aforoMaximo, int minimoAsistencia,
			double precio, TipoEvento tipoEvento) {
		super();
		this.idEvento = idEvento;
		this.nombreEvento = nombreEvento;
		this.descripcionEvento = descripcionEvento;
		this.fechaEvento = fechaEvento;
		this.duracionEvento = duracionEvento;
		this.direccionEvento = direccionEvento;
		this.estadoEvento = estadoEvento;
		this.destacadoEvento = destacadoEvento;
		this.aforoMaximo = aforoMaximo;
		this.minimoAsistencia = minimoAsistencia;
		this.precio = precio;
		this.tipoEvento = tipoEvento;	
	}
	
	public Evento() {
		super();
	}
	
	public int getIdEvento() {
		return idEvento;
	}
	
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	
	public String getNombreEvento() {
		return nombreEvento;
	}
	
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	
	public String getDescripcionEvento() {
		return descripcionEvento;
	}
	
	public void setDescripcionEvento(String descripcionEvento) {
		this.descripcionEvento = descripcionEvento;
	}
	
	public Date getFechaEvento() {
		return fechaEvento;
	}
	
	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	
	public int getDuracionEvento() {
		return duracionEvento;
	}
	
	public void setDuracionEvento(int duracionEvento) {
		this.duracionEvento = duracionEvento;
	}
	
	public String getDireccionEvento() {
		return direccionEvento;
	}
	
	public void setDireccionEvento(String direccionEvento) {
		this.direccionEvento = direccionEvento;
	}
	
	public String getEstadoEvento() {
		return estadoEvento;
	}
	
	public void setEstadoEvento(String estadoEvento) {
		this.estadoEvento = estadoEvento;
	}
	
	public String isDestacadoEvento() {
		return destacadoEvento;
	}
	
	public void setDestacadoEvento(String destacadoEvento) {
		this.destacadoEvento = destacadoEvento;
	}
	
	public int getAforoMaximo() {
		return aforoMaximo;
	}
	
	public void setAforoMaximo(int aforoMaximo) {
		this.aforoMaximo = aforoMaximo;
	}
	
	public int getMinimoAsistencia() {
		return minimoAsistencia;
	}
	
	public void setMinimoAsistencia(int minimoAsistencia) {
		this.minimoAsistencia = minimoAsistencia;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}
	
	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idEvento;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Evento))
			return false;
		Evento other = (Evento) obj;
		if (idEvento != other.idEvento)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nombreEvento=" + nombreEvento + ", descripcionEvento="
				+ descripcionEvento + ", fechaEvento=" + fechaEvento + ", duracionEvento=" + duracionEvento
				+ ", direccionEvento=" + direccionEvento + ", estadoEvento=" + estadoEvento + ", destacadoEvento="
				+ destacadoEvento + ", aforoMaximo=" + aforoMaximo + ", minimoAsistencia=" + minimoAsistencia
				+ ", precio=" + precio + ", tipoEvento=" + tipoEvento + "]";
	}

}
