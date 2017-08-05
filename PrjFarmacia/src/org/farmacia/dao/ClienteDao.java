package org.farmacia.dao;

import org.farmacia.bean.Cliente;
import org.farmacia.dao.base.BaseDao;

public interface ClienteDao extends BaseDao<Cliente, Integer>{
	public void crearCliente(Cliente usuario);
}
