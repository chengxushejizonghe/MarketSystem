package controller;

import entry.Customer;
import entry.InventoryManager;
import entry.UsersManager;
import service.CustomerService;
import service.InventoryManagerService;
import service.UsersMangerService;
import service.impl.CustomerServiceImpl;
import service.impl.InventoryManagerServiceImpl;
import service.impl.UsersManagerServiceImpl;

/**
 * @author 林敬舒
 * @create 2021-06-18-14:05
 */
public class LoginController {
    public CustomerService customerService;
    public InventoryManagerService inventoryManagerService;
    public UsersMangerService usersMangerService;

    public LoginController(){
        customerService = new CustomerServiceImpl();
        inventoryManagerService = new InventoryManagerServiceImpl();
        usersMangerService = new UsersManagerServiceImpl();
    }

    public boolean customerLogin(String username,String password){
        Customer customer = customerService.findCustomerByLogin(username,password);
        //是否转到个人界面
        boolean isToPrivate;
        if (customer == null){
            System.out.println("用户、密码不匹配");
            isToPrivate = false;
        }else {
            System.out.println("登录成功！");
            isToPrivate = true;
        }
        return isToPrivate;
    }

    /**
     * 管理员登录
     * @param type 管理员类型
     * @param username 管理员名称
     * @param password 管理员密码
     * @return 是否转到管理员的个人页面
     */
    public boolean adminLogin(char type,String username,String password){
        //用户管理员
        if (type == 'U'){
            UsersManager usersManager = usersMangerService.findUsersManagerByLogin(username,password);
            return usersManager != null;
        }else if (type == 'I'){//库存管理员
            InventoryManager inventoryManager = inventoryManagerService.findInventoryManagerByLogin(username,password);
            return inventoryManager != null;
        }
        return false;
    }
}
