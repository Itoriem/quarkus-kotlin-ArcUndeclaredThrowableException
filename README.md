# quarkus-kotlin-ArcUndeclaredThrowableException

## Reproduce the problem:

1. Start application with `mvnw compile quarkus:dev`

2. Call the fallowing address with GET request: `http://localhost:9090/api/v1/status`

3. You should find the following trace in your console: 
```
2021-06-11 18:13:29,209 | ERROR | executor-thread-1 | [org.acme.quarkus.arcexception.config.exception.RestThrowableMapper:30] - Throwable unhandled (ArcUndeclaredThrowableException): Error invoking subclass method: io.quarkus.arc.ArcUndeclaredThrowableException: Error invoking subclass method
	at org.acme.quarkus.arcexception.partner.PartnerApiService_Subclass.fetchAppStatus(PartnerApiService_Subclass.zig:441)
	at org.acme.quarkus.arcexception.partner.PartnerApiService_ClientProxy.fetchAppStatus(PartnerApiService_ClientProxy.zig:215)
	at org.acme.quarkus.arcexception.status.StatusResource.fetchPartnerAppStatus(StatusResource.kt:41)
	...
```
