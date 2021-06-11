package org.acme.quarkus.arcexception.status.model

import javax.json.bind.annotation.JsonbPropertyOrder
import javax.json.bind.annotation.JsonbTransient

@JsonbPropertyOrder(value = ["name", "description", "status", "message"])
class PartnerAppStatusDTO(val name: String,
                          val description: String,
                          @JsonbTransient val appStatus: AppStatus,
                          val message: String?) {

    val status: String = appStatus.value

}
