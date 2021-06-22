package dao;


import entry.InventoryManager;

/**
 * @author 林敬舒
 * @create 2021-06-18-16:08
 */
public interface InventoryManagerDao {
    public InventoryManager findInventoryManagerByLogin(String username, String password);
    public boolean changeInventoryManagerPwd(String username,String oldPassword,String newPassword);
}
