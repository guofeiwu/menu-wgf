package com.menu.wgf.config;

import com.google.common.collect.Ordering;
import com.menu.wgf.config.jwt.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @Author guofei_wu
 * @Date 2017/9/19 9:43
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig{

    @Autowired
    private JwtConfig jwtConfig;
    @Bean
    public Docket createRestApi(){

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                   .apiInfo(apiInfo())
                   .select()
                   .apis(RequestHandlerSelectors.basePackage("com.menu.wgf.controller"))
                   .paths(PathSelectors.any())
                   .build()
                  .securitySchemes(newArrayList(apiKey()))
                  .apiListingReferenceOrdering(new Ordering<ApiListingReference>() {
                    @Override
                    public int compare(ApiListingReference left, ApiListingReference right) {
                        return left.getPath().compareTo(right.getPath());
                    }
                });
        return docket;
    }
    /**
     * 设置右上角Authorize按钮
     *
     * @return
     */
    private ApiKey apiKey() {
        return new ApiKey(jwtConfig.getHeaderKey(), jwtConfig.getHeaderKey(), ApiKeyVehicle.HEADER.getValue());
    }


    public ApiInfo apiInfo(){
        return  new ApiInfoBuilder()
                .description("这个一个菜谱Api")
                .title("菜谱Api")
                .version("1.0")
                .contact(new Contact("吴国飞","www.menu.wgf.com","guofei_wu@163.com"))
                .build();
    }

}
