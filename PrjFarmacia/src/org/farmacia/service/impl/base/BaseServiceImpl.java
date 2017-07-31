/**
* Resumen.
* Objeto                    :    BaseServiceImpl.java
* Descripcion               :    Creacion de implementacion de servicio BaseServiceImpl.
* Fecha de Creacion         :    12/04/2016
* Autor                     :    Edinson Munoz
* ===========================================================================================================================
* Modificaciones
* Motivo             Fecha             Nombre                            Descripci�n
* ===========================================================================================================================
* REQ005             25/04/2016       Jim Aguilar                  Cambio de tipo de parametro en el metodo eliminar.
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
		try {
			return baseDao.obtener(id);
		} catch (Exception e) {
		}
		return null;
	}

	@Override	
	public List<E> listar(){
		try {
			return baseDao.listar();
		} catch (Exception e) {
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setBase(BaseDao<?, ?> baseDao) {
		this.baseDao = (BaseDao<E, ID>) baseDao;

	}

}
