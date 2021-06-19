package dao;

import entry.InventoryManager;
import utills.JDBCUtils;

import java.sql.Connection;

/**
 * @author 林敬舒
 * @create 2021-06-18-16:13
 */
public class InventoryManagerDaoImpl extends BaseDao<InventoryManager> implements InventoryManagerDao {

    Connection connection = JDBCUtils.getConnection();

    @Override
    public InventoryManager findInventoryManagerByLogin(String username, String password) {
        String sql = "select * from InventoryManager where username = ? and password = ?";
        return getInstance(connection,sql,username,password);
    }

    @Override
    public boolean changeInventoryManagerPwd(String password, int id) {
        String sql = "select * from InventoryManager set password = ? where id = ?";
        return update(connection,sql,password,id)>0;
    }
}
