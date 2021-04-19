package com.gai.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("bookdao")
@Scope(value = "prototype")
public class BookDao {

    public void savBook() {
        System.out.println("图书已经保存");
    }
}
