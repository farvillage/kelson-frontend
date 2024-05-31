package Api.com.farvillage.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Hospital API")
                        .version("v3")
                        .description("Api desenvolvida para sistema de consultas e exames medicos")
                        .termsOfService("")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://thestartlaw.com/termo-de-uso/")
                        )
                );
    }

}