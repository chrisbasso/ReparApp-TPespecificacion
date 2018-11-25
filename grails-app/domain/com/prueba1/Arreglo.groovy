package com.prueba1

class Arreglo {

    static belongsTo = [ tipo : TipoArreglo ]
    static hasMany = [ repuestos : Repuesto, solicitudes: Solicitud ]
    String descripcion
    double precio = calcularPrecio()

    String toString() { return descripcion }

    static constraints = {

        tipo tipo:true
        descripcion descripcion:true

    }

    private double calcularPrecio(){
        double result = 0
        repuestos.each {repuesto ->
            result += repuesto.getPrecio()
        }
        return result
    }
}
