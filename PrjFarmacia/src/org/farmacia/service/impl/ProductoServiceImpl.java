package org.farmacia.service.impl;

import java.util.List;
import java.util.Map;

import org.farmacia.bean.Cliente;
import org.farmacia.bean.Producto;
import org.farmacia.dao.ProductoDao;
import org.farmacia.service.ProductoService;
import org.farmacia.service.impl.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService {
	
	@Autowired
	ProductoDao productoDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Producto entidad) {
		productoDao.insertar(entidad);
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
		return productoDao.obtener(id);
	}

	@Override
	public List<Producto> listar() {
			return productoDao.listar();
	}

	
	@Override
	public List<Producto>listarProductoPorParametroBusqueda(Map<String, Object> parametros) {
		return productoDao.listarProductoPorParametroBusqueda(parametros);
	}

	@Override
	public Producto obtenerProductoXCodigo(String codigoProducto) {
		return productoDao.obtenerProductoXCodigo(codigoProducto);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int actualizarStock(long idProducto, long cantidad) {
		return productoDao.actualizarStock(idProducto, cantidad);
	}

}
