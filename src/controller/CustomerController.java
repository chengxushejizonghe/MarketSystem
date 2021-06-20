package controller;

import entry.Customer;
import service.CustomerService;

import java.sql.SQLException;

public class CustomerController {

    public CustomerService customerService;
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
    //删除用户
    //修改用户
}
