package org.acme.quarkus.arcexception.status.model

enum class AppStatus(val value: String) {

    OK("ok"),
    KO("ko");

    companion object {
        fun fromValue(value: String): AppStatus {
            return valueOf(value.toUpperCase())
        }
    }
}
