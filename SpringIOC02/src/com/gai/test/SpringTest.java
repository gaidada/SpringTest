package com.gai.test;

import com.gai.servlet.BookServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {
    ApplicationContext ioc = null;

    @Autowired
    BookServlet bookServlet;

    @Test
    public void test1(){
        System.out.println(bookServlet);
    }
}
