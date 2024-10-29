package com.gyd.entity;

public class AdminEntity {
    private int admin_id;
    private String admin_password;
    private int admin_action;

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public int getAdmin_action() {
        return admin_action;
    }

    public void setAdmin_action(int admin_action) {
        this.admin_action = admin_action;
    }
}
