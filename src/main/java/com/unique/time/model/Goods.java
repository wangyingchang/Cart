package com.unique.time.model;

import javax.persistence.*;

@Entity
public class Goods {
    private int gid;
    private String gname;
    private int gprice;
    private String gdesc;
    private String gsort;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "gid", nullable = false)
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Basic
    @Column(name = "gname", nullable = false, length = 50)
    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    @Basic
    @Column(name = "gprice", nullable = false)
    public int getGprice() {
        return gprice;
    }

    public void setGprice(int gprice) {
        this.gprice = gprice;
    }

    @Basic
    @Column(name = "gdesc", nullable = true, length = 100)
    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    @Basic
    @Column(name = "gsort", nullable = false, length = 20)
    public String getGsort() {
        return gsort;
    }

    public void setGsort(String gsort) {
        this.gsort = gsort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods goods = (Goods) o;

        if (gid != goods.gid) return false;
        if (gprice != goods.gprice) return false;
        if (gname != null ? !gname.equals(goods.gname) : goods.gname != null) return false;
        if (gdesc != null ? !gdesc.equals(goods.gdesc) : goods.gdesc != null) return false;
        if (gsort != null ? !gsort.equals(goods.gsort) : goods.gsort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gid;
        result = 31 * result + (gname != null ? gname.hashCode() : 0);
        result = 31 * result + gprice;
        result = 31 * result + (gdesc != null ? gdesc.hashCode() : 0);
        result = 31 * result + (gsort != null ? gsort.hashCode() : 0);
        return result;
    }
}
