package com.gai.service;

import com.gai.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    @Transactional
    /*结账，传入哪个用户买了哪本书*/
    public void checkOut(String username, String isbn) {
        //减库存
        bookDao.updateStock(isbn);
        int price = bookDao.getPrice(isbn);
        //减余额
        bookDao.updateBalance(username, price);
    }
}
