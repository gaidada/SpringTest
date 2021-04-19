package com.gai.servlet;

import com.gai.dao.BookDao;
import com.gai.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class BookServlet {

    //属性的自动注入
    //指定一个名作为id，让spring别使用变量名为id
    @Qualifier("bookService")
    @Autowired(required = false)
    private BookService bookService;

    public void doGet() {
        bookService.save();
    }

    //方法上的Autowired注解，这个方法上的每一个参数都会自动注入值
    @Autowired
    public void haha(BookDao bookDao, @Qualifier("bookService") BookService bookService) {
        System.out.println("spring运行了哈哈" + bookDao + bookService);
    }
}
