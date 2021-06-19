package ui;

import controller.CustomerController;
import controller.LoginController;
import utills.TSUtility;

public class UI {
    private final LoginController loginController = new LoginController();
    private final CustomerController customerController = new CustomerController();

    /**
     * 系统首页界面
     */
    public void menu(){
        boolean loopFlag =true;
        char key = 0;
        do {
            System.out.println("------------------校园超市管理信息系统------------------");
            System.out.println("---------------------1-用户登录---------------------");
            System.out.println("---------------------2-管理员登录---------------------");
            System.out.println("---------------------3-用户注册---------------------");
            System.out.println("---------------------4-退出系统---------------------");
            System.out.println("请选择(1-4)：");
            key = TSUtility.readMenuSelection();
            System.out.println();
            switch (key){
                case '1':
                    System.out.println("转到用户登录界面");
                    customerLoginInterface();
                    break;
                case '2':
                    System.out.println("转到管理员登录界面");
                    adminLoginInterface();
                    break;
                case '3':
                    System.out.println("转到用户注册界面");
                case '4':
                    System.out.println("确认是否退出(Y/N)：");
                    char yn = TSUtility.readConfirmSelection();
                    if (yn == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }while (loopFlag);
    }

    /**
     * 用户登录界面
     */
    public void customerLoginInterface(){
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("---------------------用户登录界面---------------------");
        System.out.println("请输入用户名");
        String username = TSUtility.readString();
        System.out.println("请输入密码");
        String password = TSUtility.readString();
        //调用控制层方法传入参数
        boolean flag = loginController.customerLogin(username,password);
        //进入用户操作视图
        if (flag){
            customerIndex(username);
        }
    }

    /**
     * 管理员登录界面
     */
    public void adminLoginInterface(){
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("---------------------管理员登录界面---------------------");
        System.out.println("管理员类型：用户管理员(U)||库存管理员(I)");
        String adminType = TSUtility.readString();
        System.out.println("用户名：");
        String username = TSUtility.readString();
        System.out.println("密码:");
        String password = TSUtility.readString();
        //调用控制层方法传入参数
        //进入管理员操作界面
    }

    /**
     * 用户首页
     */
    public void customerIndex(String username){
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("--------------------用户"+username+"---------------------");
        System.out.println("1.浏览商品");
        System.out.println("2.查看个人信息");
        System.out.println("3.修改个人信息");
        System.out.println("4.充值");
        System.out.println("5.会员");
        System.out.println("6.注销");
        System.out.println("7.退出登录");
        System.out.println("请选择(1-7)：");
        char key = TSUtility.readMenuSelection();
        System.out.println();
    }

    /**
     * 用户注册界面
     */
    public void customerSignup(){
        System.out.println("------------------校园超市管理信息系统------------------");
    }

    /**
     * 用户管理员首页
     * @param username 用户管理员用户名
     */
    public void UsersManagerIndex(String username){
        boolean loopFlag =true;
        char key = 0;
        do {
            System.out.println("------------------校园超市管理信息系统------------------");
            System.out.println("-----------------用户管理员" + username + "-------------------");
            System.out.println("1.用户列表");
            System.out.println("2.添加用户");
            System.out.println("3.删除用户");
            System.out.println("4.修改用户信息");
            System.out.println("5.修改用户密码");
            System.out.println("6.修改管理员密码");
            System.out.println("7.退出登录");
            System.out.println("请选择(1-7)：");
            key = TSUtility.readMenuSelection();
            switch (key){
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    System.out.println("确认是否退出(Y/N)：");
                    char yn = TSUtility.readConfirmSelection();
                    if (yn == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }while (loopFlag);
    }

    /**
     * 库存管理员首页
     * @param username 库存管理员用户名
     */
    public void InventoryManagerIndex(String username){
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("-----------------库存管理员"+username+"-------------------");
        System.out.println("1.查看商品列表");
        System.out.println("2.添加商品");
        System.out.println("3.删除商品");
        System.out.println("4.修改商品信息");
        System.out.println("5.退出");
        System.out.println("请选择(1-5)：");
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.menu();
    }

}
