package com.gai.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SourceTest {
    public static void main(String[] args) {
        ApplicationContext ioc = null;
        //ioc容器的创建
        ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Object bean = ioc.getBean("person3");
        System.out.println(bean);
    }
}
