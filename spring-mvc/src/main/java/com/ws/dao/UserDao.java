package com.ws.dao;

import com.ws.entity.User;

/**
 * Created by alvin on 2016/5/29.
 */
public interface UserDao {
    void createUser(User user);

    User showDetail(String userId);

    void deleteUser(String username);
}
