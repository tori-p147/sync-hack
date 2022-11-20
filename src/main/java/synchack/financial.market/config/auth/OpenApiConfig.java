package synchack.financial.market.config.auth;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
  name = "basicAuth",
  type = SecuritySchemeType.HTTP,
  scheme = "basic"
)
@OpenAPIDefinition(
  info = @Info(
    title = "REST API documentation",
    version = "1.0",
    description = "credentials: user2@gmail.com / $2a$12$9tWrzyak6cuaEKc3M6jJ4e5TjzRn7.FjAzIK3yv5WqFt3P.oyOzEK<"
  ),
  security = @SecurityRequirement(name = "basicAuth")
)
public class OpenApiConfig {

  @Bean
  public GroupedOpenApi api() {
    return GroupedOpenApi.builder()
      .group("REST API")
      .pathsToMatch("/hakaton/v1/**")
      .build();
  }
}