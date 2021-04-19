package com.gai.text;

import com.gai.service.BookService;
import com.gai.service.MulService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

public class TxTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("tx.xml");

    /*有事务的业务逻辑，容器中保存的是这个业务逻辑的代理对象*/
    @Test
    public void test1() throws FileNotFoundException {
        BookService bookService = ioc.getBean(BookService.class);
        bookService.checkOut("Tom", "ISDN001");
        //System.out.println(bookService.getPrice("ISDN001"));
        System.out.println(bookService.getClass());
    }

    @Test
    public void test2() {
        MulService mulService = ioc.getBean(MulService.class);

        mulService.mulTx();
    }
}
