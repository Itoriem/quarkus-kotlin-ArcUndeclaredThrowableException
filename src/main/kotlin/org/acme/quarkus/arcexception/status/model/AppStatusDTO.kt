package org.acme.quarkus.arcexception.status.model

import javax.json.bind.annotation.JsonbProperty
import javax.json.bind.annotation.JsonbPropertyOrder
import javax.json.bind.annotation.JsonbTransient

@JsonbPropertyOrder(value = ["name", "status", "message", "version", "description", "components"])
class AppStatusDTO(
    @field:JsonbProperty("name") val name: String,
    @field:JsonbProperty("version") val version: String,
    @field:JsonbProperty("description") val description: String,
    @field:JsonbProperty("components") val components: Collection<PartnerAppStatusDTO>
) {

    @JsonbTransient
    val appStatus: AppStatus = if (allPartnersAreOk()) AppStatus.OK else AppStatus.KO

    @field:JsonbProperty("status")
    val status: String = appStatus.value

    @field:JsonbProperty("message")
    val message: String = if (allPartnersAreOk()) "Application is running" else "Application unavailable"

    private fun allPartnersAreOk(): Boolean {
        return components.all { it.appStatus == AppStatus.OK }
    }

}

