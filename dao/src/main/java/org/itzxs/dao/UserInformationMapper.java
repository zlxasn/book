package org.itzxs.dao;

import org.apache.ibatis.annotations.Param;
import org.itzxs.entity.UserInformation;

public interface UserInformationMapper {
    int insert(UserInformation record);

    int insertSelective(UserInformation record);

    UserInformation findUserByUserName_PassWord(@Param("userInformation") UserInformation userInformation);
}