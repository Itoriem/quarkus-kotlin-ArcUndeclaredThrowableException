package org.acme.quarkus.arcexception.status

import org.acme.quarkus.arcexception.config.Configuration
import org.acme.quarkus.arcexception.partner.PartnerApiService
import org.acme.quarkus.arcexception.partner.model.status.PartnerStatusApi
import org.acme.quarkus.arcexception.status.model.AppStatus
import org.acme.quarkus.arcexception.status.model.AppStatusDTO
import org.acme.quarkus.arcexception.status.model.PartnerAppStatusDTO
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.tags.Tag
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/api/v1/status")
class StatusResource {

    @Inject
    lateinit var configuration: Configuration

    @Inject
    lateinit var partnerApiService: PartnerApiService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Tag(name = "Status")
    @Operation(summary = "Fetch app status")
    fun appStatusWithPartners(): Response {
        val testDeViePartenaires = listOf(fetchPartnerAppStatus())
        val testDeVieDTO = AppStatusDTO(configuration.applicationName, configuration.applicationVersion, configuration.applicationDescription, testDeViePartenaires)
        if (AppStatus.OK == testDeVieDTO.appStatus) {
            return Response.ok(testDeVieDTO).build()
        }
        return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(testDeVieDTO).build()
    }

    private fun fetchPartnerAppStatus(): PartnerAppStatusDTO {
        val partnerStatusApi: PartnerStatusApi = partnerApiService.fetchAppStatus()
        return PartnerAppStatusDTO(partnerStatusApi.name, partnerStatusApi.description, AppStatus.fromValue(partnerStatusApi.status), partnerStatusApi.message)
    }

}
