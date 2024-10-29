package com.gyd.entity;

public class UserEntity {

    private int user_card;
    private String user_name;
    private String user_password;
    private String user_money;
    private int user_action;

    public int getUser_card() {
        return user_card;
    }

    public void setUser_card(int user_card) {
        this.user_card = user_card;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_money() {
        return user_money;
    }

    public void setUser_money(String user_money) {
        this.user_money = user_money;
    }

    public int getUser_action() {
        return user_action;
    }

    public void setUser_action(int user_action) {
        this.user_action = user_action;
    }
}
