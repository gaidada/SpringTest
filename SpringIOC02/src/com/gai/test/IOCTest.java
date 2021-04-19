package com.gai.test;

import com.gai.dao.BookDao;
import com.gai.servlet.BookServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test1() {
        BookDao bean = ioc.getBean("bookdao", BookDao.class);
        BookDao bean1 = ioc.getBean("bookdao", BookDao.class);
        System.out.println(bean == bean1);
    }

    @Test
    public void test2(){
        BookServlet bookServlet = ioc.getBean(BookServlet.class);
        bookServlet.doGet();
    }
}
