package org.farmacia.bean;

public class DetalleOrdenPedido {
	private long idDetallePedido;
	private long idOrdenPedido;
	private long idProducto;
	private String nombreProducto;
	private long cantidad;
	private double precioVenta;
	
	public long getIdDetallePedido() {
		return idDetallePedido;
	}
	public void setIdDetallePedido(long idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}
	public long getIdOrdenPedido() {
		return idOrdenPedido;
	}
	public void setIdOrdenPedido(long idOrdenPedido) {
		this.idOrdenPedido = idOrdenPedido;
	}
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	
	

}