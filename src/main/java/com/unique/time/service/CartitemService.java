package com.unique.time.service;

import com.unique.time.dao.CartitemDAO;
import com.unique.time.model.Cartitem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CartitemService {

    private final CartitemDAO cartitemDAO;
    public CartitemService(CartitemDAO cartitemDAO){this.cartitemDAO=cartitemDAO;}

    //用户购物车-查询
    @Transactional
    public List<Cartitem> queryCartitem(Cartitem cartitem){return this.cartitemDAO.queryCartitem(cartitem);}

    //用户购物车-删除
    @Transactional
    public void deleteCaritem(int id){ this.cartitemDAO.deleteCartitem(id); }

    //用户购物车-添加
    @Transactional
    public void addCartitem(Cartitem cartitem){ this.cartitemDAO.addCartitem(cartitem);}

}
