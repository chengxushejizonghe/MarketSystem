package service.impl;

import dao.InventoryManagerDao;
import dao.InventoryManagerDaoImpl;
import entry.InventoryManager;
import service.InventoryManagerService;

/**
 * @author 林敬舒
 * @create 2021-06-20-0:49
 */
public class InventoryManagerServiceImpl implements InventoryManagerService {

    InventoryManagerDao inventoryManagerDao = new InventoryManagerDaoImpl();

    @Override
    public InventoryManager loginInventoryManagerByLogin(String username, String password) {
        return inventoryManagerDao.findInventoryManagerByLogin(username,password);
    }

    @Override
    public boolean changeInventoryManagerPwd(String password, int id) {
        return inventoryManagerDao.changeInventoryManagerPwd(password,id);
    }
}
