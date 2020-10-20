package eu.hammarback.api

import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.core.Response

@Path("/")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
class ExampleResource() {

  @GET
  fun default(): Response {

    val entity = mapOf(
        "java.version" to System.getProperty("java.version"),
        "java.runtime.name" to System.getProperty("java.runtime.name")
    )

    return Response.ok().entity(entity).build()
  }

}
