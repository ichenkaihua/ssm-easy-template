package com.github.ichenkaihua.test.web;

import org.junit.Test;
import org.springframework.http.MediaType;
import springfox.documentation.staticdocs.SwaggerResultHandler;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;

/**
 * Created by chenkh on 16-5-15.
 */
public class RestDocumentGenerator extends RestAssuredBaseTest {



    @Test
    public void generateSwaggerJson() {
        String outputDir = System.getProperty("io.springfox.staticdocs.outputDir");
        given().log().all()
                .webAppContextSetup(context)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .param("group", "user-api")
                .when()
                .get("/v2/api-docs")
                .then().log().headers().
                apply(SwaggerResultHandler.outputDirectory(outputDir).build());
    }
}
