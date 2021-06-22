package controller;

import entry.Customer;
import service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerController {

    public CustomerService customerService;

    public List<Customer> findCustomers() throws SQLException {
        return customerService.findCustomers();
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
            }
        }
        return false;
    }
    /**
     *删除用户
     */
    public boolean deleteCustomer(String username) throws SQLException {
        Customer customer = customerService.findCustomerByName(username);
        if (customer!=null){//用户存在，执行删除
            boolean isDelete = customerService.deleteCustomer(customer.getId());
            System.out.println("删除成功");
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
    //修改用户
}
