package com.prueba1

class SubCategoria {

    static belongsTo = [ categoria : Categoria ]

    String subCategoria

    String toString() { return subCategoria }

    static constraints = {

        subCategoria subCategoria: true

    }
}
