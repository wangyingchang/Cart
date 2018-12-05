package com.unique.time.service;

import com.unique.time.bean.PageBean;
import com.unique.time.dao.AdminDAO;
import com.unique.time.model.Cartitem;
import com.unique.time.model.Goods;
import com.unique.time.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class AdminService {

    private final AdminDAO adminDAO;
    @Autowired
    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }


    //管理员查询用户信息
    @Transactional
    public List<TUser> queryUser(TUser tUser){return this.adminDAO.queryUser(tUser);}

    //管理员通过用户ID查询用户信息
    @Transactional
    public List<TUser> queryUserById(TUser tUser){return this.adminDAO.queryUserById(tUser);}

    //管理员查询购物车信息
    @Transactional
    public List<Cartitem> queryCartitem(Cartitem cartitem){return this.adminDAO.queryCartitem(cartitem);}

    //管理员通过购物车ID查询购物车信息
    @Transactional
    public List<Cartitem> queryCartitemById(Cartitem cartitem){return this.adminDAO.queryCartitemById(cartitem);}

    //管理员查询商品信息
    @Transactional
    public List<Goods> queryGoods(Goods goods){return this.adminDAO.queryGoods(goods);}

    //管理员通过商品ID查询商品信息
    @Transactional
    public List<Goods> queryGoodsById(Goods goods){return this.adminDAO.queryGoodsById(goods);}

    //管理员删除用户信息
    @Transactional
    public void deleteUser(int id){ this.adminDAO.deleteUser(id);}

    //管理员踢出购物车信息
    @Transactional
    public void deleteCartitem(int cartitemId){ this.adminDAO.deleteCartitem(cartitemId);}

    //管理员删除商品信息
    @Transactional
    public void deleteGoods(int gid){ this.adminDAO.deleteGoods(gid);}

    //管理员添加用户信息
    @Transactional
    public void addUser(TUser tUser){ this.adminDAO.addUser(tUser);}

    //管理员添加购物车信息
    @Transactional
    public void addCartitem(Cartitem cartitem){ this.adminDAO.addCartitem(cartitem);}

    //管理员添加商品信息
    @Transactional
    public void addGoods(Goods goods){ this.adminDAO.addGoods(goods);}

    //管理员修改用户信息
    @Transactional
    public boolean updateUser(TUser tUser){ return this.adminDAO.updateUser(tUser);}

    //管理员修改用户信息
    @Transactional
    public boolean updateCartitem(Cartitem cartitem){ return this.adminDAO.updateCartitem(cartitem);}

    //管理员修改商品信息
    @Transactional
    public boolean updateGoods(Goods goods){ return this.adminDAO.updateGoods(goods);}

    //***带分页的查询商品信息
    public PageBean<Goods> queryGoodsPaging(Integer page){

        PageBean<Goods> pageBean=new PageBean<Goods>();
        //设置当前页数
        pageBean.setPage(page);

        //设置每行显示记录数
        int limit=4;
        pageBean.setLimit(limit);

        //设置总记录条数
        int totalCount=adminDAO.goodsCount();//获取要查询的商品数据库条数
        pageBean.setTotalCount(totalCount);

        //设置总页数
        int totalPage;
        if(totalCount % limit==0){
            totalPage=totalCount/limit;
        }else{
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);

        //设置显示到页面的数据集合
        int begin=(page-1)*limit;
        List<Goods> list=adminDAO.queryGoodsPaging(begin,limit);
        pageBean.setList(list);

        return pageBean;
    }

    //***带分页的查询购物车信息
    public PageBean<Cartitem> queryCartitemPaging(Integer page){

        PageBean<Cartitem> pageBean=new PageBean<Cartitem>();
        //设置当前页数
        pageBean.setPage(page);

        //设置每行显示记录数
        int limit=4;
        pageBean.setLimit(limit);

        //设置总记录条数
        int totalCount=adminDAO.cartitemCount();//获取查询商品的数据库条数
        pageBean.setTotalCount(totalCount);

        //设置总页数
        int totalPage;
        if(totalCount % limit==0){
            totalPage=totalCount/limit;
        }else{
            totalPage=totalCount/limit+1;
        }
        pageBean.setTotalPage(totalPage);

        //设置显示到页面的数据集合
        int begin=(page-1)*limit;
        List<Cartitem> list=adminDAO.queryCartitemPaging(begin,limit);
        pageBean.setList(list);

        return pageBean;
    }
}
