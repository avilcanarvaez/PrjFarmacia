package org.farmacia.service;

import java.util.List;
import java.util.Map;


import org.farmacia.bean.Producto;
import org.farmacia.service.base.BaseService;

public interface ProductoService extends BaseService<Producto, Long>{
	List<Producto> listarProductoPorParametroBusqueda(Map<String, Object> parametros);
	Producto obtenerProductoXCodigo(String codigoProducto);
	int actualizarStock(long idProducto,long cantidad);
	
}