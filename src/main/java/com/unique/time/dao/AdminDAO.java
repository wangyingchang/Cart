package com.unique.time.dao;

import com.unique.time.model.Cartitem;
import com.unique.time.model.Goods;
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
public class AdminDAO {

    private final SessionFactory sessionFactory;
    @Autowired
    public AdminDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //管理员查询用户信息
    public List<TUser> queryUser(TUser tUser){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from TUser ");
        List<TUser>tUsers=(List<TUser>)query.list();
        return tUsers;
    }

    //管理员通过用户ID查询用户信息
    public List<TUser> queryUserById(TUser tUser){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from TUser where id='"+tUser.getId()+"'");
        List<TUser>tUsersById=(List<TUser>) query.list();
        return tUsersById;
    }

    //管理员查询购物车信息
    public List<Cartitem> queryCartitem(Cartitem cartitem){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Cartitem ");
        List<Cartitem>cartitems=(List<Cartitem>)query.list();
        return cartitems;
    }

    //管理员通过购物车ID查询购物车信息
    public List<Cartitem> queryCartitemById(Cartitem cartitem){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Cartitem where id='"+cartitem.getCartitemId()+"'");
        List<Cartitem>cartitemsById=(List<Cartitem>) query.list();
        return cartitemsById;
    }

    //管理员查询商品信息
    public List<Goods> queryGoods(Goods goods){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Goods ");
        List<Goods>goodss=(List<Goods>)query.list();
        return goodss;
    }

    //管理员通过商品ID查询商品信息
    public List<Goods> queryGoodsById(Goods goods){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Goods where gid='"+goods.getGid()+"'");
        List<Goods>GoodssById=(List<Goods>) query.list();
        return GoodssById;
    }

    //管理员删除用户信息
    public void deleteUser(int id){
        Session session=sessionFactory.getCurrentSession();
        TUser tUser=session.load(TUser.class,id);
        session.delete(tUser);
    }

    //管理员踢出购物车信息
    public void deleteCartitem(int cartitemId){
        Session session=sessionFactory.getCurrentSession();
        Cartitem cartitem=session.load(Cartitem.class,cartitemId);
        session.delete(cartitem);
    }

    //管理员删除商品信息
    public void deleteGoods(int gid){
        Session session=sessionFactory.getCurrentSession();
        Goods goods=session.load(Goods.class,gid);
        session.delete(goods);
    }

    //管理员添加用户信息
    public void addUser(TUser tUser){
        Session session=sessionFactory.getCurrentSession();
        session.save(tUser);
    }

    //管理员添加购物车信息
    public void addCartitem(Cartitem cartitem){
        Session session=sessionFactory.getCurrentSession();
        session.save(cartitem);
    }

    //管理员添加商品信息
    public void addGoods(Goods goods){
        Session session=sessionFactory.getCurrentSession();
        session.save(goods);
    }

    //管理员修改用户信息
    public boolean updateUser(TUser tUser){
        Session session=sessionFactory.getCurrentSession();
        TUser tUser1=session.get(TUser.class, tUser.getId());
        if(tUser1==null){
            return false;
        }else{
            tUser1.setUserName(tUser.getUserName());
            tUser1.setUserPwd(tUser.getUserPwd());
            tUser1.setUserEamil(tUser.getUserEamil());
            return true;
        }
    }

    //管理员修改购物车信息
    public boolean updateCartitem(Cartitem cartitem){
        Session session=sessionFactory.getCurrentSession();
        Cartitem cartitem1=session.get(Cartitem.class,cartitem.getCartitemId());
        if(cartitem1==null){
            return false;
        }else{
            cartitem1.setUid(cartitem.getUid());
            cartitem1.setGid(cartitem.getGid());
            cartitem1.setGname(cartitem.getGname());
            cartitem1.setGdesc(cartitem.getGdesc());
            return  true;
        }
    }


    //管理员修改商品信息
    public boolean updateGoods(Goods goods){
        Session session=sessionFactory.getCurrentSession();
        Goods goods1=session.get(Goods.class,goods.getGid());
        if(goods1==null){
            return false;
        }else{
            goods1.setGname(goods.getGname());
            goods1.setGprice(goods.getGprice());
            goods1.setGdesc(goods.getGdesc());
            goods1.setGsort(goods.getGsort());

            return true;
        }
    }

    //***获取查询商品的数据库条数
    public int goodsCount(){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Goods");
        int goodsCount=query.list().size();//获取数据库的条数
        return goodsCount;
    }

    //***带分页的查询商品信息
    public List<Goods> queryGoodsPaging(int begin,int limit){

        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Goods");
        query.setFirstResult(begin);//从第几行开始查询
        query.setMaxResults(limit);//查询多少行
        List<Goods>goodsList=(List<Goods>)query.list();
        if(goodsList!=null && goodsList.size()>0){
            return goodsList;
        }else {
            return null;
        }
    }

    //***获取购物车的数据库条数
    public int cartitemCount(){
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Cartitem ");
        int cartitemCount=query.list().size();//获取数据库的条数
        return cartitemCount;
    }

    //***带分页的查询购物车的执行方法
    public List<Cartitem> queryCartitemPaging(int begin,int limit){

        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Cartitem ");
        query.setFirstResult(begin);//从第几行开始查询
        query.setMaxResults(limit);//查询多少行
        List<Cartitem>cartitemList=(List<Cartitem>)query.list();
        if(cartitemList!=null && cartitemList.size()>0){
            return cartitemList;
        }else{
            return null;
        }
    }

}
