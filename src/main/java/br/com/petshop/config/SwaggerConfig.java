package br.com.petshop.config;


import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("br.com.petshop.controller")).build();
////                .apiInfo(metaData()).protocols(protocols());
//    }
//
//    private Set<String> protocols() {
//        Set<String> protocols = new HashSet<>(1);
//        protocols.add("http");
//        return protocols;
//    }
//
//    private ApiInfo metaData() {
//        return new ApiInfoBuilder()
//                .title("Sistema de PetShop")
//                .description("Applications responsible to perform Petshop.")
//                .version("v1")
//                .license("Copyrights 2022 -  Todos os Direitos Reservados")
//                .licenseUrl("https://www.itemcontroll.com.br").build();
//    }

}
