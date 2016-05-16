package com.github.ichenkaihua.test.web;

import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.UserService;
import com.github.ichenkaihua.utils.RandomUtils;
import com.jayway.restassured.module.mockmvc.response.MockMvcResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.Assert.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

/**
 * Created by chenkh on 16-5-15.
 */
public class UserControllerTest extends RestAssuredBaseTest {


    @Autowired
    UserService userService;

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


    private User randomUser(){
        User user = new User();
        user.setName(RandomUtils.randomString(7));
        user.setPassword(RandomUtils.randomString(10));
        return user;

    }


    private User inserRandomUser(){
        User user = randomUser();
        userService.addUser(user);
        return user;
    }



    @Test
    public void testAddUser(){
        User user = randomUser();
        MockMvcResponse mockMvcResponse = given()
                .body(user)
                .log().all()
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .when()
                .post("/users");
        mockMvcResponse
                .then()
                .log().all()
        .apply(document("添加用户,会忽略id，用于自动创建", preprocessResponse(prettyPrint())))
                .assertThat().statusCode(201);
        User responUser = mockMvcResponse.as(User.class);

        assertNotNull(responUser.getId());
        User queryUser = userService.getUserById(responUser.getId());
        assertNotNull(queryUser);
        assertEqualsUser(responUser,queryUser);
    }


    public void assertEqualsUser(User expectedUser,User actualUser){
        assertNotNull(expectedUser);
        assertNotNull(actualUser);
        assertEquals(expectedUser.getId(),actualUser.getId());
        assertEquals(expectedUser.getName(),actualUser.getName());
        assertEquals(expectedUser.getPassword(),actualUser.getPassword());
    }



    @Test
    public void testUpdateUserInfo(){
        User user = inserRandomUser();
        String randomName = RandomUtils.randomString(10);
        User updateUser = new User();
        updateUser.setId(user.getId());
        updateUser.setName(randomName);
        MockMvcResponse put = given()
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .body(updateUser)
                .when()
                .put("users/{id}", user.getId());
        put
                .then().assertThat().statusCode(200)
        .apply(document("更新用户的基本信息"));
        User queryUser = userService.getUserById(user.getId());
        assertNotNull(queryUser);
        assertEquals(updateUser.getName(),queryUser.getName());
    }



    @Test
    public void testGetUserById(){
        User user = inserRandomUser();
        MockMvcResponse mockMvcResponse = given().log().all()
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .when()
                .get("users/{id}", user.getId());

        mockMvcResponse
                .then().log().all()
               .apply(document("根据id获取用户信息,不包含密码", preprocessResponse(prettyPrint())))
                .assertThat()
                .statusCode(200);
        User queryUser = mockMvcResponse.as(User.class);
        assertEqualsUser(user,queryUser);
    }


    @Test
    public void testDeleteById(){
        User user = inserRandomUser();
        given()
                .log().all()
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .when()
                .delete("/users/{id}",user.getId())
                .then()
                .log().all()
                .apply(document("删除指定用户的id",preprocessResponse(prettyPrint())))
                .assertThat().statusCode(200);
        assertNull(userService.getUserById(user.getId()));
    }


}
