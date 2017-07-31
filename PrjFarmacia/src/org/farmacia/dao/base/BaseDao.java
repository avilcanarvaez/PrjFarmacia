/**
* Resumen.
* Objeto                    :     BaseDao.java
* Descripcion               :     Creacion de  BaseDao..
* Fecha de Creacion         :    30/07/2017
* Autor                     :    Alexander Vilca
* ===========================================================================================================================
* Modificaciones
* Motivo             Fecha             Nombre                            Descripcion
* ===========================================================================================================================
**/

package org.farmacia.dao.base;

import java.util.List;

public interface BaseDao<E, ID> {

	void insertar(E entidad);

	void actualizar(E entidad);

	void eliminar(E entidad);

	E obtener(ID id);

	List<E> listar();
}
