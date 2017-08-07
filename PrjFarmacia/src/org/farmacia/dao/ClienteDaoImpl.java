package org.farmacia.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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

	@Override
	public  List<Cliente> listarClientesPorParametroBusqueda(Map<String, Object> parametros) {
		//System.out.println("parametro(txtNombre)==>"+parametros.get("nombre") )
		//{documento=123, apeMaterno=n, nombre=alex, apePaterno=v};
		
		StringBuilder sql=new StringBuilder();
		sql.append( "SELECT ID_CLIENTE,NOMBRE,APE_PATERNO,APE_MATERNO,NRO_DOCUMENTO,FECHA_NACIMIENTO,CORREO,DIRECCION,TELEFONO,ESTADO FROM CLIENTE");
		if (!parametros.get("nombre").equals("") || !parametros.get("apePaterno").equals("") || 
			!parametros.get("apeMaterno").equals("") || !parametros.get("documento").equals("")  ) {
			sql.append(" WHERE ");
				if (!parametros.get("nombre").equals("")) {
					sql.append("NOMBRE= '"+parametros.get("nombre")+"'");
				}
			
				if (!parametros.get("apePaterno").equals("")) {
					sql.append("AND APE_PATERNO= '"+parametros.get("apePaterno")+"'");
				}
				
				if (!parametros.get("apeMaterno").equals("")) {
					sql.append("AND APE_MATERNO= '"+parametros.get("apeMaterno")+"'");
				}
				
				if (!parametros.get("documento").equals("")) {
					sql.append("AND NRO_DOCUMENTO= '"+parametros.get("documento")+"'");
				}
			
		}
		
		return jdbcTemplate.query(sql.toString(), new ClienteMapper());
	}
}
