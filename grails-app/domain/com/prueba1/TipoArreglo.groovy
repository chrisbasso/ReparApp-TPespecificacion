package com.prueba1

class TipoArreglo {

    String tipo
    static hasMany = [ repuestos : Repuesto ]

    String toString() { return tipo }

    static constraints = {

        tipo tipo:true
        repuestos repuestos:true
    }
}
