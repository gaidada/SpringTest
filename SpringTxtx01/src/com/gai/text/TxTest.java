package com.gai.text;

import com.gai.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TxTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");

    @Test
    public void test1(){
        BookService bookService = ioc.getBean(BookService.class);
        bookService.checkOut("Tom","ISDN001");
        System.out.println("结账完成");
    }
}
