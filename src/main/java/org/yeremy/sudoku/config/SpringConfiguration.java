package org.yeremy.sudoku.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringConfiguration
{

    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/solve")
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo()
    {
        final ApiInfo apiInfo = new ApiInfo(
                "Sudoku Service REST API",
                "Yeremy's Sudoku Service.",
                "1",
                "yeremyturcios@gmai.com",
                "API License",
                "API License URL", null);
        return apiInfo;
    }

}
