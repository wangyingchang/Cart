package com.unique.time.service;

import com.unique.time.dao.GoodsDAO;
import com.unique.time.model.Goods;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class GoodsService {

    private final GoodsDAO goodsDAO;

    public GoodsService(GoodsDAO goodsDAO){this.goodsDAO=goodsDAO;}

    //衣-查询
    @Transactional
    public List<Goods> queryClothes(Goods goods){return this.goodsDAO.queryClothes(goods);}

    //食-查询
    @Transactional
    public List<Goods> queryFood(Goods goods){return this.goodsDAO.queryFood(goods);}

    //住-查询
    @Transactional
    public List<Goods> queryLive(Goods goods){return this.goodsDAO.queryLive(goods);}

    //行-查询
    @Transactional
    public List<Goods> queryTravel(Goods goods){return this.goodsDAO.queryTravel(goods);}
}
