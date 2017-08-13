package org.farmacia.bean;

import java.sql.Date;

public class Producto {

	private long idProducto;
	private String nombre;
	private String preVenta;
	private String preCompra;
	private Date fechaVenc;
	private int stock;
	private int idCategoria;
	private int estado;

	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPreVenta() {
		return preVenta;
	}
	public void setPreVenta(String preVenta) {
		this.preVenta = preVenta;
	}
	public String getPreCompra() {
		return preCompra;
	}
	public void setPreCompra(String preCompra) {
		this.preCompra = preCompra;
	}
	public Date getFechaVenc() {
		return fechaVenc;
	}
	public void setFechaVenc(Date fechaVenc) {
		this.fechaVenc = fechaVenc;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}

}
