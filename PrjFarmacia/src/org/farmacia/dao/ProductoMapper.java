package org.farmacia.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.farmacia.bean.Producto;
import org.springframework.jdbc.core.RowMapper;

public class ProductoMapper implements RowMapper<Producto> {
	
	@Override
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Producto producto= new Producto();
		producto.setIdProducto(rs.getInt("ID_PRODUCTO"));
		producto.setNombre(rs.getString("NOMBRE"));
		producto.setPreVenta(rs.getString("PRE_VENTA"));
		producto.setPreCompra(rs.getString("PRE_COMPRA"));
		producto.setFechaVenc(rs.getDate("FECHA_VENC"));
		producto.setStock(rs.getInt("STOCK"));
		producto.setIdCategoria(rs.getInt("ID_CATEGORIA"));
		producto.setEstado(rs.getInt("ESTADO"));
		return producto;
	}


}
