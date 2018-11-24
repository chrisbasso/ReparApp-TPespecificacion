package com.prueba1

class Categoria {

    String categoria

    static hasMany = [ subCategoria : SubCategoria ]

    String toString() { return categoria }


    static constraints = {

        categoria categoria:true

    }
}
