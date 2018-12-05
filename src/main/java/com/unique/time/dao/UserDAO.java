package com.unique.time.dao;

import com.unique.time.model.TUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAO {

    private final SessionFactory sessionFactory;
    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    //用户登录
    public List<TUser> login(TUser user) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from TUser where userName='"+user.getUserName()+"' and userPwd='"+user.getUserPwd()+"' and userRole=1");
        List<TUser>tUser1=(List<TUser>)query.list();
        return tUser1;
    }

    //管理员登录
    public List<TUser> adminLogin(TUser user) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from TUser where userName='"+user.getUserName()+"' and userPwd='"+user.getUserPwd()+"' and userRole=2");
        List<TUser>tUser2=(List<TUser>)query.list();
        return tUser2;
    }

    //注册用户
    public boolean rgUser(TUser user){
        Session session=sessionFactory.getCurrentSession();
        //查询用户是否存在
        Query query=session.createQuery("from TUser where userName='"+user.getUserName()+"'");
        List<TUser>tUsers=(List<TUser>)query.list();
        System.out.println(tUsers.size());
        if(tUsers.size()==0) {//用户不存在
            session.save(user);
            return true;
        }else{
            return false;
        }
    }

    //修改用户密码
    public boolean updateUserPwd(TUser user) {
        Session session = sessionFactory.getCurrentSession();
        TUser tUser1=session.get(TUser.class,user.getId());
        if(tUser1!=null){
                tUser1.setUserPwd(user.getUserPwd());
                return true;
        }
        else {
            return false;
        }
    }
}
