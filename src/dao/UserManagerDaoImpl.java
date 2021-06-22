package dao;

import entry.UsersManager;
import utills.JDBCUtils;

import java.sql.Connection;

/**
 * @author 林敬舒
 * @create 2021-06-18-14:09
 */
public class UserManagerDaoImpl extends BaseDao<UsersManager> implements UsersManagerDao{

    Connection connection = JDBCUtils.getConnection();

    @Override
    public UsersManager findUsersManagerByLogin(String username, String password) {
        String sql = "select * from UsersManager where username = ? and password = ?";
        return getInstance(connection,sql,username,password);
    }

    @Override
    public boolean changeUserManagerPwd(String username,String oldPassword,String newPassword) {
        String sql = "select * from UserManager set password = ? where username = ? and password = ?";
        return update(connection,sql,newPassword,username,oldPassword)>0;
    }
}
