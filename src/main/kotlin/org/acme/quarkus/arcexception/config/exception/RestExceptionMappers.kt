package org.acme.quarkus.arcexception.config.exception

import org.acme.quarkus.arcexception.partner.exception.PartnerException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.annotation.Priority
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
@Priority(1)
class PartnerExceptionMapper : ExceptionMapper<PartnerException> {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun toResponse(exception: PartnerException): Response {
        log.error("Partner has thrown an error: ${exception.message}")
        return Response.serverError().build()
    }
}

@Provider
@Priority(0)
class RestThrowableMapper : ExceptionMapper<Throwable> {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun toResponse(throwable: Throwable): Response {
        log.error("Throwable unhandled (${throwable::class.simpleName}): ${throwable.message}", throwable)
        return Response.serverError().build()
    }
}
