package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import controller.CustomerController;
import controller.LoginController;
import controller.ProductController;
import controller.UsersManagerController;
import entry.Customer;
import utills.ViewUtility;

public class UI {
    private final LoginController loginController = new LoginController();
    private final CustomerController customerController = new CustomerController();
    private final ProductController productController= new ProductController();
    private final UsersManagerController usersManagerController=new UsersManagerController();

    /**
     * 系统首页界面
     * @param customer 
     * @throws SQLException 
     */
    public void menu(Customer customer) throws SQLException{
        boolean loopFlag =true;
        char key = 0;
        do {
            System.out.println("------------------校园超市管理信息系统------------------");
            System.out.println("---------------------1-用户登录---------------------");
            System.out.println("---------------------2-管理员登录---------------------");
            System.out.println("---------------------3-用户注册---------------------");
            System.out.println("---------------------4-退出系统---------------------");
            System.out.println("请选择(1-4)：");
            key = ViewUtility.readMenuSelection();
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
                    customerSignup(customer);
                case '4':
                    System.out.println("确认是否退出(Y/N)：");
                    char yn = ViewUtility.readConfirmSelection();
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
        String username = ViewUtility.readString();
        System.out.println("请输入密码");
        String password = ViewUtility.readString();
        loginController.customerLogin(username,password);//调用控制层方法传入参数
        customerIndex();//进入用户操作视图
    }        

	/**
     * 管理员登录界面
     */
    public void adminLoginInterface(){
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("---------------------管理员登录界面---------------------");
        System.out.println("管理员类型：用户管理员(U)||库存管理员(I)");
        char Type = ViewUtility.readSelectionByAdminType();
        System.out.println("用户名：");
        String username = ViewUtility.readString();
        System.out.println("密码:");
        String password = ViewUtility.readString();
        loginController.adminLogin(Type, username, password);
        }
        
    /**
     * 用户首页
     * @param password 
     * @param money 
     * @throws SQLException 
     * 
     */
    public void customerIndex(String username, Customer customer, String password, double money) throws SQLException{
        boolean loopFlag =true;
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
        char key = ViewUtility.readMenuSelection();
        switch (key){
        case '1':
            System.out.println("转到浏览商品");
            productController.findProducts();
            break;
        case '2':
            System.out.println("转到查看个人信息");
            customerController.selectCustomer();
            break;
        case '3':
            System.out.println("转到修改个人信息");
            customerController.updateCustomer(customer);
            break;
        case '4':
            System.out.println("转到充值");
            customerController.recharge(username, password, money);
            break;
        case '5':
            System.out.println("转到会员");
            
            break;
        case '6':
            System.out.println("转到注销");
            
            break;
        case '7':
            System.out.println("确认是否退出(Y/N)：");
            char yn = ViewUtility.readConfirmSelection();
            if (yn == 'Y'){
                loopFlag = false;
            }
            break;
        }
    }

    /**
     * 用户注册界面
     * @param customer 
     * @throws SQLException 
     */
    public void customerSignup(Customer customer) throws SQLException{
        	System.out.println("------------------校园超市管理信息系统------------------");
            System.out.println("请输入用户名：");
            String username = ViewUtility.readString();
            System.out.println("请输入密码：");
            String password = ViewUtility.readString();
            System.out.println("请输入真实姓名：");
            String realName = ViewUtility.readString();
            System.out.println("请输入联系电话：");
            String contactPhone = ViewUtility.readString();
            System.out.println("请输入邮箱：");
            String email = ViewUtility.readString();
            customerController.addCustomer(customer);
            customerLoginInterface();
    }
    

    /**
     * 用户管理员首页
     * @param username 用户管理员用户名
     * @param oldPassword 
     * @param userName 
     * @param newPassword 
     * @param customer 
     * @throws SQLException 
     */
    public void UsersManagerIndex(String username, String oldPassword, String userName, String newPassword, Customer customer) throws SQLException{
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
            key = ViewUtility.readMenuSelection();
            switch (key){
                case '1':
                    System.out.println("转到用户列表");
                    customerController.findCustomers();
                    break;
                case '2':
                    System.out.println("转到添加用户");
                    customerController.addCustomer(customer);
                    break;
                case '3':
                    System.out.println("转到删除用户");
                    customerController.deleteCustomer(username);
                    break;
                case '4':
                    System.out.println("转到修改用户信息");
                    customerController.updateCustomer(customer);
                    break;
                case '5':
                    System.out.println("转到修改用户密码");
                    customerController.changeCustomerPwd(userName,oldPassword,newPassword);
                    break;
                case '6':
                    System.out.println("转到修改管理员密码");
                    usersManagerController.changeUsersManagerPwd(userName,oldPassword,newPassword);
                    break;
                case '7':
                    System.out.println("确认是否退出(Y/N)：");
                    char yn = ViewUtility.readConfirmSelection();
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
        char key = ViewUtility.readMenuSelection();
        boolean loopFlag =true;
        switch (key){
        case '1':
            System.out.println("转到商品列表");
            productController.findProducts();
            break;
        case '2':
            System.out.println("转到添加商品");
            productController.addProduct();
            break;
        case '3':
            System.out.println("转到删除商品");
            productController.deleteProduct();
            break;
        case '4':
            System.out.println("转到修改商品信息");
            productController.updateProduct();
            break;
        case '7':
            System.out.println("确认是否退出(Y/N)：");
            char yn = ViewUtility.readConfirmSelection();
            if (yn == 'Y'){
                loopFlag = false;
            }
            break;
        }
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.menu();
    }

}
