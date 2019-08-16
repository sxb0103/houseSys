package com.qfedu.service.Impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User findOne(Integer idCard) {

        return userDao.findOne(idCard);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateWrongNum(Integer idCard, Integer wrongNum) {
        userDao.updateWrongNum(idCard,wrongNum);
    }
}
