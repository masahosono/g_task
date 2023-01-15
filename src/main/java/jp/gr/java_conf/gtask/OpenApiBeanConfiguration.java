package jp.gr.java_conf.gtask;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiBeanConfiguration {

    @Bean
    public OpenAPI restApi() {
        return new OpenAPI();
    }
}
