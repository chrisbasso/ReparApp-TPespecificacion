package com.prueba1

import grails.gorm.services.Service

@Service(TipoArreglo)
interface TipoArregloService {

    TipoArreglo get(Serializable id)

    List<TipoArreglo> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoArreglo save(TipoArreglo tipoArreglo)

}