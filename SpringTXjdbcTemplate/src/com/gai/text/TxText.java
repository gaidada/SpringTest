package com.gai.text;

import com.gai.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TxText {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);

    @Test
    public void text() throws SQLException {
        DataSource bean = ioc.getBean(DataSource.class);
        Connection connection = bean.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test1() {
        String sql = "UPDATE user_table\n" +
                "SET balance=?\n" +
                "WHERE `user`=?";
        int update = jdbcTemplate.update(sql, 1100, "AA");
        System.out.println(update);
    }

    /*批量插入*/
    @Test
    public void test2() {
        String sql = "INSERT INTO user_table(`user`,`password`,balance)VALUES(?,?,?)";
        //List的长度就是sql语句要执行的次数
        //Object[]一维数组，每次执行要用的参数
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"ABC", "ABC", 1000});
        batchArgs.add(new Object[]{"BCD", "BCD", 1000});
        batchArgs.add(new Object[]{"CDE", "CDE", 1000});
        int[] is = jdbcTemplate.batchUpdate(sql, batchArgs);
        for (int i : is) {
            System.out.println(i);
        }
    }

    /*查询单个记录，封装成Java对象*/
    @Test
    public void test3() {
        String sql = "SELECT * FROM user_table WHERE `user`=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), "AA");
        System.out.println(user);
    }

    /*查询，List集合返回*/
    @Test
    public void test4() {
        String sql = "SELECT * FROM user_table WHERE balance>=?";
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), 3000);
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void test5() {
        String sql = "SELECT MAX(balance) FROM user_table";
        Integer query = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(query);
    }

    /*以Map形式传入参数带有具名参数插入记录*/
    @Test
    public void test6() {
        String sql = "INSERT INTO user_table(`user`,`password`,balance)VALUES(:user,:password,:balance)";

        Map<String, Object> map = new HashMap<>();
        map.put("user", "QWE");
        map.put("password", "QWE");
        map.put("balance", 2000);
        int update = namedParameterJdbcTemplate.update(sql, map);
        System.out.println(update);
    }

    /*重复test6，*/
    @Test
    public void test7() {
        String sql = "INSERT INTO user_table(`user`,`password`,balance)VALUES(:user,:password,:balance)";
        User user = new User();
        user.setUser("RTY");
        user.setPassword("RTY");
        user.setBalance(1000);
        int update = namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
        System.out.println(update);
    }

}
