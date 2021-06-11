package org.acme.quarkus.arcexception

import org.acme.quarkus.arcexception.partner.PartnerRestClient
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class ServiceRegistry {

    @Inject
    @field:RestClient
    lateinit var partnerRestClient: PartnerRestClient

}
