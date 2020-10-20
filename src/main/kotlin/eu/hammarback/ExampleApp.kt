package eu.hammarback

import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT
import eu.hammarback.api.ExampleResource
import io.dropwizard.Application
import io.dropwizard.setup.Environment

class ExampleApp : Application<ExampleAppConfig>() {

  override fun run(config: ExampleAppConfig, env: Environment) {
    env.objectMapper.disable(FAIL_ON_UNKNOWN_PROPERTIES).enable(INDENT_OUTPUT).setSerializationInclusion(NON_NULL)
    env.jersey().register(ExampleResource())
  }

  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      ExampleApp().run(*args)
    }
  }

}
