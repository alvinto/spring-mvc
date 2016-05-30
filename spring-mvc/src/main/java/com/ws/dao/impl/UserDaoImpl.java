package com.ws.dao.impl;

import com.ws.dao.UserDao;
import com.ws.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by alvin on 2016/5/29.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(User user) {
        String sql = "insert into t_user (user_name,password) values(?,?)";
        jdbcTemplate.update(sql,new Object[]{user.getUserName(),user.getPassword()});
    }
}
