package com.github.ichenkaihua.test.web;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;

/**
 * Created by chenkh on 16-5-15.
 */
@WebAppConfiguration
@Transactional(transactionManager = "transactionManager")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration("classpath:spring-config.xml"),
        @ContextConfiguration("classpath:spring-mvc-config.xml")
})
public class RestAssuredBaseTest {


    @Autowired
    protected WebApplicationContext context;

    @Rule
    public final JUnitRestDocumentation restDocumentation =
            new JUnitRestDocumentation("build/asciidoc");

    MockMvcBuilder mockMvcBuilder;


    @Before
    public void setUp() {
        mockMvcBuilder = MockMvcBuilders.webAppContextSetup(context)
                .apply(MockMvcRestDocumentation.documentationConfiguration(restDocumentation));
        standaloneSetup(mockMvcBuilder);
    }


    @Test
    public void emptyTest(){}





}
