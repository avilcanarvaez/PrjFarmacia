package org.farmacia.dao;

import java.util.List;
import java.util.Map;

import org.farmacia.bean.Cliente;
import org.farmacia.bean.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoDaoImpl implements ProductoDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public  List<Producto> listarProductoPorParametroBusqueda(Map<String, Object> parametros) {
		StringBuilder sql=new StringBuilder();
		sql.append( "SELECT ID_CLIENTE,NOMBRE,APE_PATERNO,APE_MATERNO,NRO_DOCUMENTO,FECHA_NACIMIENTO,CORREO,DIRECCION,TELEFONO,ESTADO FROM CLIENTE");
		if (!parametros.get("nombre").equals("") || !parametros.get("apePaterno").equals("") || 
			!parametros.get("apeMaterno").equals("") || !parametros.get("documento").equals("")  ) {
			sql.append(" WHERE ");
				if (!parametros.get("nombre").equals("")) {
					sql.append("NOMBRE= '"+parametros.get("nombre")+"'");
				}
			
				if (!parametros.get("apePaterno").equals("")) {
					sql.append("AND APE_PATERNO= '"+parametros.get("apePaterno")+"'");
				}
				
				if (!parametros.get("apeMaterno").equals("")) {
					sql.append("AND APE_MATERNO= '"+parametros.get("apeMaterno")+"'");
				}
				
				if (!parametros.get("documento").equals("")) {
					sql.append("AND NRO_DOCUMENTO= '"+parametros.get("documento")+"'");
				}
			
		}
		
		return jdbcTemplate.query(sql.toString(), new ProductoMapper());
	}

	@Override
	public void insertar(Producto entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Producto entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Producto entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto obtener(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listar() {
		String sql="SELECT ID_PRODUCTO,NOMBRE,PRE_VENTA,PRE_COMPRA,FECHA_VENC,STOCK,ID_CATEGORIA,ESTADO FROM PRODUCTO";
		return jdbcTemplate.query(sql, new ProductoMapper());
	}

	@Override
	public Producto obtenerProductoXCodigo(String codigoProducto) {
		String sql="SELECT COD_PRODUCTO,ID_PRODUCTO,NOMBRE,PRE_VENTA,PRE_COMPRA,FECHA_VENC,STOCK,ID_CATEGORIA,ESTADO FROM PRODUCTO WHERE COD_PRODUCTO='"+codigoProducto+"'";
		Producto producto = (Producto)jdbcTemplate.queryForObject(sql, new ProductoMapper());
		return producto;
	}

	@Override
	public int actualizarStock(long idProducto, long cantidad) {
		 String sql = "UPDATE PRODUCTO SET STOCK = STOCK-? WHERE ID_PRODUCTO = ?";
		Object[] params= new Object[] {cantidad,idProducto};
		return this.jdbcTemplate.update(sql, params);
	}
	
}
