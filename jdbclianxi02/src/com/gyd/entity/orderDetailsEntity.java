package com.gyd.entity;

public class orderDetailsEntity {
    private int orderDetailsid;
    private  String orderid;
    private int commodityid;
    private String commodityname;
    private Double price;
    private  int amount;
    private  Double  money;

    public int getOrderDetailsid() {
        return orderDetailsid;
    }

    public void setOrderDetailsid(int orderDetailsid) {
        this.orderDetailsid = orderDetailsid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public int getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(int commodityid) {
        this.commodityid = commodityid;
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
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
