package com.qfedu.service;

import com.qfedu.entity.User;


public interface UserService {

    public User findOne(Integer idCard);

    public void addUser(User user);

    public void updateWrongNum(Integer idCard,Integer wrongNum);
}
