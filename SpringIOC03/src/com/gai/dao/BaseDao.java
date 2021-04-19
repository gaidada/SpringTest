package com.gai.dao;

import org.springframework.stereotype.Repository;

//定义了基本的增删改方法

public abstract class BaseDao<T> {

    public abstract void save();
}
