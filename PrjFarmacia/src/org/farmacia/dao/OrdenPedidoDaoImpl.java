package org.farmacia.dao;

import java.util.List;

import org.farmacia.bean.Cliente;
import org.farmacia.bean.OrdenPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrdenPedidoDaoImpl implements OrdenPedidoDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertar(OrdenPedido entidad) {
		String sql="INSERT INTO OrdenPedido(nro_orden_pedido,id_cliente,id_usuario,total,fecha_venta) VALUES(?,?,?,?,NOW())";
		//Object[] params= new Object[] {entidad.getNroOrdenPedido() ,entidad.getIdCliente() ,entidad.getIdUsuario(),entidad.getTotal()};
		Object[] params= new Object[] {"001" ,1 ,1,150.50};
		this.jdbcTemplate.update(sql, params);
		
	}

	@Override
	public void actualizar(OrdenPedido entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(OrdenPedido entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrdenPedido obtener(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdenPedido> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String obtenerUltimoIdPedido() {
		String sql="SELECT * FROM(SELECT id_orden_pedido FROM ordenPedido) AS o ORDER BY o.id_orden_pedido DESC LIMIT 1";
		String ultimoIdPedido= (String)jdbcTemplate.queryForObject(sql, String.class );
		return ultimoIdPedido;
	}

}
