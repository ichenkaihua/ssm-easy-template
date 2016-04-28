package com.github.ichenkaihua.document;

import com.github.ichenkaihua.jopo.BaseResponse;
import com.github.ichenkaihua.model.User;
import com.google.common.base.Predicate;
import com.google.common.reflect.TypeResolver;
import org.apache.shiro.crypto.hash.HashService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.DocumentationContextBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Predicates.or;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

@Configuration
@EnableSwagger2 //Loads the spring beans required by the framework
public class MySwaggerConfig {


    private ApiInfo apiInfo() {
        Contact contact = new Contact("chenkaihua", "https://github.com/ichenkaihua/ssm-easy-template", "admin@chenkaihua.com");
        return new ApiInfoBuilder()
                .title("ssm_easy_template API接口")
                .description("SSM-Easy-Template 是一个J2Ee项目快速开发脚手架，" +
                        "集成了最常用的框架,适用于Restfull 架构风格Web Service接口开发。项目使用最灵活的构建工具-gradle" +
                        "，加入了常用的gradle插件(gretty,flydb，mybatis generator),。")
                .contact(contact)
                .version("2.0")
                .build();
    }

    private Predicate<String> userPaths() {
        return or(
                regex("/users.*")
        );
    }

    @Bean
    public Docket userApi() {
        Set<String> set = new HashSet<String>();

        com.fasterxml.classmate.TypeResolver typeResolver = new com.fasterxml.classmate.TypeResolver();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("user-api")
                .apiInfo(apiInfo())
                .select()
                .paths(userPaths())
                .build().useDefaultResponseMessages(false)
                .genericModelSubstitutes(BaseResponse.class)
                .forCodeGeneration(true)


                ;

        return docket;
    }

}