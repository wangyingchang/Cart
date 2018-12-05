package com.unique.time.dao;

import com.unique.time.model.Cartitem;
import java.util.List;

public interface CartitemDAO {

    //用户查询-购物车
    List<Cartitem> queryCartitem(Cartitem cartitem);

    //用户删除-购物车
    void deleteCartitem(int cartitemId);

    //用户添加-购物车
    void addCartitem(Cartitem cartitem);
}
