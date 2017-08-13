package org.farmacia.dao;

import java.util.List;


import org.farmacia.bean.DetalleOrdenPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class DetalleOrdenPedidoDaoImpl implements DetalleOrdenPedidoDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertar(DetalleOrdenPedido entidad) {
		String sql="INSERT INTO detalleOrdenPedido(id_orden_pedido,id_producto,nombre_producto,cantidad,precio_venta) VALUES(?,?,?,?,?)";
		//Object[] params= new Object[] {entidad.getIdOrdenPedido() ,entidad.getIdProducto(),entidad.getNombreProducto(),entidad.getCantidad(),entidad.getPrecioVenta()};
		Object[] params= new Object[] {entidad.getIdOrdenPedido(),entidad.getIdProducto() ,entidad.getNombreProducto(),entidad.getCantidad(), entidad.getPrecioVenta()};
		this.jdbcTemplate.update(sql, params);
		
	}

	@Override
	public void actualizar(DetalleOrdenPedido entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(DetalleOrdenPedido entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DetalleOrdenPedido obtener(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleOrdenPedido> listar() {
		// TODO Auto-generated method stub
		return null;
	}


}
