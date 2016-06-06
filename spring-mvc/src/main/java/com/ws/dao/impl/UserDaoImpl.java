package com.ws.dao.impl;

import com.ws.dao.UserDao;
import com.ws.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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
        jdbcTemplate.update(sql,new Object[]{user.getUsername(),user.getPassword()});
    }

    @Override
    public User showDetail(String userId) {
        String sql = "select * from t_user where user_id = ? ";
        final User user = new User();
        jdbcTemplate.query(sql, new Object[]{userId}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUsername(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setCredits(resultSet.getInt("credits"));
                user.setLastIp(resultSet.getString("last_ip"));
                user.setLastVisit(resultSet.getDate("last_visit"));
            }
        });
        return user;
    }

    @Override
    public void deleteUser(String username) {
        String sql = "delete from t_user where user_name = ?";
        jdbcTemplate.update(sql,new Object[]{username});
    }
}
