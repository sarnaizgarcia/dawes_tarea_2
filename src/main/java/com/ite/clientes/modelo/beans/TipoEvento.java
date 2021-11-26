package com.ite.clientes.modelo.beans;

import java.io.Serializable;

public class TipoEvento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idTipo;
	private String nombreTipo;
	private String descripcionTipo;
	
	public TipoEvento(int idTipo, String nombreTipo, String descripcionTipo) {
		super();
		this.idTipo = idTipo;
		this.nombreTipo = nombreTipo;
		this.descripcionTipo = descripcionTipo;
	}
	
	public TipoEvento() {
		super();		
	}
	
	public int getIdTipo() {
		return idTipo;
	}
	
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	
	public String getNombreTipo() {
		return nombreTipo;
	}
	
	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
	public String getDescripcionTipo() {
		return descripcionTipo;
	}
	
	public void setDescripcionTipo(String descripcionTipo) {
		this.descripcionTipo = descripcionTipo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipo;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TipoEvento))
			return false;
		TipoEvento other = (TipoEvento) obj;
		if (idTipo != other.idTipo)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Tipo [idTipo=" + idTipo + ", nombreTipo=" + nombreTipo + ", descripcionTipo=" + descripcionTipo + "]";
	}

}
