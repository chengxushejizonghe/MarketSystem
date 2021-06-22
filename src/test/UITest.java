package test;

import controller.CustomerController;
import controller.LoginController;
import controller.ProductController;
import entry.Customer;
import entry.Product;
import ui.UI;
import utills.ViewUtility;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-22-18:28
 */
public class UITest {
    private final LoginController loginController = new LoginController();
    private final CustomerController customerController = new CustomerController();
    private final ProductController productController = new ProductController();

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
        while (true) {
            System.out.println("------------------校园超市管理信息系统------------------");
            System.out.println("---------------------用户登录界面---------------------");
            System.out.println("请输入用户名");
            String username = ViewUtility.readString();
            System.out.println("请输入密码");
            String password = ViewUtility.readString();
            //调用控制层方法传入参数
            boolean flag = loginController.customerLogin(username, password);
            //进入用户操作视图
            if (flag) {
                System.out.println("登录成功");
                customerIndex(username);
            } else {
                System.out.println("登陆失败");
                break;
            }
        }
    }

    /**
     * 管理员登录界面
     */
    public void adminLoginInterface(){
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("---------------------管理员登录界面---------------------");
        System.out.println("管理员类型：用户管理员(U)||库存管理员(I)");
        char adminType = ViewUtility.readSelectionByAdminType();
        System.out.println("用户名：");
        String username = ViewUtility.readString();
        System.out.println("密码:");
        String password = ViewUtility.readString();
        //调用控制层方法传入参数
        if (loginController.adminLogin(adminType,username,password)){
            System.out.println("登录成功！");
            if (adminType == 'U'){
                UsersManagerIndex(username);
            }else {
                InventoryManagerIndex(username);
            }
        }
    }

    /**
     * 用户首页
     */
    public void customerIndex(String username){
        boolean loopFlag =true;
        char key = 0;
        do {
            System.out.println("------------------校园超市管理信息系统------------------");
            System.out.println("--------------------用户" + username + "---------------------");
            System.out.println("1.浏览商品");
            System.out.println("2.购买商品");
            System.out.println("3.查看个人信息");
            System.out.println("4.修改个人信息");
            System.out.println("5.充值");
            System.out.println("6.会员");
            System.out.println("7.注销");
            System.out.println("8.退出登录");
            System.out.println("请选择(1-8)：");
            key = ViewUtility.readMenuSelection();
            switch (key){
                case '1':
                    productsList();
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
            }
            System.out.println();
        }while (loopFlag);
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
            key = ViewUtility.readMenuSelection();
            switch (key){
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
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
    }

    /**
     * 用户注册界面
     */
    public void customerSignup() throws SQLException {
        while(true) {
            System.out.println("------------------校园超市管理信息系统------------------");
            System.out.println("----------------------用户注册-----------------------");
            Customer customer = new Customer();
            System.out.println("用户名：");
            String username = ViewUtility.readString();
            System.out.println("密码：");
            String password = ViewUtility.readString();
            System.out.println("真实姓名：");
            String realName = ViewUtility.readString();
            System.out.println("联系电话：");
            String contactPhone = ViewUtility.readString();
            System.out.println("邮箱:");
            String email = ViewUtility.readString();
            customer.setUsername(username);
            customer.setPassword(password);
            customer.setRealName(realName);
            customer.setContactPhone(contactPhone);
            customer.setEmail(email);
            if (customerController.addCustomer(customer)) {
                //转到用户个人页面
                customerIndex(username);
            }else {
                break;
            }
        }
    }

    public void addCustomer() throws SQLException {
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("----------------------添加用户-----------------------");
        Customer customer = new Customer();
        System.out.println("用户名：");
        String username = ViewUtility.readString();
        System.out.println("密码：");
        String password = ViewUtility.readString();
        System.out.println("真实姓名：");
        String realName = ViewUtility.readString();
        System.out.println("联系电话：");
        String contactPhone = ViewUtility.readString();
        System.out.println("邮箱:");
        String email = ViewUtility.readString();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setRealName(realName);
        customer.setContactPhone(contactPhone);
        customer.setEmail(email);
        customerController.addCustomer(customer);
    }



    public void addProduct(){
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("----------------------添加商品-----------------------");
        Product product = new Product();
        System.out.println("请输入商品名称：");
        String productName = ViewUtility.readString();
        product.setProductName(productName);
        System.out.println("定价：");
        double price = ViewUtility.readDouble();
        product.setPrice(price);
        System.out.println("商品类别：");
        String type = ViewUtility.readString();
        product.setType(type);
        System.out.println("生产日期(yyyy-MM-dd HH:mm:ss)：");
        String date = ViewUtility.readString();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime productDate = LocalDateTime.parse(date,df);
        product.setProductionDate(productDate);
        System.out.println("商品数量：");
        int quantity = ViewUtility.readInt();
        product.setQuantity(quantity);
        productController.addProduct(product);
    }

    public void deleteProduct(){
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("----------------------删除商品---------------------");
        System.out.println("请输入要删除的商品名称:");
        String productName = ViewUtility.readString();
        System.out.println("确认是否删除商品(Y/N)：");
        char yn = ViewUtility.readConfirmSelection();
        if (yn == 'Y'){
            if (productController.deleteProduct(productName)){
                System.out.println("-------------------------------------------------");
            }
        }
    }

    public void usersList(){
        System.out.println("--------------------用户列表---------------------");
        List<Customer> customerList = customerController.findCustomers();
        if (customerList.size() == 0){
            System.out.println("用户编号(id)\t用户名(username)\t密码(password)\t用户余额(balance)\t真实姓名(realName)\t联系方式(contactPhone)\t邮箱(email)\t用户等级");
        }
        for (Customer c: customerList){
            System.out.println(" "+c.getId()+" "+c.getUsername()+" "+c.getPassword()+" "+c.getBalance()+
                    " "+c.getRealName()+" "+c.getCreationTime()+" "+c.getContactPhone()+" "+c.getEmail()+" "+c.getLevel());
        }
        System.out.println("------------------------------------------------");
    }

    public void productsList(){
        System.out.println("--------------------商品列表---------------------");
        List<Product> productList = productController.findProducts();
        if (productList.size() == 0){
            System.out.println("商品编号(id)\t商品名称(productName)\t价格(price)\t商品类别(type)\t生产日期(productionDate)\t库存量(quantity)\t销量(salesVolume)");
        }
        for (Product p :productList){
            System.out.println(" "+p.getId()+" "+p.getProductName()+" "+p.getPrice()+" "+
                    p.getType()+" "+p.getProductionDate()+" "+p.getQuantity()+" "+p.getSalesVolume());
        }
        System.out.println("------------------------------------------------");
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.menu();
    }
}
