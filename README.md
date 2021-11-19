# quarkus-kotlin-ArcUndeclaredThrowableException

## Reproduce the problem:

1. Start application with `mvnw compile quarkus:dev`

2. Call the fallowing address with GET request: `http://localhost:9090/api/v1/status`

3. You should find the following trace in your console: 
```
[org.acme.quarkus.arcexception.config.exception.RestThrowableMapper:30] - Throwable unhandled (ArcUndeclaredThrowableException): Error invoking subclass method: io.quarkus.arc.ArcUndeclaredThrowableException: Error invoking subclass method
        at org.acme.quarkus.arcexception.partner.PartnerApiService_Subclass.fetchAppStatus(PartnerApiService_Subclass.zig:332)
        at org.acme.quarkus.arcexception.partner.PartnerApiService_ClientProxy.fetchAppStatus(PartnerApiService_ClientProxy.zig:215)
        at org.acme.quarkus.arcexception.status.StatusResource.fetchPartnerAppStatus(StatusResource.kt:41)
        at org.acme.quarkus.arcexception.status.StatusResource.appStatusWithPartners(StatusResource.kt:32)
        at org.acme.quarkus.arcexception.status.StatusResource_Subclass.appStatusWithPartners$$superforward1(StatusResource_Subclass.zig:217)
        at org.acme.quarkus.arcexception.status.StatusResource_Subclass$$function$$1.apply(StatusResource_Subclass$$function$$1.zig:24)
        at io.quarkus.arc.impl.AroundInvokeInvocationContext.proceed(AroundInvokeInvocationContext.java:54) 
        ...
```
