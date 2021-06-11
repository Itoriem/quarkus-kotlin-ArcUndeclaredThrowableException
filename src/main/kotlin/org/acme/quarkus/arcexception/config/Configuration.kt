package org.acme.quarkus.arcexception.config

import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class Configuration {

    @ConfigProperty(name = "application.name")
    lateinit var applicationName: String

    @ConfigProperty(name = "application.description")
    lateinit var applicationDescription: String

    @ConfigProperty(name = "application.version")
    lateinit var applicationVersion: String

}
