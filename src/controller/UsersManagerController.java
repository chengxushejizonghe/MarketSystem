package controller;

import service.UsersMangerService;
import service.impl.UsersManagerServiceImpl;

/**
 * @author 林敬舒
 * @create 2021-06-20-15:36
 */
public class UsersManagerController {
    public UsersMangerService usersMangerService = new UsersManagerServiceImpl();
    public boolean changeUsersManagerPwd(String username,String oldPassword,String newPassword){
        if (usersMangerService.changeUserManagerPwd(username, oldPassword, newPassword)){
            System.out.println("旧密码已改，请记住新密码！");
            return true;
        }else {
            System.out.println("旧密码、账号不匹配！");
            return false;
        }
    }
}
