Spring Cloud Gateway:

1) Implementing service gateway using Spring Cloud Gateway with configuration in gateway-server.yml in the configuration server.

2) Registering gateway service to Eureka discovery service and mapping all services (checking all the mappings in http://localhost:8072/actuator/gateway/routes)

3) Created custom predicates in gateway-service.yml ( Having i.e http://localhost:8072/licensing-service/license/{organizationID} instead of http://localhost:8080/v1/organization/[organizationID}/license/ )

4) Created TrackingFilter/FilterUtils (PRE-FILTERS) classes in gateway service to automatically create and add correlation ID in the header after each HTTP request trough gateway endpoint.

5) Created UserContextFilter/UserContext/UserContextHolder/UserContextInterceptor for correlation ID propagation between microservices.

6) Created then response -filter class (POST-FILTER) to get all the info from the headers back to the client (correlation ID returned in the HTTP response). Checked it using Postman tool.
