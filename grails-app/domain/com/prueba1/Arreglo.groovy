package com.prueba1

class Arreglo {

    static belongsTo = [ tipo : TipoArreglo ]
    String descripcion

    static constraints = {

        tipo tipo:true


    }
}
