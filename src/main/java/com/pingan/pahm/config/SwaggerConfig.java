package com.pingan.pahm.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author GYB
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket MyApi(){
        return  new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                //.paths(PathSelectors.any())
                //去掉默认errorcontroller
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("perfomance")
                .description("績效接口集")
                .version("v1")
                .build();
    }

}
