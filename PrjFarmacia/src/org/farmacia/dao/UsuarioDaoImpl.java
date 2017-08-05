package org.farmacia.dao;

import java.sql.Date;
import java.util.List;

import org.farmacia.bean.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public void insertar(Usuario usuario) {
		String sql="INSERT INTO USUARIO(NOMBRE,APE_PATERNO,APE_MATERNO,CLAVE,FECHA_NACIMIENTO) VALUES(?,?,?,?,?)";
		Object[] params= new Object[] {usuario.getNombre(),usuario.getApePaterno(),usuario.getApeMaterno(),usuario.getClave(), this.convertirFecha(usuario.getFechaNacimiento())};
		this.jdbcTemplate.update(sql, params);
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
	public Usuario obtener(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		String sql="SELECT ID_USUARIO,CLAVE,NOMBRE,APE_PATERNO,APE_MATERNO,FECHA_NACIMIENTO,CORREO,DIRECCION,TELEFONO FROM USUARIO";
		return jdbcTemplate.query(sql, new UsuarioMapper());
	}

	@Override
	public void crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	private java.sql.Date convertirFecha(java.util.Date fecha){
		return new Date((fecha!=null)?fecha.getTime():null);
	}
}
