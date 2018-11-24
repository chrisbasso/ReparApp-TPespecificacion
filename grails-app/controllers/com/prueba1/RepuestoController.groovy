package com.prueba1

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RepuestoController {

    RepuestoService repuestoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond repuestoService.list(params), model:[repuestoCount: repuestoService.count()]
    }

    def show(Long id) {
        respond repuestoService.get(id)
    }

    def create() {
        respond new Repuesto(params)
    }

    def save(Repuesto repuesto) {
        if (repuesto == null) {
            notFound()
            return
        }

        try {
            repuestoService.save(repuesto)
        } catch (ValidationException e) {
            respond repuesto.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'repuesto.label', default: 'Repuesto'), repuesto.id])
                redirect repuesto
            }
            '*' { respond repuesto, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond repuestoService.get(id)
    }

    def update(Repuesto repuesto) {
        if (repuesto == null) {
            notFound()
            return
        }

        try {
            repuestoService.save(repuesto)
        } catch (ValidationException e) {
            respond repuesto.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'repuesto.label', default: 'Repuesto'), repuesto.id])
                redirect repuesto
            }
            '*'{ respond repuesto, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        repuestoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'repuesto.label', default: 'Repuesto'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'repuesto.label', default: 'Repuesto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
