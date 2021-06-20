package service;

import dao.InventoryManagerDao;
import dao.InventoryManagerDaoImpl;
import entry.InventoryManager;

/**
 * @author 林敬舒
 * @create 2021-06-20-0:46
 */
public interface InventoryManagerService {
    public InventoryManager findInventoryManagerByLogin(String username,String password);
    public boolean changeInventoryManagerPwd(String password,int id);

}
