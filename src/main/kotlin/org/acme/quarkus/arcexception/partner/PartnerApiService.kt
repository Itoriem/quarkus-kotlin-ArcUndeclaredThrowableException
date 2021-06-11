package org.acme.quarkus.arcexception.partner

import org.acme.quarkus.arcexception.partner.exception.PartnerException
import org.acme.quarkus.arcexception.partner.model.status.PartnerStatusApi
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.ws.rs.ProcessingException

@ApplicationScoped
class PartnerApiService {

    @Inject
    lateinit var serviceRegistry: org.acme.quarkus.arcexception.ServiceRegistry

    fun fetchAppStatus(): PartnerStatusApi {
        try {
            return serviceRegistry.partnerRestClient.appStatus().toPartnerStatusApi()
        } catch (exception: ProcessingException) {
            throw PartnerException("Error when retrieving partner status: : ${exception.message}", cause = exception)
        }
    }

}
