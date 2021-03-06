/**
* Resumen.
* Objeto                    :    BaseServiceImpl.java
* Descripcion               :    Creacion de implementacion de servicio BaseServiceImpl.
* Fecha de Creacion         :    30/07/2017
* Autor                     :    Alexander Vilca
* ===========================================================================================================================
* Modificaciones
* Motivo             Fecha             Nombre                            Descripcionn
* ===========================================================================================================================
*
 * */


package org.farmacia.service.impl.base;

import java.util.List;

import org.farmacia.dao.base.BaseDao;
import org.farmacia.service.base.BaseService;


public class BaseServiceImpl<E, ID> implements BaseService<E, ID> {

	private BaseDao<E, ID> baseDao;

	@Override	
	public void insertar(E entidad)  {
		try {
			baseDao.insertar(entidad);
		} catch (Exception e) {
		
		}

	}
	
	@Override	
	public void actualizar(E entidad) {
		try {
			baseDao.actualizar(entidad);
		} catch (Exception e) {
		
		}
	}

	@Override
	public void eliminar(E entidad) {
		try {
			baseDao.eliminar(entidad);
		} catch (Exception e) {
	
		}

	}

	@Override	
	public E obtener(ID id){
		return baseDao.obtener(id);
	}

	@Override	
	public List<E> listar(){
		return baseDao.listar();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setBase(BaseDao<?, ?> baseDao) {
		this.baseDao = (BaseDao<E, ID>) baseDao;
	}

}
