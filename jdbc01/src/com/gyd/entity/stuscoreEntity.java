package com.gyd.entity;

public class stuscoreEntity {

    private int id;
    private int stuid;
    private int subid;
    private int score;
    private stuinfooEntity stuinfoo;
    private stusubjectEntity stusubjectEntity;



    public com.gyd.entity.stusubjectEntity getStusubjectEntity() {
        return stusubjectEntity;
    }

    public void setStusubjectEntity(com.gyd.entity.stusubjectEntity stusubjectEntity) {
        this.stusubjectEntity = stusubjectEntity;
    }

    public stuinfooEntity getStuinfoo() {
        return stuinfoo;
    }

    public void setStuinfoo(stuinfooEntity stuinfoo) {
        this.stuinfoo = stuinfoo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public int getSubid() {
        return subid;
    }

    public void setSubid(int subid) {
        this.subid = subid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
