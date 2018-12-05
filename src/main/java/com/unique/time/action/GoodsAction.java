package com.unique.time.action;

import com.opensymphony.xwork2.ActionSupport;
import com.unique.time.model.Goods;
import com.unique.time.service.GoodsService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GoodsAction extends ActionSupport implements SessionAware {
    private final GoodsService goodsService;
    private List<Goods>goods1;//衣-数据
    private List<Goods>goods2;//食-数据
    private List<Goods>goods3;//住-数据
    private List<Goods>goods4;//行-数据
    private Map<String,Object> session;

    private Goods goods;
    public Goods getGoods() {
        return goods;
    }
    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Autowired
    public GoodsAction(GoodsService goodsService){this.goodsService=goodsService;}

    //衣-查询
    public String queryClothes(){
        this.goods1=goodsService.queryClothes(goods);
        session.put("goods1list",goods1);
        if(goods1.size()>0) {
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    //食-查询
    public String queryFood(){
        this.goods2=goodsService.queryFood(goods);
        session.put("goods2list",goods2);
        if(goods2.size()>0) {
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    //住-查询
    public String queryLive(){
        this.goods3=goodsService.queryLive(goods);
        session.put("goods3list",goods3);
        if(goods3.size()>0){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    //行-查询
    public String queryTravel(){
        this.goods4=goodsService.queryTravel(goods);
        session.put("goods4list",goods4);
        if(goods4.size()>0){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
}
