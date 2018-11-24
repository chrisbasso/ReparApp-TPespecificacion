package com.prueba1

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoArregloController {

    TipoArregloService tipoArregloService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoArregloService.list(params), model:[tipoArregloCount: tipoArregloService.count()]
    }

    def show(Long id) {
        respond tipoArregloService.get(id)
    }

    def create() {
        respond new TipoArreglo(params)
    }

    def save(TipoArreglo tipoArreglo) {
        if (tipoArreglo == null) {
            notFound()
            return
        }

        try {
            tipoArregloService.save(tipoArreglo)
        } catch (ValidationException e) {
            respond tipoArreglo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tipoArreglo.label', default: 'TipoArreglo'), tipoArreglo.id])
                redirect tipoArreglo
            }
            '*' { respond tipoArreglo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond tipoArregloService.get(id)
    }

    def update(TipoArreglo tipoArreglo) {
        if (tipoArreglo == null) {
            notFound()
            return
        }

        try {
            tipoArregloService.save(tipoArreglo)
        } catch (ValidationException e) {
            respond tipoArreglo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoArreglo.label', default: 'TipoArreglo'), tipoArreglo.id])
                redirect tipoArreglo
            }
            '*'{ respond tipoArreglo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        tipoArregloService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoArreglo.label', default: 'TipoArreglo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoArreglo.label', default: 'TipoArreglo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
