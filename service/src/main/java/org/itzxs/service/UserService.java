package org.itzxs.service;

import org.itzxs.entity.UserInformation;

/**
 * Created by Itzxs on 2018/5/29.
 */
public interface UserService {
    UserInformation login(UserInformation userInformation);
}
