package controller;

import service.InventoryManagerService;
import service.impl.InventoryManagerServiceImpl;

/**
 * @author 林敬舒
 * @create 2021-06-20-14:48
 */
public class InventoryManagerController {
    public InventoryManagerService inventoryManagerService = new InventoryManagerServiceImpl();

    /**
     * 修改库存管理员密码
     * @param username 库存管理员用户名
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return
     */
    public boolean changeInventoryManagerPwd(String username,String oldPassword,String newPassword){
        if (inventoryManagerService.changeInventoryManagerPwd(username, oldPassword, newPassword)){
            System.out.println("旧密码已改，请记住新密码！");
            return true;
        }else {
            System.out.println("旧密码、账号不匹配！");
            return false;
        }
    }
}
