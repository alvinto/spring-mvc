package com.ws.service.impl;

import com.ws.dao.UserDao;
import com.ws.entity.User;
import com.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alvin on 2016/5/29.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public User showDetail(String userId) {
        return userDao.showDetail(userId);
    }
}
