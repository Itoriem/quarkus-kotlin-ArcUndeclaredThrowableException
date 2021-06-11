package org.acme.quarkus.arcexception.partner.model.status

import org.acme.quarkus.arcexception.status.model.AppStatus

data class PartnerStatusApi(
    val name: String,
    val status: String,
    val message: String?,
    val description: String
)

class AppStatusDTO(
    var name: String? = null,
    var status: String? = null,
    var message: String? = null,
    var description: String? = null
) {

    fun toPartnerStatusApi(message: String? = null): PartnerStatusApi {
        return PartnerStatusApi(
            name ?: "app-partner",
            status ?: AppStatus.KO.value,
            this.message ?: message,
            description ?: "Application partner"
        )
    }

}
