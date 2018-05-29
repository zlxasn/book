package org.itzxs.serviceImpl;

import org.itzxs.dao.UserInformationMapper;
import org.itzxs.entity.UserInformation;
import org.itzxs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Itzxs on 2018/5/29.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInformationMapper userInformationMapper;

    @Override
    public UserInformation login(UserInformation userInformation) {
        return userInformationMapper.findUserByUserName_PassWord(userInformation);
    }
}
