package org.acme.quarkus.arcexception.partner

import org.acme.quarkus.arcexception.partner.exception.PartnerException
import org.acme.quarkus.arcexception.partner.exception.PartnerResponseExceptionMapper
import org.acme.quarkus.arcexception.partner.model.status.AppStatusDTO
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@RegisterRestClient(configKey = "app-partner-client")
@RegisterProvider(value = PartnerResponseExceptionMapper::class)
interface PartnerRestClient {

    @GET
    @Path("/api/v1/status")
    @Produces(MediaType.APPLICATION_JSON)
    @Throws(PartnerException::class)
    fun appStatus(): AppStatusDTO

}
