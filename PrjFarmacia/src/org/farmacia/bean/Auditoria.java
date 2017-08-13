package org.farmacia.bean;

import java.io.Serializable;
import java.util.Date;


public class Auditoria implements Serializable{

	/** Número de version de la clase Serializable */
	private static final long serialVersionUID = -637524904698174361L;
	/** Identificador de usuario de creación. */
	private String idUsuaCrea;
	/** Fecha de creacion. */
	private Date feUsuaCrea;
	/** IP de creacion. */
	private String deTermCrea;
	/** Identificador de usuario de modificacion. */
	private String idUsuaModi;
	/** Fecha de modificacion. */
	private Date feUsuaModi;
	/** IP de modificacion. */
	private String deTermModi;
	/** IP de modificacion. */
	private String rolUsuarioFnt;
	/** IP de modificacion. */
	private String perfilUsuario;

	public String getIdUsuaCrea() {
		return idUsuaCrea;
	}

	public void setIdUsuaCrea(String idUsuaCrea) {
		this.idUsuaCrea = idUsuaCrea;
	}

	public Date getFeUsuaCrea() {
		return feUsuaCrea;
	}

	public void setFeUsuaCrea(Date feUsuaCrea) {
		this.feUsuaCrea = feUsuaCrea;
	}

	public String getDeTermCrea() {
		return deTermCrea;
	}

	public void setDeTermCrea(String deTermCrea) {
		this.deTermCrea = deTermCrea;
	}

	public String getIdUsuaModi() {
		return idUsuaModi;
	}

	public void setIdUsuaModi(String idUsuaModi) {
		this.idUsuaModi = idUsuaModi;
	}

	public Date getFeUsuaModi() {
		return feUsuaModi;
	}

	public void setFeUsuaModi(Date feUsuaModi) {
		this.feUsuaModi = feUsuaModi;
	}

	public String getDeTermModi() {
		return deTermModi;
	}

	public void setDeTermModi(String deTermModi) {
		this.deTermModi = deTermModi;
	}

	public String getRolUsuarioFnt() {
		return rolUsuarioFnt;
	}

	public void setRolUsuarioFnt(String rolUsuarioFnt) {
		this.rolUsuarioFnt = rolUsuarioFnt;
	}

	public String getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(String perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

}
