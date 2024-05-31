package com.tfgserver.tfgserver.openapiconfig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info= @Info(
                title="TFG_SERVER",
                version = "1.0.0",
                description = "CRUDs del proyecto"
        )
)
public class OpenAPIConfig {

}
