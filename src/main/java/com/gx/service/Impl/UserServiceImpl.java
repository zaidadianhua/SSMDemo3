package com.gx.service.Impl;

import com.gx.dao.Userdao;
import com.gx.domain.User;
import com.gx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private Userdao userdao;
    @Override
    public User login(int uname, int upwd) {
        return userdao.login(uname,upwd);
    }
}
