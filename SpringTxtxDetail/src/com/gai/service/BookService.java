package com.gai.service;

import com.gai.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    /*结账，传入哪个用户买了哪本书
     * 事务细节：
     * isolation 事务隔离级别
     * propagation 事务传播行为
     * noRollbackFor 哪些异常，事务可以不回滚
     * noRollbackForClassName 传入全类名
     * rollbackFor 哪些异常事务需要回滚
     * rollbackForClassName
     * readOnly 事务只读，加快查询速度
     * timeout 超时，事务自动终止并回滚
     * */
    @Transactional(propagation = Propagation.REQUIRES_NEW, timeout = 3, readOnly = false, noRollbackFor = {ArithmeticException.class}, rollbackFor = {FileNotFoundException.class})
    public void checkOut(String username, String isbn) {
        //减库存
        bookDao.updateStock(isbn);
        int price = bookDao.getPrice(isbn);

        //减余额
        bookDao.updateBalance(username, price);
        //运行时异常，默认回滚
        //int i = 10 / 0;
        //编译时异常，默认不回滚
        //new FileInputStream("D://hh.a");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updatePrice(String isbn, int price) {
        bookDao.updatePrice(isbn, price);
        //int i = 10 / 0;
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public int getPrice(String isbn) {
        return bookDao.getPrice(isbn);
    }
}
