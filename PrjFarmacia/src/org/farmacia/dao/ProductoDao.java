package org.farmacia.dao;

import java.util.List;
import java.util.Map;


import org.farmacia.bean.Producto;
import org.farmacia.dao.base.BaseDao;

public interface ProductoDao extends BaseDao<Producto, Long>{
	
//	public void crearCliente(Cliente usuario);
	public List<Producto> listarProductoPorParametroBusqueda(Map<String, Object> parametros);
	public Producto obtenerProductoXCodigo(String codigoProducto);
	public int actualizarStock(long idProducto,long cantidad);
}
