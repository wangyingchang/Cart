package com.unique.time.action;

import com.opensymphony.xwork2.ActionSupport;
import com.unique.time.model.TUser;
import com.unique.time.service.UserService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserAction extends ActionSupport implements SessionAware {

    private final UserService userService;
    private List<TUser>tUser1;//用户登录数据查询
    private List<TUser>tUser2;//管理员登录数据查询
    private Map<String,Object> session;
    @Autowired
    public UserAction(UserService userService) {
        this.userService = userService;
    }
    private TUser user;
    public TUser getUser() {
        return user;
    }
    public void setUser(TUser user) {
        this.user = user;
    }

    private String message;//登录返回提示信息
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    private String message1;//注册返回提示信息
    public String getMessage1() { return message1; }
    public void setMessage1(String message1) { this.message1 = message1; }

    //登录
    public String login(){
        int role=user.getUserRole();
        if(role==1) { //用户
            this.tUser1 = userService.login(user);
            session.put("tUser1list", tUser1);
            if (tUser1.size() == 1) {
                return "user";
            }else {
                this.setMessage("亲,用户名或密码错误！");
                return ERROR;
            }
        }else if(role==2){//管理员
            this.tUser2= userService.adminLogin(user);
            if (tUser2.size() == 1) {
                return "admin";
            }else {
                this.setMessage("亲,用户名或密码错误！");
                return ERROR;
            }
        }else {
            this.setMessage("亲,用户名或密码错误！");
            return ERROR;
        }
    }

    //注册用户
    public String rgUser(){
        if(userService.rgUser(user)) {
            return SUCCESS;
        }else{
            this.setMessage1("亲,用户名已存在！");
            return ERROR;
        }
    }

    //修改用户密码
    public String updateUserPwd(){
        boolean b=userService.updateUserPwd(user);
        if(b){
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
}