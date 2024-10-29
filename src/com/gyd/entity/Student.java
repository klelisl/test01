package com.gyd.entity;

public class Student {
    private int stuid;
    private String stuName;
    private  String stuSex;
    private  int stuAge;
    private  int gid;

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public int getGid(int stugid) {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }
}
