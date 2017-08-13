package org.farmacia.service.impl;

import org.farmacia.bean.Usuario;
import org.farmacia.dao.UsuarioDao;
import org.farmacia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	public int verificarLogin(Usuario usuario) {
		return usuarioDao.verificarLogin(usuario) ;
	}

}
