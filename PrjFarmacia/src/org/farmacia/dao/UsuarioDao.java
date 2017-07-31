package org.farmacia.dao;

import org.farmacia.bean.Usuario;
import org.farmacia.dao.base.BaseDao;

public interface UsuarioDao extends BaseDao<Usuario, Integer>{
	public void crearUsuario(Usuario usuario);
}
