package com.gai.dao;

import com.gai.pojo.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao extends BaseDao<Book> {
    @Override
    public void save() {
        System.out.println("保存图书。。。");
    }
}
