package com.prueba1

class Repuesto {

    String nombre
    String marca
    String modelo
    String anio
    double precio
    String descripcion

    static belongsTo = [ categoria : Categoria ]

    static constraints = {
        nombre nombre: true
        marca marca: true
        modelo modelo: true
        anio anio: true
        precio precio:true
        descripcion descripcion:true
        categoria categoria:true

    }
}