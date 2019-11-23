package com.toughguy.transactionSystem.config;



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
 * 		生成接口文档api
 * @author Guozhenze
 *
 */
@Configuration
@EnableSwagger2 //启动Swagger2接口文档的拦截功能·生成接口api
public class SwaggerConfig {
    // Docket
    @Bean
    public Docket createDocket(){
        return new Docket(DocumentationType.SPRING_WEB.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.toughguy.transactionSystem.controller.content"))
                .paths(PathSelectors.any())
                .build();
    }
    /*
    创建该API的基本信息(这些基本信息会展现在文档页面中)
    访问地址：http://项目实际地址/swagger-ui.html
     */


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("SpringBoot利用swagger构建api文档")
                .description("简单优雅的restful风格")
                .version("1.0")
                .build();
    }


}
