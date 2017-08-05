package org.farmacia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.farmacia.bean.Usuario;
import org.springframework.jdbc.core.RowMapper;

public class UsuarioMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario= new Usuario();
		usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
		usuario.setClave(rs.getString("CLAVE"));
		usuario.setNombre(rs.getString("NOMBRE"));
		usuario.setApePaterno(rs.getString("APE_PATERNO"));
		usuario.setApeMaterno(rs.getString("APE_MATERNO"));
		usuario.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
		usuario.setFechaNacimiento(rs.getDate("CORREO"));
		usuario.setFechaNacimiento(rs.getDate("DIRECCION"));
		usuario.setFechaNacimiento(rs.getDate("TELEFONO"));
		return usuario;
	}

}
