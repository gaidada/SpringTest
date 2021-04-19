package com.gai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.BinaryOperator;

@Service
public class MulService {
    @Autowired
    private BookService bookService;

    @Transactional
    public void mulTx() {
        bookService.checkOut("Tom", "ISDN001");

        bookService.updatePrice("ISDN002", 998);

        int i = 10 / 0;
    }
}
