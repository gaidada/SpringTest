package com.gai.text;

import com.gai.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx.xml");
        BookService bean = context.getBean(BookService.class);
        bean.checkOut("Tom","ISDN001");
    }
}
