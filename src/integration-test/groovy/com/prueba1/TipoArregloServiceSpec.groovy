package com.prueba1

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TipoArregloServiceSpec extends Specification {

    TipoArregloService tipoArregloService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TipoArreglo(...).save(flush: true, failOnError: true)
        //new TipoArreglo(...).save(flush: true, failOnError: true)
        //TipoArreglo tipoArreglo = new TipoArreglo(...).save(flush: true, failOnError: true)
        //new TipoArreglo(...).save(flush: true, failOnError: true)
        //new TipoArreglo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tipoArreglo.id
    }

    void "test get"() {
        setupData()

        expect:
        tipoArregloService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TipoArreglo> tipoArregloList = tipoArregloService.list(max: 2, offset: 2)

        then:
        tipoArregloList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tipoArregloService.count() == 5
    }

    void "test delete"() {
        Long tipoArregloId = setupData()

        expect:
        tipoArregloService.count() == 5

        when:
        tipoArregloService.delete(tipoArregloId)
        sessionFactory.currentSession.flush()

        then:
        tipoArregloService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TipoArreglo tipoArreglo = new TipoArreglo()
        tipoArregloService.save(tipoArreglo)

        then:
        tipoArreglo.id != null
    }
}
