package com.unique.time.dao.imp;

import com.unique.time.dao.GoodsDAO;
import com.unique.time.model.Goods;
import com.unique.time.service.GoodsService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GoodsDAOImp implements GoodsDAO {

    private final SessionFactory sessionFactory;
    @Autowired
    public GoodsDAOImp(SessionFactory sessionFactory){this.sessionFactory=sessionFactory;}

    //衣-查询
    public List<Goods> queryClothes(Goods goods){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Goods where gsort='clothes' ");
        List<Goods>goods1=(List<Goods>)query.list();
        return goods1;
    }

    //食-查询
    public List<Goods> queryFood(Goods goods){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Goods where gsort='food' ");
        List<Goods>goods2=(List<Goods>)query.list();
        return goods2;
    }


    //住-查询
    public List<Goods> queryLive(Goods goods){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Goods where gsort='live' ");
        List<Goods>goods3=(List<Goods>)query.list();
        return goods3;
    }

    //行-查询
    public List<Goods> queryTravel(Goods goods){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Goods where gsort='travel'");
        List<Goods>goods4=(List<Goods>)query.list();
        return goods4;
    }
}
