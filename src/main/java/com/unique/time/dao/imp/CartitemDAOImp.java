package com.unique.time.dao.imp;

import com.unique.time.dao.CartitemDAO;
import com.unique.time.dao.UserDAO;
import com.unique.time.model.Cartitem;

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
public class CartitemDAOImp implements CartitemDAO {

    private final SessionFactory sessionFactory;
    @Autowired
    public CartitemDAOImp(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}

    //用户购物车-查询
    public List<Cartitem> queryCartitem(Cartitem cartitem){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Cartitem where uid="+cartitem.getUid()+" ");
        List<Cartitem>cartitem1=(List<Cartitem>)query.list();
        return cartitem1;
    }

    //用户购物车-删除
    public void deleteCartitem(int cartitemId){
        Session session = sessionFactory.getCurrentSession();
        Cartitem cartitem = session.load(Cartitem.class,cartitemId);
        session.delete(cartitem);
    }

    //用户购物车-添加
    public void addCartitem(Cartitem cartitem) {
        Session session = sessionFactory.getCurrentSession();
        session.save(cartitem);
    }


}
