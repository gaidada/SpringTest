package com.gai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class MulService {
    private BookService bookService;

    public void mulTx() {
        bookService.checkOut("Tom", "ISDN001");

        bookService.updatePrice("ISDN002", 998);

    }
}
