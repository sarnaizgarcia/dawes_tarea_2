package com.ite.clientes.modelo.beans;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idUsuario;
	private String userName;
	private String passwordUsuario;
	private String emailUsuario;
	private String nombreUsuario;
	private String direccionUsuario;
	private int enabled;
	private Date fechaAlta;
	private String rol;
	
	public Cliente(int idUsuario, String userName, String passwordUsuario, String emailUsuario, String nombreUsuario,
			String direccionUsuario, Date fechaAlta) {
		super();
		this.idUsuario = idUsuario;
		this.userName = userName;
		this.passwordUsuario = passwordUsuario;
		this.emailUsuario = emailUsuario;
		this.nombreUsuario = nombreUsuario;
		this.direccionUsuario = direccionUsuario;
		this.enabled = 0; // 1 logado.
		this.fechaAlta = fechaAlta;
		this.rol = "Cliente";
	}

	public Cliente() {
		super();
		this.enabled = 0;
		this.rol = "Cliente";
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getDireccionUsuario() {
		return direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccionUsuario == null) ? 0 : direccionUsuario.hashCode());
		result = prime * result + ((emailUsuario == null) ? 0 : emailUsuario.hashCode());
		result = prime * result + enabled;
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + idUsuario;
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		result = prime * result + ((passwordUsuario == null) ? 0 : passwordUsuario.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		if (direccionUsuario == null) {
			if (other.direccionUsuario != null)
				return false;
		} else if (!direccionUsuario.equals(other.direccionUsuario))
			return false;
		if (emailUsuario == null) {
			if (other.emailUsuario != null)
				return false;
		} else if (!emailUsuario.equals(other.emailUsuario))
			return false;
		if (enabled != other.enabled)
			return false;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		if (passwordUsuario == null) {
			if (other.passwordUsuario != null)
				return false;
		} else if (!passwordUsuario.equals(other.passwordUsuario))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [idUsuario=" + idUsuario + ", userName=" + userName + ", passwordUsuario=" + passwordUsuario
				+ ", emailUsuario=" + emailUsuario + ", nombreUsuario=" + nombreUsuario + ", direccionUsuario="
				+ direccionUsuario + ", enabled=" + enabled + ", fechaAlta=" + fechaAlta + "]";
	}

}
