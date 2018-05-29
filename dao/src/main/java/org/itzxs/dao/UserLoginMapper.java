package org.itzxs.dao;

import org.itzxs.entity.UserLogin;

public interface UserLoginMapper {
    int insert(UserLogin record);

    int insertSelective(UserLogin record);
}