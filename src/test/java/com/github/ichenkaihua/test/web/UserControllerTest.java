package com.github.ichenkaihua.test.web;

import com.github.ichenkaihua.model.User;
import com.jayway.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.Assert.assertEquals;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

/**
 * Created by chenkh on 16-5-15.
 */
public class UserControllerTest extends RestAssuredBaseTest {


    @Test
    public void testGetAllUsers(){
        given()
                .log().all()
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .when()
                .get("/users")
                .then().log().all()
                .apply(document("获取所有用户",preprocessResponse(prettyPrint())))
                .assertThat().statusCode(200);
    }

    @Test
    public void testGetUserById(){
        MockMvcResponse mockMvcResponse = given().log().all()
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .when()
                .get("users/{id}", 1);

        mockMvcResponse
                .then().log().all()
               .apply(document("根据id获取用户信息,不包含密码", preprocessResponse(prettyPrint())))
                .assertThat()
                .statusCode(200);
        User user = mockMvcResponse.as(User.class);
        assertEquals(1,user.getId().intValue());
    }


}
