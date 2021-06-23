package test;

import arithmetic.Arithmetic;
import controller.CustomerController;
import controller.LoginController;
import controller.ProductController;
import controller.UsersManagerController;
import entry.Customer;
import entry.Product;
import utills.ViewUtility;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 林敬舒
 * @create 2021-06-22-18:28
 */
public class UITest {
    private final LoginController loginController = new LoginController();
    private final CustomerController customerController = new CustomerController();
    private final UsersManagerController usersManagerController = new UsersManagerController();
    private final ProductController productController = new ProductController();

    /**
     * 系统首页界面
     */
    public void menu() throws SQLException {
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
                    customerSignup();
                    break;
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
    public void customerLoginInterface() throws SQLException {
        while (true) {
            System.out.println("------------------校园超市管理信息系统------------------");
            System.out.println("---------------------用户登录界面---------------------");
            System.out.println("是否登录(Y/N)");
            char yn = ViewUtility.readConfirmSelection();
            if (yn == 'N'){
                break;
            }
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
    public void adminLoginInterface() throws SQLException {
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
        }else {
            System.out.println("登录失败，请检查用户名和密码是否正确!");
        }
    }

    /**
     * 用户首页
     */
    public void customerIndex(String username) throws SQLException {
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
            System.out.println("6.升级会员");
            System.out.println("7.注销");
            System.out.println("8.退出登录");
            System.out.println("请选择(1-8)：");
            key = ViewUtility.readMenuSelection();
            switch (key){
                case '1':
                    productsList();
                    break;
                case '2':
                    buy();
                    break;
                case '3':
                    customerDetail(username);
                    break;
                case '4':
                    username = updateCustomerByPersonal(username);
                    break;
                case '5':
                    addBalance(username);
                    break;
                case '6':
                    levelUp();
                    break;
                case '7':
                    deleteCustomer(username);
                    loopFlag = false;
                case '8':
                    System.out.println("确认是否登出(Y/N)：");
                    char yn = ViewUtility.readConfirmSelection();
                    if (yn == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
            System.out.println();
        }while (loopFlag);
    }




    /**
     * 用户管理员首页
     * @param username 用户管理员用户名
     */
    public void UsersManagerIndex(String username) throws SQLException {
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
                    usersList();
                    break;
                case '2':
                    addCustomer();
                    break;
                case '3':
                    System.out.println("请输入要删除的用户的用户名");
                    String cname = ViewUtility.readString();
                    deleteCustomer(cname);
                    break;
                case '4':
                    System.out.println("请输入要修改的用户名：");
                    String cname1 = ViewUtility.readString();
                    updateCustomerByPersonal(cname1);
                    break;
                case '5':
                    System.out.println("请输入用户名：");
                    String cuname = ViewUtility.readString();
                    System.out.println("请输入旧密码：");
                    String oldPassword0 = ViewUtility.readString();
                    System.out.println("请输入新密码：");
                    String newPassword0 = ViewUtility.readString();
                    customerController.changeCustomerPwd(cuname,oldPassword0,newPassword0);
                    System.out.println("-----------------------按回车键返回-------------------------");
                    ViewUtility.readReturn();
                    break;
                case '6':
                    System.out.println("请输入旧密码：");
                    String oldPassword = ViewUtility.readString();
                    System.out.println("请输入新密码：");
                    String newPassword = ViewUtility.readString();
                    usersManagerController.changeUsersManagerPwd(username,oldPassword,newPassword);
                    System.out.println("-----------------------按回车键返回-------------------------");
                    ViewUtility.readReturn();
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
        boolean loopFlag =true;
        char key = 0;
        do {
            System.out.println("------------------校园超市管理信息系统------------------");
            System.out.println("-----------------库存管理员" + username + "-------------------");
            System.out.println("1.查看商品列表");
            System.out.println("2.添加商品");
            System.out.println("3.删除商品");
            System.out.println("4.修改商品信息");
            System.out.println("5.补充或清理商品库存");
            System.out.println("6.退出");
            System.out.println("请选择(1-5)：");
            key = ViewUtility.readMenuSelection();
            switch (key){
                case '1':
                    productsList();
                    break;
                case '2':
                    addProduct();
                    break;
                case '3':
                    deleteProduct();
                    break;
                case '4':
                    updateProduct();
                    break;
                case '5':
                    changeProductCount();
                    break;
                case '6':
                    System.out.println("确认是否退出(Y/N)：");
                    char yn = ViewUtility.readConfirmSelection();
                    if (yn == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }while (loopFlag);
    }

    private void updateProduct() {
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("----------------------修改商品信息------------------------");
        Product product = new Product();
        System.out.println("请输入商品名称：");
        product.setProductName(ViewUtility.readString());
        System.out.println("请输入商品价格：");
        product.setPrice(ViewUtility.readDouble());
        System.out.println("请输入商品类型：");
        product.setType(ViewUtility.readString());
        System.out.println("请输入商品生产日期：");
        String date = ViewUtility.readString();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime productDate = LocalDateTime.parse(date,df);
        product.setProductionDate(productDate);
        System.out.println("请输入商品数量：");
        product.setQuantity(ViewUtility.readInt());
        if (productController.updateProduct(product)){
            System.out.println("-----------------------按回车键返回-------------------------");
            ViewUtility.readReturn();
        }

    }

    private void changeProductCount() {
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("------------------商品库存补充和清理----------------------");
        System.out.println("1.补充库存");
        System.out.println("2.清理库存");
        char key = ViewUtility.readMenuSelection();
        if (key == '1'){
            System.out.println("输入商品id：");
            int id = ViewUtility.readInt();
            System.out.println("输入补充数量：");
            int count = ViewUtility.readInt();
            if (productController.increaseProductCount(id,count)){
                System.out.println("-----------------------按回车键返回-------------------------");
                ViewUtility.readReturn();
            }
        }else if (key == '2'){
            System.out.println("输入商品id：");
            int id = ViewUtility.readInt();
            System.out.println("输入清理数量：");
            int count = ViewUtility.readInt();
            if (productController.decreaseProductCount(id,count)){
                System.out.println("-----------------------按回车键返回-------------------------");
                ViewUtility.readReturn();
            }
        }
    }

    public void customerDetail(String username){
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("----------------------个人信息------------------------");
        Customer customer = customerController.findCustomerByName(username);
        System.out.println("用户编号："+customer.getId());
        System.out.println("用户名："+customer.getUsername());
        System.out.println("用户余额: "+ customer.getBalance());
        System.out.println("真实姓名：" + customer.getRealName());
        System.out.println("注册日期：" + customer.getCreationTime());
        System.out.println("联系电话:" + customer.getContactPhone());
        System.out.println("邮箱:" + customer.getEmail());
        System.out.println("用户等级:" + customer.getLevel());
        System.out.println("-----------------------按回车键返回-------------------------");
        ViewUtility.readReturn();
    }

    /**
     * 用户注册界面
     */
    public void customerSignup() throws SQLException {
        while(true) {
            System.out.println("------------------校园超市管理信息系统------------------");
            System.out.println("----------------------用户注册-----------------------");
            System.out.println("是否注册(Y/N)");
            char yn = ViewUtility.readConfirmSelection();
            if (yn == 'N') {
                break;
            }
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
                System.out.println("-----------------------按回车键返回-------------------------");
                ViewUtility.readReturn();
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
        System.out.println("-----------------------按回车键返回-------------------------");
        ViewUtility.readReturn();
    }

    private String updateCustomerByPersonal(String username) throws SQLException {
        System.out.println("-----------------------校园超市管理信息系统------------------");
        System.out.println("----------------------修改用户"+username+"-----------------------");
        Customer customer = customerController.findCustomerByName(username);
        System.out.println("请输入新的用户名:");
        String newUsername = ViewUtility.readString();
        customer.setUsername(newUsername);
        System.out.println("请输入新密码");
        customer.setPassword(ViewUtility.readString());
        System.out.println("真实姓名：");
        customer.setRealName(ViewUtility.readString());
        System.out.println("联系电话:");
        customer.setContactPhone(ViewUtility.readString());
        System.out.println("邮箱：");
        customer.setEmail(ViewUtility.readString());
        if (customerController.updateCustomer(customer)){
            System.out.println("---------------------------");
            System.out.println("-----------------------按回车键返回-------------------------");
            ViewUtility.readReturn();
            return newUsername;
        }
        System.out.println("-----------------------按回车键返回-------------------------");
        ViewUtility.readReturn();
        return username;
    }

    private void deleteCustomer(String username) throws SQLException {
        System.out.println("-----------------------校园超市管理信息系统------------------");
        System.out.println("----------------------注销用户"+username+"-----------------------");
        char yn = ViewUtility.readConfirmSelection();
        System.out.println("是否删除用户(Y/N)：");
        if (yn == 'Y') {
            if(customerController.deleteCustomer(username)){
                System.out.println("-----------------------按回车键返回-------------------------");
                ViewUtility.readReturn();
            }
        }
        System.out.println("-----------------------按回车键返回-------------------------");
        ViewUtility.readReturn();
    }

    private void addBalance(String username) {
        System.out.println("-----------------------校园超市管理信息系统------------------");
        System.out.println("--------------------------充值页面-------------------------");
        System.out.println("用户名"+username);
        System.out.println("输入密码：");
        String password = ViewUtility.readString();
        System.out.println("输入充值金额: ");
        double money = ViewUtility.readDouble();
        if(customerController.recharge(username,password,money)){
            System.out.println("-----------------------按回车键返回-------------------------");
            ViewUtility.readReturn();
        }
        System.out.println("-----------------------按回车键返回-------------------------");
        ViewUtility.readReturn();
    }

    private void levelUp() {
        System.out.println("-----------------------校园超市管理信息系统------------------");
        System.out.println("--------------------------会员升级-------------------------");
        System.out.println("每升一级10元");
        System.out.println("等级优惠：1级9折，2级8折，3级7折");
        System.out.println("请输入用户名:");
        String username = ViewUtility.readString();
        System.out.println("请输入密码:");
        String password = ViewUtility.readString();
        System.out.println("请输入等级(0,1,2,3):");
        int level = ViewUtility.readInt();
        if (customerController.upgradeLevel(username,password,level)){
            System.out.println("-----------------------按回车键返回-------------------------");
            ViewUtility.readReturn();
        }
        System.out.println("-----------------------按回车键返回-------------------------");
        ViewUtility.readReturn();
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
        System.out.println("-----------------------按回车键返回-------------------------");
        ViewUtility.readReturn();
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
                System.out.println("-----------------------按回车键返回-------------------------");
                ViewUtility.readReturn();
                System.out.println("-------------------------------------------------");
            }
        }
    }

    public void buy(){
        System.out.println("------------------校园超市管理信息系统------------------");
        System.out.println("----------------------购买商品---------------------");
        System.out.println("请输入要购买商品的名称：");
        String productName = ViewUtility.readString();
        System.out.println("输入要购买商品的数量：");
        int count = ViewUtility.readInt();
        System.out.println("请输入用户名：");
        String username = ViewUtility.readString();
        System.out.println("请输入密码：");
        String password = ViewUtility.readString();
        System.out.println("确认购买商品(Y/N)");
        char yn = ViewUtility.readConfirmSelection();
        if (yn == 'Y'){
            if (customerController.pay(productName,count,username,password)){
                System.out.println("-----------------------按回车键返回-------------------------");
                ViewUtility.readReturn();
            }
        }
    }

    public void usersList(){
        System.out.println("--------------------用户列表---------------------");
        List<Customer> customerList = customerController.findCustomers();
        List<Customer> customerListAfterSort = new ArrayList<>();
        char yn = ViewUtility.readConfirmSelection();
        if (yn == 'Y'){
            System.out.println("1.按用户余额排序");
            System.out.println("2.按用户等级排序");
            System.out.println("3.按用户注册时间排序");
            char key = ViewUtility.readMenuSelection();
            switch (key){
                case '1':
                    customerListAfterSort = Arithmetic.sort(customerList);
                    break;
                case '2':
                    customerListAfterSort = Arithmetic.quickSort2(customerList);
                    break;
                case '3':
                    customerListAfterSort = Arithmetic.quickSort3(customerList);
                    break;
            }
        }else {
            customerListAfterSort = customerList;
        }
        if (customerListAfterSort.size() != 0){
            System.out.println("用户编号(id)\t用户名(username)\t密码(password)\t用户余额(balance)\t真实姓名(realName)\t联系方式(contactPhone)\t邮箱(email)\t用户等级");
        }else {
            System.out.println("当前没有用户");
        }
        for (Customer c: customerListAfterSort){
            System.out.println(" "+c.getId()+" "+c.getUsername()+" "+c.getPassword()+" "+c.getBalance()+
                    " "+c.getRealName()+" "+c.getCreationTime()+" "+c.getContactPhone()+" "+c.getEmail()+" "+c.getLevel());
        }
        System.out.println("-----------------------按回车键返回-------------------------");
        ViewUtility.readReturn();
        System.out.println("------------------------------------------------");
    }

    public void productsList(){
        System.out.println("--------------------商品列表---------------------");
        List<Product> productList = productController.findProducts();
        List<Product> productListAfterSort = new ArrayList<>();
        System.out.println("是否排序（y/n）：");
        char yn = ViewUtility.readConfirmSelection();
        if (yn == 'Y'){
            System.out.println("1.按照商品价格排序");
            System.out.println("2.按照商品库存量排序");
            System.out.println("3.按照商品销量排序");
            System.out.println("4.按生产日期排序");
            char key = ViewUtility.readMenuSelection();
            switch (key){
                case '1':
                    productListAfterSort = Arithmetic.PriceSort(productList);
                    break;
                case '2':
                    productListAfterSort = Arithmetic.QuantitySort(productList);
                    break;
                case '3':
                    productListAfterSort = Arithmetic.SalesVolumeSort(productList);
                    break;
                case '4':
                    productListAfterSort = Arithmetic.LocalDateTimeSort(productList);
                    break;
            }
        }else {
            productListAfterSort = productList;
        }

        if (productListAfterSort.size() != 0){
            System.out.println("商品编号(id)\t商品名称(productName)\t价格(price)\t商品类别(type)\t生产日期(productionDate)\t库存量(quantity)\t销量(salesVolume)");
        }else {
            System.out.println("当前没有商品");
            return;
        }
        for (Product p :productListAfterSort){
            System.out.println(" "+p.getId()+" "+p.getProductName()+" "+p.getPrice()+" "+
                    p.getType()+" "+p.getProductionDate()+" "+p.getQuantity()+" "+p.getSalesVolume());
        }
        System.out.println("-----------------------按回车键返回-------------------------");
        ViewUtility.readReturn();
        System.out.println("------------------------------------------------");
    }

    public static void main(String[] args) throws SQLException {
        UITest ui = new UITest();
        ui.menu();
    }
}
