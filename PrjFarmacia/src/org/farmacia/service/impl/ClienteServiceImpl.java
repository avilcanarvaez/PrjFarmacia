package org.farmacia.service.impl;

import java.util.List;
import java.util.Map;

import org.farmacia.bean.Cliente;
import org.farmacia.dao.ClienteDao;
import org.farmacia.service.ClienteService;
import org.farmacia.service.impl.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService{

	@Autowired
	ClienteDao clienteDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Cliente entidad) {
		clienteDao.insertar(entidad);
	}

	@Override
	public void actualizar(Cliente entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Cliente entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente obtener(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listar() {
			return clienteDao.listar();
	}

	@Override
	public List<Cliente>listarClientesPorParametroBusqueda(Map<String, Object> parametros) {
		return clienteDao.listarClientesPorParametroBusqueda(parametros);
	}

	
	
	
	
}
