package com.gyd.test;

import com.gyd.dao.AdminDao;
import com.gyd.dao.UserDao;

import java.util.Scanner;

public class Test {
    private static int cout=0;
    static String card1=null;

    public static void main(String[] args) {

        login1();
    }

    public static void login1(){

        UserDao userdao=new UserDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------欢迎使用银行登录系统-------------");
        System.out.println("---------1.用户登录 2.管理员登录  3.退出---------");
        System.out.println("请输入指令:");
        int a = sc.nextInt();
        if(a == 1){
            login01();
        }else if(a == 2){

        }else if(a == 3){
            System.out.println("提示:系统退出....");
            System.exit(0);
        }

    }
    public static void login01(){
        UserDao userdao=new UserDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用ATM机");
        System.out.println("请输入卡号");
        String card=sc.next();
        System.out.println("请输入密码");
        String password=sc.next();
        card1=card;
        //调用登录方法
        int count=userdao.login(card,password);
        if(count>0) {
            int count1=userdao.user_action(card);
            if(count1==0) {
                if (card.matches("[0-9]+")&&password.matches("[0-9]+")){

                    if (cout>=3){
                        int count2=userdao.updateUser(card);
                        if(count2==1) {
                            System.out.println("密码错误次数太多，已自动冻结");
                        }
                    }else {
                        System.out.println("登录成功");

                        login2();
                    }
                }else {
                    System.out.println("请重新登录");
                    cout++;
                    login1();
                }
            }else {
                System.out.println("账户已被冻结");
                login1();
            }
        }else {
            System.out.println("提示:登录失败，请重新登录....");
            cout++;
            //回调登录菜单
            login1();
        }
    }

    public static void login2(){
        UserDao userdao=new UserDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("请选择操作");
        System.out.println("1. 查询用户信息");
        System.out.println("2. 存款");
        System.out.println("3. 取款");
        System.out.println("4. 转账");
        System.out.println("5. 修改密码");
        System.out.println("6. 注销");
        System.out.println("请输入操作指令");
        int code=sc.nextInt();

        if (code == 1){
            userdao.selectAll(card1);

        }else if (code==2) {
            System.out.println("请输入存款金额:");
            int balance=sc.nextInt();
            if (balance>5000){
                System.out.println("存款金额过大,请移至柜台存取");
                login2();
            }else {
                userdao.updateMoney(balance,card1);
                System.out.println("是否打印凭条");
                String choice=sc.next();
                if (choice.equals("是")){
                    userdao.printMoney(balance);
                }else {
                    login2();
                }
            }
        }else if (code==3) {
            System.out.println("请输入取款金额");
            float amount=sc.nextFloat();
            if (amount>5000){
                System.out.println("取款数额过大,请移至柜台取款");
                login2();
            }else {
                float money1=userdao.user_money(card1);
                if (money1>amount){
                    float money2=userdao.ATm_money();
                    if (money2>amount){
                        userdao.drawMoney(amount,card1);
                        System.out.println("是否打印凭条");
                        String choice=sc.next();
                        if (choice.equals("是")){
                            userdao.printMoney1(amount);
                        }else {
                            login2();
                        }
                    }else {
                        System.out.println("ATM机余额不足,请移至柜台");
                        login2();
                    }
                }else {
                    System.out.println("银行卡余额不足");
                    login2();
                }
            }
        }else if (code==4) {
            System.out.println("请输入转账卡号");
            String user_card1=sc.next();
            if(user_card1.matches("[0-9]+")){
                int counnt=userdao.login3(user_card1);
                if(counnt>0) {
                    if(card1.equals(user_card1)){
                        userdao.selectAll1(user_card1);
                        System.out.println("是否确认转账");
                        String choice=sc.next();
                        if (choice.equals("是")){
                            System.out.println("请输入转账金额");
                            String count2= sc.next();
                            if (count2.matches("[0-9]+")){
                                int count3=Integer.parseInt(count2);
                                if (count3>0){
                                    System.out.println("请输入密码");
                                        String pwd=sc.next();
                                        if (pwd.matches("[0-9]+")){
                                            int action=userdao.updateUser1(user_card1);
                                            if (action==0) {
                                                int count4=userdao.login(user_card1,pwd);
                                                if (count4>0) {
                                                    System.out.println("转账成功");
                                                    System.out.println("是否打印凭条");
                                                    String choice1=sc.next();
                                                    if (choice1.equals("是")){
                                                        userdao.printMoney2(count2);
                                                    }else {
                                                        login2();
                                                    }
                                                }
                                            }else {
                                                System.out.println("对方账户已被冻结");
                                            }
                                        }
                                }
                            }else {
                                System.out.println("输入错误");
                                login2();
                            }
                        }else {
                            login2();
                        }
                    }else {
                        System.out.println("输出卡号相同");
                        login2();
                    }
                }else {
                    System.out.println("没有找到对应账户");
                    login2();

                }
            }else {
                System.out.println("输入类型错误");
                login2();
            }

        }else if (code==5) {
            System.out.println("请输入旧密码");
            String pwd= sc.next();
            String password=userdao.selectpwd(card1);
            if(pwd.equals(password)){
                System.out.println("请输入新密码");
                String pwd1= sc.next();
                int count1=Integer.parseInt(pwd);
                if (pwd1.matches("[0-9]+")&& pwd1.length()==6){
                    System.out.println("请再次输入新密码");
                    String pwd2=sc.next();
                    if (pwd1.equals(pwd2)){
                        int count3=userdao.updateUser12(card1,pwd2);
                        if (count3>0) {
                            System.out.println("修改成功");
                        }else {
                            login2();
                        }
                    }else {
                        System.out.println("新密码输入错误");
                    }
                }else {
                    System.out.println("密码输入有误");
                    login2();
                }
            }else {
                System.out.println("输入密码错误");
                login2();
            }
        }else if (code==6) {
            login1();
            System.out.println("是否还要继续");
            String choice=sc.next();
            if (choice.equals("是")){
                login1();
            }else if (choice.equals("否")){
                System.out.println("提示:退出系统....");
                System.exit(0);
            }else {
                System.out.println("输入错误");
                login2();
            }
        }else {
            System.out.println("输入错误,请重新选择操作");
            login2();
        }


    }

    public void login3() {
        AdminDao adminDao = new AdminDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用管理端");
        System.out.println("请输入管理员账号");
        String admin_id = sc.next();
        System.out.println("请输入管理员密码");
        String password = sc.next();
        card1 = admin_id;
        int count = adminDao.login(admin_id, password);
        if (count > 0) {


        }


    }

}
