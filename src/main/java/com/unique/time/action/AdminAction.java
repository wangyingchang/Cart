package com.unique.time.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.unique.time.bean.PageBean;
import com.unique.time.model.Cartitem;
import com.unique.time.model.Goods;
import com.unique.time.model.TUser;
import com.unique.time.service.AdminService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class AdminAction extends ActionSupport implements SessionAware {

    private final AdminService adminService;
    private Map<String,Object> session;
    private List<TUser> tUsers;//存储管理员查询用户信息
    private List<Cartitem> cartitems;//存储管理员查询购物车信息
    private List<Goods> goodss;//存储管理员查询商品信息
    private List<TUser> tUsersById;//存储通过用户Id查询用户信息
    private List<Cartitem> cartitemsById;//存储通过购物车Id查询购物车信息
    private List<Goods> goodssById;//存储通过商品Id查询购物车信息

    private String userAll;//存储前端获取得到要批量删除的用户ID
    public String getUserAll() {
        return userAll;
    }
    public void setUserAll(String userAll) { this.userAll = userAll; }

    private String cartitemAll;//存储前端获取得到要批量删除的购物车ID
    public String getCartitemAll() { return cartitemAll; }
    public void setCartitemAll(String cartitemAll) { this.cartitemAll = cartitemAll; }

    private String goodsAll;//存储前端获取得到要批量删除的商品ID
    public String getGoodsAll() { return goodsAll; }
    public void setGoodsAll(String goodsAll) { this.goodsAll = goodsAll; }

    @Autowired
    public AdminAction(AdminService adminService) {
        this.adminService = adminService;
    }

    private TUser user;
    public TUser getUser() { return user; }
    public void setUser(TUser user) { this.user = user; }

    private Cartitem cartitem;
    public Cartitem getCartitem() { return cartitem; }
    public void setCartitem(Cartitem cartitem) { this.cartitem = cartitem; }

    private Goods goods;
    public Goods getGoods() { return goods; }
    public void setGoods(Goods goods) { this.goods = goods; }

    private PageBean pageBean;

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    private int page;
    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }


    //管理查询用户信息
    public String queryUser(){
        this.tUsers=adminService.queryUser(user);
        session.put("tUsersList",tUsers);
        if(tUsers.size()>0) {
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    //管理员通过用户ID查询用户信息
    public String queryUserById(){
        this.tUsersById=adminService.queryUserById(user);
        session.put("tUsersByIdList",tUsersById);
        return SUCCESS;
    }


    //管理员查询购物车信息
    public String queryCartitem(){
        this.cartitems=adminService.queryCartitem(cartitem);
        session.put("cartitemsList",cartitems);
        if(cartitems.size()>0) {
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    //管理员通过购物车ID查询购物车信息
    public String queryCartitemById(){
        this.cartitemsById=adminService.queryCartitemById(cartitem);
        session.put("cartitemsByIdList",cartitemsById);
        return SUCCESS;
    }

    //管理员查询商品信息
    public String queryGoods(){
        this.goodss=adminService.queryGoods(goods);
        session.put("goodssList",goodss);
        if(goodss.size()>0) {
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    //管理员通过商品ID查询商品信息
    public String queryGoodsById(){
        this.goodssById=adminService.queryGoodsById(goods);
        session.put("goodssByIdList",goodssById);
        return SUCCESS;
    }

    //管理员删除用户信息
    public String  deleteUser(){
        adminService.deleteUser(user.getId());
        queryUser();//删除用户后刷新
        return SUCCESS;
    }

    //管理员删除购物车信息
    public String deleteCartitem(){
        adminService.deleteCartitem(cartitem.getCartitemId());
        queryCartitemPaging();//踢出购物车信息后刷新
        return SUCCESS;
    }

    //管理员删除商品信息
    public String deleteGoods(){
        adminService.deleteGoods(goods.getGid());
        queryGoodsPaging();//删除商品后刷新
        return SUCCESS;
    }

    //管理员添加用户信息
    public String addUser(){
        adminService.addUser(user);
        queryUser();//添加用户信息后刷新
        return SUCCESS;
    }

    //管理员添加购物车信息
    public String addCartitem(){
        adminService.addCartitem(cartitem);
        queryCartitemPaging();//添加购物车信息后刷新
        return SUCCESS;
    }

    //管理员添加商品信息
    public String addGoods(){
        adminService.addGoods(goods);
        queryGoodsPaging();//修改后刷新查询
        return SUCCESS;
    }

    //管理员修改用户信息
    public String updateUser(){
        boolean b=adminService.updateUser(user);
        if(b){
            queryUser();//修改后刷新查询
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    //管理员修改购物车信息
    public String updateCartitem(){
        boolean b=adminService.updateCartitem(cartitem);
        if(b){
            queryCartitemPaging();//修改后刷新查询
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    //管理员修改商品信息
    public String updateGoods(){
        boolean b=adminService.updateGoods(goods);
        if(b){
            queryGoodsPaging();//修改后刷新查询
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    //管理员批量删除用户信息
    public String deleteUserAll(){
        if(userAll!=null){
            String[] d=userAll.split(",");
            int id;
            for(int i=0;i<d.length;i++){
                id=Integer.parseInt(d[i]);
                adminService.deleteUser(id);
            }
            queryUser();//批量删除后刷新
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    //管理员批量删除购物车信息
    public String deleteCartitemAll(){
        if(cartitemAll!=null){
            String[] d=cartitemAll.split(",");
            int cartitemId;
            for(int i=0;i<d.length;i++){
                cartitemId=Integer.parseInt(d[i]);
                adminService.deleteCartitem(cartitemId);
            }
            queryCartitemPaging();//批量删除后刷新
            return SUCCESS;
        }else{
            return ERROR;
        }
    }


    //管理员批量删除商品信息
    public String deleteGoodsAll(){
        if(goodsAll!=null){
            String[] d=goodsAll.split(",");
            int gid;
            for(int i=0;i<d.length;i++){
                gid=Integer.parseInt(d[i]);
                adminService.deleteGoods(gid);
            }
            queryGoodsPaging();//批量删除后刷新
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

    //带分页的查询商品的执行方法
    public String queryGoodsPaging(){
        //调用Service完成查询操作
        PageBean<Goods> pageBean=adminService.queryGoodsPaging(page);
        //将数据传递到页面上
        session.put("pageBean",pageBean);
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return SUCCESS;
    }

    //带分页的查询购物车的执行方法
    public String queryCartitemPaging(){
        //调用Service完成查询操作
        PageBean<Cartitem> pageBean=adminService.queryCartitemPaging(page);
        //将数据传递到页面上
        session.put("pageBean",pageBean);
        ActionContext.getContext().getValueStack().set("pageBean",pageBean);
        return SUCCESS;
    }
    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
}
