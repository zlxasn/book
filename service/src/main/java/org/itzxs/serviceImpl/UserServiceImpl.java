package org.itzxs.serviceImpl;

import org.itzxs.dao.UserInformationMapper;
import org.itzxs.entity.UserInformation;
import org.itzxs.service.UserService;
import org.itzxs.util.PasswordMasker;
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
        userInformation.setPassWord(PasswordMasker.mask(userInformation.getPassWord()));
        return userInformationMapper.findUserByUserName_PassWord(userInformation);
    }
    @Override
    public boolean register(UserInformation userInformation) {
        boolean flag = false;
        userInformation.setPassWord(PasswordMasker.mask(userInformation.getPassWord()));
        userInformation.setState("0");
        if(1 == userInformationMapper.insert(userInformation)){
            flag = true;
        }
        return flag;
    }

}
