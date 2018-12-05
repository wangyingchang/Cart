package com.unique.time.service;

import com.unique.time.dao.UserDAO;
import com.unique.time.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserDAO userDAO;
    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //用户登录
    @Transactional
    public List<TUser> login(TUser user) { return this.userDAO.login(user); }

    //管理员登录
    @Transactional
    public List<TUser> adminLogin(TUser user) { return this.userDAO.adminLogin(user); }

    //注册用户
    @Transactional
    public boolean rgUser(TUser user){ return this.userDAO.rgUser(user);}

    //修改用户密码
    @Transactional
    public boolean updateUserPwd(TUser user){
        return this.userDAO.updateUserPwd(user);
    }
}
