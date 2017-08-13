package org.farmacia.service.impl;

import org.farmacia.bean.DetalleOrdenPedido;
import org.farmacia.bean.OrdenPedido;
import org.farmacia.dao.DetalleOrdenPedidoDao;
import org.farmacia.dao.OrdenPedidoDao;
import org.farmacia.dao.ProductoDao;
import org.farmacia.service.OrdenPedidoService;
import org.farmacia.service.impl.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdenPedidoServiceImpl extends BaseServiceImpl<OrdenPedido, Long> implements OrdenPedidoService{
	
	@Autowired
	OrdenPedidoDao ordenPedidoDao;
	@Autowired
	DetalleOrdenPedidoDao detalleOrdenPedidoDao;
	@Autowired
	ProductoDao productoDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(OrdenPedido entidad) {
		//
		double total=0;
//		for (int i = 0; i <  entidad.getListaDetalleOrdenPedido().size(); i++) {
//			total+=entidad.getListaDetalleOrdenPedido().get(i).getPrecioVenta();
//		}
		
		for (DetalleOrdenPedido e : entidad.getListaDetalleOrdenPedido()) {
			total+=e.getPrecioVenta() * e.getCantidad();
		}
		
		entidad.setTotal(total);
		ordenPedidoDao.insertar(entidad);
		//
		
		
		long ultimoIdPedido=Long.parseLong( ordenPedidoDao.obtenerUltimoIdPedido());
		for (int i = 0; i < entidad.getListaDetalleOrdenPedido().size(); i++) {
			total+=entidad.getListaDetalleOrdenPedido().get(i).getPrecioVenta();
			entidad.getListaDetalleOrdenPedido().get(i).setIdOrdenPedido(ultimoIdPedido);
			
			detalleOrdenPedidoDao.insertar(entidad.getListaDetalleOrdenPedido().get(i));
			int resultadoAct= productoDao.actualizarStock(entidad.getListaDetalleOrdenPedido().get(i).getIdProducto(), entidad.getListaDetalleOrdenPedido().get(i).getCantidad());
		}
		
	}
}
