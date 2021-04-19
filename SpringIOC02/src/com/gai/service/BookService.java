package com.gai.service;

import com.gai.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookDao bookDao;

    public void save() {
        System.out.println("bookService正在保存图书");
        bookDao.savBook();
    }
}
