package com.gai.test;

import com.gai.bean.AirPlane;
import com.gai.bean.Book;
import com.gai.bean.Car;
import com.gai.bean.Person;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MyTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
    ApplicationContext ioc2 = new ClassPathXmlApplicationContext("ioc2.xml");
    ApplicationContext ioc3 = new ClassPathXmlApplicationContext("ioc3.xml");
    ConfigurableApplicationContext ioc4 = new ClassPathXmlApplicationContext("applicationContext.xml");
    ConfigurableApplicationContext ioc5 = new ClassPathXmlApplicationContext("applicationContext02.xml");
    ConfigurableApplicationContext ioc6 = new ClassPathXmlApplicationContext("applicationContext03.xml");


    @Test
    public void test1() {

        Person bean = (Person) ioc.getBean("person1");
        System.out.println(bean);
    }

    //实验2 根据bean的类型从IOC容器中获取bean的实例
    @Test
    public void test2() {
        Person bean = ioc.getBean("person06", Person.class);
        System.out.println(bean);
    }

    @Test
    public void test4() {
        Person bean = ioc2.getBean("person01", Person.class);
        System.out.println(bean);
        Car car = bean.getCar();
        Car car1 = ioc2.getBean("car01", Car.class);
        System.out.println(car == car1);
    }

    @Test
    public void test5() {
        Person person02 = ioc2.getBean("person02", Person.class);
        List<Book> books = person02.getBooks();
        System.out.println(books);

        Map<String, Object> maps = person02.getMaps();
        System.out.println(maps);

        Properties properties = person02.getProperties();
        System.out.println(properties);
    }


    @Test
    public void test6() {
        Person person03 = ioc2.getBean("person03", Person.class);
        System.out.println(person03);

        Person person04 = ioc2.getBean("person04", Person.class);
        Car car01 = ioc2.getBean("car01", Car.class);
        System.out.println(car01);
        System.out.println(person04.getCar());
    }

    @Test
    public void test7() {
        Person person06 = ioc2.getBean("person06", Person.class);
        System.out.println(person06);
    }

    @Test
    public void test8() {
        Book book = ioc3.getBean("book", Book.class);
        Book book1 = ioc3.getBean("book", Book.class);
        System.out.println(book == book1);
    }

    @Test
    public void test9() {
        AirPlane airPlane01 = ioc3.getBean("airPlane01", AirPlane.class);
        AirPlane airPlane02 = ioc3.getBean("airPlane02", AirPlane.class);
        System.out.println(airPlane01);
        System.out.println(airPlane02);
    }

    @Test
    public void test10() {
        Object bean = ioc3.getBean("myFactoryBean");
        System.out.println(bean);
    }

    @Test
    public void test11() throws SQLException {
        Book bean = ioc4.getBean("book01", Book.class);
       ioc4.close();
        DataSource dataSource = ioc5.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    //测试基于xml自动装配
    @Test
    public void test12() {
        Person per = ioc6.getBean("person2",Person.class);
        System.out.println(per);
    }

}
