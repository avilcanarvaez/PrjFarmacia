package org.farmacia.dao;

import org.farmacia.bean.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UsuarioDaoImpl implements UsuarioDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int verificarLogin(Usuario usuario) {
		String sql="select count(*) from usuario WHERE cod_usuario='"+ usuario.getCodUsuario()+"' AND password='" + usuario.getPassword() +"'";
		System.out.println("SQL=>"+ sql);
		String correcto= (String)jdbcTemplate.queryForObject(sql, String.class );
		return Integer.parseInt(correcto) ;
	}

}
