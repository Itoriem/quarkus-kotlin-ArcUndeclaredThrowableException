package org.acme.quarkus.arcexception.partner.exception

import org.acme.quarkus.arcexception.partner.model.PartnerErrorDTO
import javax.ws.rs.core.Response

open class PartnerException(message: String, cause: Throwable? = null) : Exception(message, cause)

class PartnerFunctionalException(message: String, response: Response? = null) : PartnerException(message) {

    private var partnerErrorDTO: PartnerErrorDTO? = if (response?.hasEntity() == true) response.readEntity(PartnerErrorDTO::class.java) else null

    override val message = message
        get() = partnerErrorDTO?.message ?: field
}

class PartnerUnknownEntityException : PartnerException("Unknown resource")
