package org.farmacia.service;

import org.farmacia.bean.Usuario;
import org.springframework.beans.factory.annotation.Autowired;




public interface UsuarioService {
	public int verificarLogin(Usuario usuario);
}
