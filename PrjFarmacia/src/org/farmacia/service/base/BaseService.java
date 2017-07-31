/**
* Resumen.
* Objeto                    :    BaseService.java
* Descripcion               :    Creacion  de servicio BaseService.
* Fecha de Creacion         :    30/07/2017
* Autor                     :    Alexander Vilca
* ===========================================================================================================================
* Modificaciones
* Motivo             Fecha             Nombre                            Descripcion
* ===========================================================================================================================
 * */

package org.farmacia.service.base;

import java.util.List;

import org.farmacia.dao.base.BaseDao;

public interface BaseService<E, ID>{

	void insertar(E entidad);
	
	void actualizar(E entidad);

	void eliminar(E entidad);

	E obtener(ID id);

	List<E> listar();

	void setBase(BaseDao<?, ?> baseDao);
}
