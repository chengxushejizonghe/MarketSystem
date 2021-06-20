package controller;

import entry.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

/**
 * @author 林敬舒
 * @create 2021-06-18-14:05
 */
public class LoginController {
    private CustomerService customerService;

    public LoginController(){
        customerService = new CustomerServiceImpl();
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

    public boolean adminLogin(char type,String username,String password){
        //用户管理员
        if (type == 'U'){

        }
        return true;
    }
}
