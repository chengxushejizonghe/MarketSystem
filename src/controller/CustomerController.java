package controller;

import entry.Customer;
import entry.Product;
import service.CustomerService;
import service.ProductService;
import service.impl.CustomerServiceImpl;
import service.impl.ProductServiceImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class CustomerController {

    public CustomerService customerService;
    public ProductService productService;

    public CustomerController() {
        this.customerService = new CustomerServiceImpl();
        this.productService = new ProductServiceImpl();
    }

    /**
     * 查询用户个人信息
     * @return
     */
    public List<Customer> selectCustomer(){
    	return customerService.selectCustomer();
    }
    /**
     * 查找所有用户
     * @return
     */
    public List<Customer> findCustomers(){
        return customerService.findCustomers();
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public Customer findCustomerByName(String username){
        Customer customer = customerService.findCustomerByName(username);
        if (customer != null){
            return customer;
        }else {
            System.out.println("查找不到该用户！");
            return null;
        }
    }


    /**
     * 可用于用户注册和管理员添加用户
     * @param customer 传入的customer参数至少包含username,password,realName,contactPhone,email属性,不要传creationTime
     * @return
     */
    public boolean addCustomer(Customer customer) throws SQLException {
        if (customerService.findCustomerByName(customer.getUsername())!=null){
            System.out.println("用户名已存在");
            return false;
        }else {//用户是新的可以添加
            if (customerService.insertCustomer(customer)){
                System.out.println("新的用户添加成功");
                return true;
            }else {
                System.out.println("添加用户失败");
                return false;
            }
        }
    }

    /**
     *删除用户
     */
    public boolean deleteCustomer(String username) throws SQLException {
        Customer customer = customerService.findCustomerByName(username);
        if (customer!=null){//用户存在，执行删除
            boolean isDelete = customerService.deleteCustomer(customer.getId());
            if (isDelete) {
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
            return isDelete;
        }else {
            System.out.println("用户不存在！");
            return false;
        }
    }

    /**
     * 修改用户密码
     * @param username 用户名
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return
     */
    public boolean changeCustomerPwd(String username,String oldPassword,String newPassword){
        if (customerService.changeCustomerPwd(username, oldPassword, newPassword)){
            System.out.println("旧密码已改，请记住新密码！");
            return true;
        }else {
            System.out.println("旧密码、账号不匹配！");
            return false;
        }
    }
    /**
     * 修改用户信息
     */
    public boolean updateCustomer(Customer customer) throws SQLException {
        if (customerService.updateCustomer(customer)){
            //set username = ?,password = ?,realName = ?,contactPhone = ?,email = ?,level = ? where id = ?
            System.out.println("修改用户信息成功！");
            return true;
        }else {
            System.out.println("修改用户信息失败!");
            return false;
        }
    }

    /**
     * 用户余额充值
     */
    public boolean recharge(String username,String password,double money){
        if (customerService.increaseOrDecreaseCustomerBalance(username, password, money)){
            System.out.println("用户余额充值成功");
            double balance = customerService.findCustomerByName(username).getBalance();
            System.out.println("当前用户余额：" + balance);
            return true;
        }else {
            System.out.println("充值失败！请检查用户名和密码是否正确");
            return false;
        }
    }

    /**
     * 用户购买商品，购买商品需要确认用户名密码
     * @param productName 要购买商品的id
     * @param count 购买数量
     * @param username 用户名
     * @param password 密码
     */
    public boolean pay(String productName,int count,String username,String password){
        Product product = productService.findProductByName(productName);
        Customer customer = customerService.findCustomerByLogin(username, password);
        int level = customer.getLevel();
        double discount = 1;
        switch (level){
            case 0:
                discount = 1;
                break;
            case 1:
                discount = 0.9;
                break;
            case 2:
                discount = 0.8;
                break;
            case 3:
                discount = 0.75;
                break;
        }
        if (customer == null){
            System.out.println("用户名或密码不正确!");
            return false;
        }
        if (product == null){
            System.out.println("该商品不存在");
            return false;
        }
        if (product.getQuantity() - count < 0){
            System.out.println("抱歉，商品库存不足!");
            return false;
        }
        if (customer.getBalance() - product.getPrice()*count < 0){
            System.out.println("账户余额不足");
            return false;
        }
        if(productService.decreaseProductCount(product.getId(),count)&&
        customerService.increaseOrDecreaseCustomerBalance(username,password,-(product.getPrice()*discount))) {
            System.out.println("商品购买成功！");
            return true;
        }
        return false;
    }

    /**
     * 升级会员
     * @param username
     * @param password
     * @param level
     * @return
     */
    public boolean upgradeLevel(String username,String password,int level){
        Customer customer = customerService.findCustomerByLogin(username,password);
        if (customer == null){
            System.out.println("用户名或密码不正确");
            return false;
        }
        int change = level - customer.getLevel();
        if (change <= 0 || level > 3){
            System.out.println("已达到该等级");
            return false;
        }
        double cost = change*10;
        if (cost > customer.getLevel()){
            System.out.println("账户余额不足");
            return false;
        }
        if (customerService.increaseOrDecreaseCustomerBalance(username,password,change)&&customerService.upgradeCustomerLevel(username,password
        ,change)) {
            System.out.println("用户升级成功");
            return true;
        }
        return false;
    }

}
