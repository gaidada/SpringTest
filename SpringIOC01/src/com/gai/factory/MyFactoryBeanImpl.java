package com.gai.factory;

import com.gai.bean.Book;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

//实现了FactoryBean接口的类是spring可以认识的工厂类
public class MyFactoryBeanImpl implements FactoryBean<Book> {
    //工厂方法,自动调用
    @Override
    public Book getObject() throws Exception {
        System.out.println("MyFactoryBeanImpl创建对象");
        Book book = new Book();
        book.setBookName(UUID.randomUUID().toString());
        return book;
    }

    //返回创建的对象的类型
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }
}
