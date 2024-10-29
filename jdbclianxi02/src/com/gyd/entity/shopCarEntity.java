package com.gyd.entity;

public class shopCarEntity {
    private int shopcarid;
    private String user;
    private int commodityname;
    private Double price;
    private int amount;
    private  Double money;

    public int getShopcarid() {
        return shopcarid;
    }

    public void setShopcarid(int shopcarid) {
        this.shopcarid = shopcarid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(int commodityname) {
        this.commodityname = commodityname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
