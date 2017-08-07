package org.farmacia.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.farmacia.bean.Cliente;
import org.farmacia.service.base.BaseService;


public interface ClienteService extends BaseService<Cliente, Long> {
	//int crearCliente(Cliente cliente);
	List<Cliente> listarClientesPorParametroBusqueda(Map<String, Object> parametros);
}