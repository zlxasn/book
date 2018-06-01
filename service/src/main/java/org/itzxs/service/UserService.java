package org.itzxs.service;

import org.itzxs.entity.UserInformation;

import javax.xml.registry.infomodel.User;

/**
 * Created by Itzxs on 2018/5/29.
 */
public interface UserService {

    /**
     * 登录
     * @param userInformation
     * @return
     */
    UserInformation login(UserInformation userInformation);

    /**
     * 注册
     * @param userInformation
     * @return
     */
    boolean register(UserInformation userInformation);
}
