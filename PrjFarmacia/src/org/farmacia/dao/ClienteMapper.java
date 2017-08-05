package org.farmacia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.farmacia.bean.Cliente;
import org.springframework.jdbc.core.RowMapper;

public class ClienteMapper implements RowMapper<Cliente>{

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cliente cliente= new Cliente();
		cliente.setIdCliente(rs.getInt("ID_CLIENTE"));
		cliente.setNombre(rs.getString("NOMBRE"));
		cliente.setApePaterno(rs.getString("APE_PATERNO"));
		cliente.setApeMaterno(rs.getString("APE_MATERNO"));
		cliente.setNroDocumento(rs.getString("NRO_DOCUMENTO"));
		cliente.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
		cliente.setCorreo(rs.getString("CORREO"));
		cliente.setDireccion(rs.getString("DIRECCION"));
		cliente.setTelefono(rs.getString("TELEFONO"));
		cliente.setEstado(rs.getString("ESTADO"));
		return cliente;
	}

}
