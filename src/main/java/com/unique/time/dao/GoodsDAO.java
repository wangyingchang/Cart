package com.unique.time.dao;

import com.unique.time.model.Goods;
import java.util.List;

public interface GoodsDAO {

    //查询商品 衣-类
    List<Goods> queryClothes(Goods goods);
    //查询商品 食-类
    List<Goods> queryFood(Goods goods);
    //查询商品 住-类
    List<Goods> queryLive(Goods goods);
    //查询商品 行-类
    List<Goods> queryTravel(Goods goods);
}
