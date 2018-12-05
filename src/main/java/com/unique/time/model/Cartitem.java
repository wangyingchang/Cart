package com.unique.time.model;

import javax.persistence.*;

@Entity
public class Cartitem {
    private int cartitemId;
    private int uid;
    private Integer gid;
    private String gname;
    private String gdesc;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cartitemId", nullable = false)
    public int getCartitemId() {
        return cartitemId;
    }

    public void setCartitemId(int cartitemId) {
        this.cartitemId = cartitemId;
    }

    @Basic
    @Column(name = "uid", nullable = false)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "gid", nullable = true)
    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    @Basic
    @Column(name = "gname", nullable = false, length = 20)
    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    @Basic
    @Column(name = "gdesc", nullable = true, length = 20)
    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cartitem cartitem = (Cartitem) o;

        if (cartitemId != cartitem.cartitemId) return false;
        if (uid != cartitem.uid) return false;
        if (gid != null ? !gid.equals(cartitem.gid) : cartitem.gid != null) return false;
        if (gname != null ? !gname.equals(cartitem.gname) : cartitem.gname != null) return false;
        if (gdesc != null ? !gdesc.equals(cartitem.gdesc) : cartitem.gdesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cartitemId;
        result = 31 * result + uid;
        result = 31 * result + (gid != null ? gid.hashCode() : 0);
        result = 31 * result + (gname != null ? gname.hashCode() : 0);
        result = 31 * result + (gdesc != null ? gdesc.hashCode() : 0);
        return result;
    }
}
