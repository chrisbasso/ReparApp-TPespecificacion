package com.prueba1

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ArregloController {

    ArregloService arregloService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond arregloService.list(params), model:[arregloCount: arregloService.count()]
    }

    def show(Long id) {
        respond arregloService.get(id)
    }

    def create() {
        respond new Arreglo(params)
    }

    def save(Arreglo arreglo) {
        if (arreglo == null) {
            notFound()
            return
        }

        try {
            arregloService.save(arreglo)
        } catch (ValidationException e) {
            respond arreglo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'arreglo.label', default: 'Arreglo'), arreglo.id])
                redirect arreglo
            }
            '*' { respond arreglo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond arregloService.get(id)
    }

    def update(Arreglo arreglo) {
        if (arreglo == null) {
            notFound()
            return
        }

        try {
            arregloService.save(arreglo)
        } catch (ValidationException e) {
            respond arreglo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'arreglo.label', default: 'Arreglo'), arreglo.id])
                redirect arreglo
            }
            '*'{ respond arreglo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        arregloService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'arreglo.label', default: 'Arreglo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'arreglo.label', default: 'Arreglo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
