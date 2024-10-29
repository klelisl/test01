package com.gyd.entity;

import java.util.Date;

public class orderEntity {
    private String orderid;
    private Double summoney;
    private String orderdate;
    private String user;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Double getSummoney() {
        return summoney;
    }

    public void setSummoney(Double summoney) {
        this.summoney = summoney;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
