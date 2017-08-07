package org.farmacia.dao;

import java.util.List;
import java.util.Map;

import org.farmacia.bean.Cliente;
import org.farmacia.dao.base.BaseDao;

public interface ClienteDao extends BaseDao<Cliente, Integer>{
	public void crearCliente(Cliente usuario);
	public List<Cliente> listarClientesPorParametroBusqueda(Map<String, Object> parametros);
}
