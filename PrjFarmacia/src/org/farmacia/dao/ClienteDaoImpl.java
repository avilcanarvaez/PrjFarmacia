package org.farmacia.dao;

import java.sql.Date;
import java.util.List;

import org.farmacia.bean.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements ClienteDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public void insertar(Cliente usuario) {
		String sql="INSERT INTO CLIENTE(NOMBRE,APE_PATERNO,APE_MATERNO,NRO_DOCUMENTO,FECHA_NACIMIENTO,CORREO,DIRECCION,TELEFONO,ESTADO) VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] params= new Object[] {usuario.getNombre(),usuario.getApePaterno(),usuario.getApeMaterno(),usuario.getNroDocumento(), this.convertirFecha(usuario.getFechaNacimiento()),usuario.getCorreo(),usuario.getDireccion(),usuario.getTelefono(),"1"};
		this.jdbcTemplate.update(sql, params);
	}

	@Override
	public void actualizar(Cliente entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Cliente entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente obtener(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> listar() {
		String sql="SELECT ID_CLIENTE,NOMBRE,APE_PATERNO,APE_MATERNO,NRO_DOCUMENTO,FECHA_NACIMIENTO,CORREO,DIRECCION,TELEFONO,ESTADO FROM CLIENTE";
		return jdbcTemplate.query(sql, new ClienteMapper());
	}

	@Override
	public void crearCliente(Cliente usuario) {
		// TODO Auto-generated method stub
		
	}

	private java.sql.Date convertirFecha(java.util.Date fecha){
		return new Date((fecha!=null)?fecha.getTime():null);
	}
}
