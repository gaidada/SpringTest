package com.gai.service;

import com.gai.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

public class BookService {
    @Autowired
    private BookDao bookDao;

    public void checkOut(String username, String isbn) {
        //减库存
        bookDao.updateStock(isbn);
        int price = bookDao.getPrice(isbn);

        //减余额
        bookDao.updateBalance(username, price);

//        int i =10/0;
    }

    public void updatePrice(String isbn, int price) {
        bookDao.updatePrice(isbn, price);
    }

    public int getPrice(String isbn) {
        return bookDao.getPrice(isbn);
    }
}
