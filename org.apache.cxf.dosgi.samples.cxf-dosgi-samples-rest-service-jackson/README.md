# CXF DOSGi example REST jackson

This is a variant of the REST example and shows how to switch to jackson.

In plain CXF we would need to do two things

- Set the bus property skip.default.json.provider.registration=true
- Add com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider as a JAXRS provider

In CXF-DOSGi we can set the bus property by using a special service property on out TaskResourceImpl.

We can also set the JacksonJaxbJsonProvider by creating a separate class that offers the provider as an Remote Service Admin intent. As a last step we must add the intent to the TaskResourceImpl using another service property.

curl --header "Accept:application/json" http://localhost:8080/cxf/tasks
curl --header "Accept:application/json" http://localhost:8080/cxf/tasks/1
curl --header "Accept:application/json" http://localhost:8080/cxf/tasks/2
The output of this application is "more correct" than samples-rest-service.
