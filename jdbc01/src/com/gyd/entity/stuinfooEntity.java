package com.gyd.entity;

public class stuinfooEntity {
    private int stuid;
    private String stuname;
    private String stusex;
    private int stuAge;
    private int gid;
    private stugradeEntity stugradeEntity;

    public com.gyd.entity.stugradeEntity getStugradeEntity() {
        return stugradeEntity;
    }

    public void setStugradeEntity(com.gyd.entity.stugradeEntity stugradeEntity) {
        this.stugradeEntity = stugradeEntity;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }
}
