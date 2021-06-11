package org.acme.quarkus.arcexception.partner.exception

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.ws.rs.core.Response
import javax.ws.rs.ext.Provider

@Provider
class PartnerResponseExceptionMapper : ResponseExceptionMapper<PartnerException> {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    override fun toThrowable(response: Response?): PartnerException {
        val responseStatus = response?.status
        log.warn("Partner has return an error code: $responseStatus")
        return when (responseStatus) {
            404 -> PartnerUnknownEntityException()
            422 -> PartnerFunctionalException("Fonctional error", response)
            else -> PartnerException("Partner return response with http code $responseStatus")
        }
    }
}
