package com.unique.time.action;

import com.opensymphony.xwork2.ActionSupport;
import com.unique.time.model.Cartitem;
import com.unique.time.model.TUser;
import com.unique.time.service.CartitemService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CartitemAction extends ActionSupport implements SessionAware {

    private final CartitemService cartitemService;
    private List<Cartitem> cartitem1;//购物车-数据
    private Map<String,Object> session;

    private Cartitem cartitem;
    public Cartitem getCartitem() {
        return cartitem;
    }
    public void setCartitem(Cartitem cartitem) {
        this.cartitem = cartitem;
    }

    @Autowired
    public CartitemAction(CartitemService cartitemService){this.cartitemService=cartitemService;}

    //用户购物车-查询
    public String queryCartitem(){
        System.out.println("aa");
        this.cartitem1=cartitemService.queryCartitem(cartitem);
        session.put("cartitems1list",cartitem1);
        if(cartitem1.size()>0) {
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    //用户购物车-删除
    public String deleteCartitem() {
        cartitemService.deleteCaritem(cartitem.getCartitemId());
        queryCartitem();//删除后-刷新
        return SUCCESS;
    }

    //用户购物车-添加
    public String addCartitem(){
        cartitemService.addCartitem(cartitem);
        queryCartitem();//添加后-刷新
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
}
