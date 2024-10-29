package com.gyd.test;

import com.gyd.dao.userinfoDao;
import com.gyd.entity.commodityInformationEntity;

import java.util.List;
import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);
    static userinfoDao user = new userinfoDao();

    public static void main(String[] args) {

        login();
    }


    public static void login() {


        System.out.println("欢迎使用超市管理系统");
        System.out.println("请选择操作：  1.登录   2.注册");
        System.out.println("请选择");
        int choice = sc.nextInt();
        if (choice == 1) {
            login01();

        } else if (choice == 2) {
            System.out.println("1.注册买家  2.注册卖家");
            System.out.println("请选择");
            int choice2 = sc.nextInt();
            if (choice2 == 1) {

                registeruser();

            } else if (choice2 == 2) {
                registerSeller();

            } else {
                System.out.println("输入错误");
                login();
            }
        } else {
            System.out.println("输入错误,请重新选择");
            login();
        }
    }

    //登录
    public static void login01() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号");
        String userid = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        int result = user.login(userid, password);
        if (result == 1) {
            int login = user.loginChioce(userid);
            if (login == 1) {
                System.out.println("登录成功");
                System.out.println("------------------------------------------");
                System.out.println("-----------欢迎来到网购系统首页--------------");
                System.out.println("1.商品管理");
                System.out.println("2.订单管理");
                System.out.println("3.商品列表");
                System.out.println("4.个人信息管理");
                System.out.println("------------------------------------------");
                System.out.println("请选择菜单项[0 退出]");
                int choice = sc.nextInt();
                if (choice == 1) {

                }else if (choice == 2) {

                }else if (choice == 3) {

                }else if (choice == 4) {

                }else if (choice == 0) {
                    System.out.println("退出系统");
                    System.exit(0);
                }else {
                    System.out.println("输入错误");
                    System.out.println("请重新登录");
                    login01();
                }

            } else if (login==2) {
                System.out.println("登录成功");
                System.out.println("------------------------------------------");
                System.out.println("-----------欢迎来到网购系统首页--------------");
                System.out.println("1.商品列表");
                System.out.println("2.个人信息管理");
                System.out.println("------------------------------------------");
                System.out.println("请选择菜单项[0 退出]");
                int choice = sc.nextInt();
                if (choice == 1) {
                    commodityInformationSelectAll();
                    System.out.println("请选择中意的商品编号");
                    int choice2 = sc.nextInt();
                    System.out.println("请选择要购买的数量");
                    int choice3 = sc.nextInt();
                    if (choice2>0&&choice3>0) {

                        System.out.println("加入购物车一件物品");
                        System.out.println("是否继续购物[y/n]");
                        String answer = sc.next();
                        if (answer.equals("y")) {

                        }else if (answer.equals("n")) {

                        }
                    }else{
                        System.out.println("添加失败");
                        commodityInformationSelectAll();
                        System.out.println("请选择中意的商品编号");
                        int choice5 = sc.nextInt();
                        System.out.println("请选择要购买的数量");
                        int choice4 = sc.nextInt();
                    }
                }else if (choice == 2) {

                }else if (choice == 0) {

                }else  {
                    System.out.println("输入错误");
                    System.out.println("请重新登录");
                    login01();
                }
            }else if (login==3) {
                System.out.println("超级管理员");

            }
        } else {
            System.out.println("登录失败");
            login();
        }
    }

    //注册买家
    public static void registeruser() {
        System.out.println("请输入新账号");
        String userid = sc.next();
        System.out.println("请输入新密码");
        String password = sc.next();
        System.out.println("请输入姓名");
        String username = sc.next();
        int count = user.insertUserinfo(userid, password, username);
        if (count > 0) {
            System.out.println("买家注册成功");
            login();
        } else {
            System.out.println("买家注册失败");
            login();
        }

    }

    //注册卖家
    public static void registerSeller() {
        System.out.println("请输入新账号");
        String userid = sc.next();
        System.out.println("请输入新密码");
        String password = sc.next();
        System.out.println("请输入姓名");
        String username = sc.next();
        int count1 = user.insertSeller(userid, password, username);
        if (count1 > 0) {
            System.out.println("商家注册成功");
            login();
        } else {
            System.out.println("商家注册失败");
            login();
        }
    }

    public  static  void commodityInformationSelectAll(){

        List<commodityInformationEntity> commodityInformationList=userinfoDao.commodityInformationSelect();

        for(commodityInformationEntity s:commodityInformationList){

            int commodityid=s.getCommodityid();
            String commodityname=s.getCommodityName();
            int typeid=s.getTyped();
            String brand=s.getBrand();
            double price=s.getPrice();
            String productiondate=s.getProductiondate();
            String expirationdate=s.getExpirationdate();

            System.out.println("-------------------------------------------");
            System.out.println("商品id="+commodityid+", 名称="+commodityname+", 类型id="+typeid+", 品牌="+brand+",价格="+price+", 生产日期="+productiondate+", 失效日期="+expirationdate);

        }


    }

}
