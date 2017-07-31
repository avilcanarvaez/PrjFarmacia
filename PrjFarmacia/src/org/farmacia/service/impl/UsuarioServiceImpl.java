package org.farmacia.service.impl;

import java.util.List;


import org.farmacia.bean.Usuario;
import org.farmacia.dao.UsuarioDao;
import org.farmacia.dao.base.BaseDao;
import org.farmacia.service.UsuarioService;
import org.farmacia.service.impl.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService{

	@Autowired
	UsuarioDao usuarioDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertar(Usuario entidad) {
		usuarioDao.insertar(entidad);
	}

	@Override
	public void actualizar(Usuario entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Usuario entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario obtener(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
