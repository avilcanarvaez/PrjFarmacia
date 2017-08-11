package org.farmacia.bean;

import java.util.Date;
import java.util.List;

public class OrdenPedido {
	private long idOrdenPedido;
	private String nroOrdenPedido;
	private Date fecha;
	private long idCliente;
	private long idUsuario;
	private double total;
	private List<DetalleOrdenPedido> listaDetalleOrdenPedido;
	
	public long getIdOrdenPedido() {
		return idOrdenPedido;
	}
	public void setIdOrdenPedido(long idOrdenPedido) {
		this.idOrdenPedido = idOrdenPedido;
	}
	public String getNroOrdenPedido() {
		return nroOrdenPedido;
	}
	public void setNroOrdenPedido(String nroOrdenPedido) {
		this.nroOrdenPedido = nroOrdenPedido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<DetalleOrdenPedido> getListaDetalleOrdenPedido() {
		return listaDetalleOrdenPedido;
	}
	public void setListaDetalleOrdenPedido(List<DetalleOrdenPedido> listaDetalleOrdenPedido) {
		this.listaDetalleOrdenPedido = listaDetalleOrdenPedido;
	}

}
