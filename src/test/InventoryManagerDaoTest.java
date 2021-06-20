package test;

import dao.InventoryManagerDao;
import dao.InventoryManagerDaoImpl;
import entry.InventoryManager;
import org.junit.Test;

/**
 * @author 林敬舒
 * @create 2021-06-19-23:29
 */
public class InventoryManagerDaoTest {

    @Test
    public void testLogin(){
        InventoryManagerDao idao = new InventoryManagerDaoImpl();
        String username = "iadmin";
        String password = "1234";
        InventoryManager i = idao.findInventoryManagerByLogin(username,password);
        if (i!=null){
            System.out.println("登陆成功");
        }
    }
}
