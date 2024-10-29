package com.gyd.test;

import com.gyd.dao.StuInfoDao;
import com.gyd.entity.stugradeEntity;
import com.gyd.entity.stuinfooEntity;
import com.gyd.entity.stuscoreEntity;
import com.gyd.entity.stusubjectEntity;

import java.util.List;

public class Test01 {
    public static void main(String[] args) {

        StuInfoDao stuInfoDao = new StuInfoDao();

        int count=stuInfoDao.updateStuInfo(1,"小南","女");
        System.out.println(count);

        List<stuscoreEntity> scorelist=stuInfoDao.selectScore();

        for(stuscoreEntity s:scorelist){
            int stuid=s.getStuid();
            int subid=s.getSubid();
            int score=s.getScore();
            stuinfooEntity stuinfoo=new stuinfooEntity();
            stuinfoo=s.getStuinfoo();
            String stuname=stuinfoo.getStuname();
            int stuage=stuinfoo.getStuAge();
            System.out.println("学号\t课程编号\t成绩\t姓名\t年龄");
            System.out.println(stuid+"   "+subid+"     "+score+"  "+stuname+"  "+stuage);
        }

        List<stuscoreEntity> stuscoreList=stuInfoDao.selectScoree();

        for(stuscoreEntity s:stuscoreList){
            int stuid=s.getStuid();
            int score=s.getScore();

            stuinfooEntity stuinfoo=s.getStuinfoo();
            String stuname=stuinfoo.getStuname();
            stugradeEntity stugrade=stuinfoo.getStugradeEntity();
            String gname=stugrade.getGname();
            stusubjectEntity stusubject=s.getStusubjectEntity();
            String subName=stusubject.getSubName();

            System.out.println(stuid+" "+stuname+" "+gname+" "+subName+" "+score);
        }


    }
}
