package com.github.ichenkaihua.test.unit;

import com.github.ichenkaihua.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chenkaihua on 15-8-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config-test.xml" })
@Rollback
@Transactional(transactionManager = "transactionManager")
public class BaseUnitTest {



    @Test
    public void emTest(){



    }




}
