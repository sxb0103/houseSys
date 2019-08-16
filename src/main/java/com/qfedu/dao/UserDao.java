package com.qfedu.dao;

import com.qfedu.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    public User findOne(Integer idCard);

    public void addUser(User user);

    public void updateWrongNum(@Param("idCard") Integer idCard, @Param("wrongNum") Integer wrongNum);

}
